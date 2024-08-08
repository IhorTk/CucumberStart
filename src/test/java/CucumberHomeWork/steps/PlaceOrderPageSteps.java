package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CartPage;
import CucumberHomeWork.pages.PlaceOrderPage;
import CucumberHomeWork.utils.ConfigurationReader;
import CucumberHomeWork.utils.DataUser;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaceOrderPageSteps {
    PlaceOrderPage placeOrderPage  = new PlaceOrderPage();
    CartPage cartPage = new CartPage();
    public List<DataUser> objects = null;

    @DataTableType
    public DataUser addDataUser(Map<String,String> dataUser){
        return new DataUser(dataUser.get("name"), dataUser.get("country"),dataUser.get("city"),dataUser.get("card"),
                dataUser.get("month"), dataUser.get("year"));
    }

    @When("The user go to place order page")
    public void theUserGoToPlaceOrderPage() {
       cartPage.goPlaceOrderButton.click();
    }

    @And("The user enters test data to place an order")
    public List<DataUser> theUserEntersTestDataToPlaceAnOrder(List<DataUser> dataUsers) {
        for (DataUser dataUser:dataUsers){
            placeOrderPage.inputName.sendKeys(dataUser.name);
            placeOrderPage.inputCountry.sendKeys(dataUser.country);
            placeOrderPage.inputCity.sendKeys(dataUser.city);
            placeOrderPage.inputCard.sendKeys(dataUser.card);
            placeOrderPage.inputMonth.sendKeys(dataUser.month);
            placeOrderPage.inputYear.sendKeys(dataUser.year);
        }
        objects=dataUsers;
        return objects;
    }

    @And("confirms the entered data")
    public void confirmsTheEnteredData() {
        placeOrderPage.okPurchaseButton.click();
    }

    @Then("Check that the data is correct and amount is {string}")
    public void checkThatTheDataIsCorrectAndAmountIsPrice(String sum) {
        assertTrue(placeOrderPage.confirmPurchase.getText()
                .contains(ConfigurationReader.get("thanks_message")));
        assertTrue(placeOrderPage.confirmPurchase.getText()
                .contains("Name: " + objects.getFirst().name));
        assertTrue(placeOrderPage.confirmPurchase.getText()
                .contains("Card Number: " + objects.getFirst().card));
        assertTrue(new PlaceOrderPage().confirmPurchase.getText()
                .contains("Amount: " + sum));
    }

    @And("The user confirms order")
    public void theUserConfirmsOrder() {
        placeOrderPage.confirmPurchaseButton.click();
    }

    @And("The user enters incomplete test data to place an order")
    public void theUserEntersIncompleteTestDataToPlaceAnOrder(List<DataUser> dataUsers) {
        for (DataUser dataUser:dataUsers){
            placeOrderPage.inputCountry.sendKeys(dataUser.country);
            placeOrderPage.inputCity.sendKeys(dataUser.city);
            placeOrderPage.inputMonth.sendKeys(dataUser.month);
            placeOrderPage.inputYear.sendKeys(dataUser.year);
        }
    }
}
