package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CartPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.pages.ProductPage;
import CucumberHomeWork.utils.Cart;
import CucumberHomeWork.utils.ConfigurationReader;
import CucumberHomeWork.utils.TableWork;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

import static CucumberHomeWork.context.TestContext.*;
import static CucumberHomeWork.context.TestContext.alert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageSteps {

    public TableWork tableWork = new TableWork();
    CartPage cartPage = new CartPage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();


    @DataTableType
    public Cart addProduct(Map<String,String> table){
        return new Cart( table.get("group"), table.get("title"), table.get("price"));
    }

    @When("Sort products into {string}")
    public void sortProductsIntoGroup(String group) {
        switch (group.toLowerCase()) {
            case "phones" -> mainPage.sortItemPhone.click();
            case "monitors" -> mainPage.sortItemMonitor.click();
            case "laptops" -> mainPage.sortItemNotebook.click();
            default -> throw new IllegalStateException("Unexpected value: " + group);
        }
        getWait().until(ExpectedConditions.stalenessOf(mainPage.productsCards.getFirst()));
    }

    @And("Add to cart {string}.")
    public void addToCartProduct(String nameProduct) {

        // search for a product and go to its page
        for (WebElement product : mainPage.productsCards) {
            if (product.getText().contains(nameProduct)) {
                product.click();
                break;
            }
        }

        // add product to cart
        productPage.productToCartButton.click();
        getWait().until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        if (alert.getText().equals(ConfigurationReader.get("alertProduct"))) {
            alert.accept();
        }

        //go to MainPage
        mainPage.homeButton.click();
    }

    @Then("Go to cart")
    public void goToCart() {
        mainPage.goToCart.click();
        getWait().until(ExpectedConditions.visibilityOf(cartPage.tableCartProduct));
        getWait().until(ExpectedConditions.visibilityOf(cartPage.totalPrise));
    }

    @Then("Check that the {string} has been added to the cart and the {double} is correct")
    public void checkThatTheProductHasBeenAddedToTheCartAndThePriseIsCorrect(String product, double price) {
        assertEquals(1, tableWork.getListRowsWithoutHead(cartPage.tableCartProduct).size());
        assertEquals(price, Double.parseDouble(cartPage.totalPrise.getText()));
        assertTrue(tableWork.getListRowsWithoutHead(cartPage.tableCartProduct).getFirst().getText().contains(product));
    }

    @When("The user takes turns adding product to the cart")

    public void theUserTakesTurnsAddingProductToTheCart(List<Cart> carts) {
       for (Cart cart:carts){
           sortProductsIntoGroup(cart.group);
           addToCartProduct(cart.title);
       }
    }


    @Then("Remove one item from cart {string}")
    public void removeOneItemFromCart(String nameProduct) {
        List<WebElement> listOrders = tableWork.getListRowsWithoutHead(cartPage.tableCartProduct);
        int count = 0;
        for (WebElement order : listOrders) {
            if (order.getText().contains(nameProduct)) {
                break;
            }
            count++;
        }
        cartPage.deleteProductButton.get(count).click();
        getWait().until(ExpectedConditions.stalenessOf(listOrders.getFirst()));
        getWait().until(ExpectedConditions.visibilityOf(cartPage.totalPrise));

    }


    @And("Check sure all items in your cart and total price is correct")
    public void checkSureAllItemsInYourCartAndTotalPriceIsCorrect(List<Cart> carts) {

        assertEquals(tableWork.getTotalSum(cartPage.tableCartProduct, "Price"),
                Double.parseDouble(cartPage.totalPrise.getText()));
        tableWork.getTotalSum(cartPage.tableCartProduct, "Price");
        assertEquals(tableWork.getListRowsWithoutHead(cartPage.tableCartProduct).size(), carts.size());
    }

}

