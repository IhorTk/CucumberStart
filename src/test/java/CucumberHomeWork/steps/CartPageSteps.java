package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CartPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.Cart;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static CucumberHomeWork.context.TestContext.tableWork;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageSteps {


    @DataTableType
    public Cart addProduct(Map<String,String> table){
        return new Cart( table.get("group"), table.get("title"), table.get("price"));
    }

    @When("Sort products into {string}")
    public void sortProductsIntoGroup(String group) {
        new MainPage().sortingProducts(group);
    }

    @And("Add to cart  {string}.")
    public void addToCartProduct(String product) {
        new CartPage().addProductToCartAny(product);
    }

    @Then("Go to cart")
    public void goToCart() {
        new MainPage().getGoToCart();
    }

    @Then("Check that the {string} has been added to the cart and the {double} is correct")
    public void checkThatTheProductHasBeenAddedToTheCartAndThePriseIsCorrect(String product, double price) {
        assertEquals(1, tableWork.getListRowsWithoutHead(new CartPage().tableCartProduct).size());
        assertEquals(price, Double.parseDouble(new CartPage().totalPrise.getText()));
        assertTrue(tableWork.getListRowsWithoutHead(new CartPage().tableCartProduct).getFirst().getText().contains(product));
    }

    @When("The user takes turns adding product to the cart")

    public void theUserTakesTurnsAddingProductToTheCart(List<Cart> carts) {
       for (Cart cart:carts){
           new MainPage().sortingProducts(cart.group);
           new CartPage().addProductToCartAny(cart.title);
       }
    }


    @Then("Remove one item from cart {string}")
    public void removeOneItemFromCart(String nameProduct) {
        new CartPage().remoteProductFromCart(nameProduct);

    }


    @And("Check sure all items in your cart and total price is correct")
    public void checkSureAllItemsInYourCartAndTotalPriceIsCorrect(List<Cart> carts) {

        assertEquals(tableWork.getTotalSum(new CartPage().tableCartProduct, "Price"),
                Double.parseDouble(new CartPage().totalPrise.getText()));
        tableWork.getTotalSum(new CartPage().tableCartProduct, "Price");
        assertEquals(tableWork.getListRowsWithoutHead(new CartPage().tableCartProduct).size(), carts.size());
    }


}

