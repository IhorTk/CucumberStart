package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CartPage;
import CucumberHomeWork.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageSteps {

    @When("Sort products into {string}")
    public void sortProductsIntoGroup(String group) {
        new MainPage().sortingArticles(group);
    }

    @And("Add to cart  {string}.")
    public void addToCartProduct(String product) {
        new CartPage().addArticleToCartAny(product);
    }

    @Then("Go to cart")
    public void goToCart() {
        new MainPage().getGoToCart();
    }

    @Then("Check that the {string} has been added to the cart and the {int} is correct")
    public void checkThatTheProductHasBeenAddedToTheCartAndThePriseIsCorrect(String product, int price) {
        assertEquals(1, new CartPage().rowsListOrdersTable.size());
        assertEquals(price, Long.parseLong(new CartPage().totalPrise.getText()));
        assertTrue(new CartPage().rowsListOrdersTable.getFirst().getText().contains(product));
    }


//    @When("The user takes turns finding {string} by {string} and adding them to the cart")
//    public void theUserTakesTurnsFindingProductByGroupAndAddingThemToTheCart() {
//    }
//
//    @And("Check that  all {string} has been added to the cart and the {int} is correct")
//    public void checkThatAllProductHasBeenAddedToTheCartAndThePriceIsCorrect() {
//    }
}
