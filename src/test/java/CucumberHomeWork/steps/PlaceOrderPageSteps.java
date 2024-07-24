package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CartPage;
import CucumberHomeWork.pages.PlaceOrderPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceOrderPageSteps {


    @When("The user go to place order page")
    public void theUserGoToPlaceOrderPage() {
        new CartPage().goToPlaceOrder();
    }


    @And("The user enters test data to place an order and confirms the entered data")
    public void theUserEntersTestDataToPlaceAnOrder() {
        new PlaceOrderPage().inputDataPlaceOrderBase();
    }


    @Then("Check that the data is correct and amount is {string}")
    public void checkThatTheDataIsCorrectAndAmountIsPrice(String sum) {
        assertTrue(new PlaceOrderPage().confirmPurchase.getText()
                .contains(ConfigurationReader.get("thanks_message")));
        assertTrue(new PlaceOrderPage().confirmPurchase.getText()
                .contains("Name: " + ConfigurationReader.get("name")));
        assertTrue(new PlaceOrderPage().confirmPurchase.getText()
                .contains("Card Number: " + ConfigurationReader.get("card")));
        assertTrue(new PlaceOrderPage().confirmPurchase.getText()
                .contains("Amount: " + sum));
    }

    @And("The user confirms order")
    public void theUserConfirmsOrder() {
        new PlaceOrderPage().confirmPurchase();
    }

    @And("The user enters incomplete test data to place an order and confirms the entered data")
    public void theUserEntersIncompleteTestDataToPlaceAnOrderAndConfirmsTheEnteredData() {
        new PlaceOrderPage().inputNoCompleteDataPlaceOrderAs();
    }
}
