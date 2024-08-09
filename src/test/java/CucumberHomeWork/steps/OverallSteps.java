package CucumberHomeWork.steps;

import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverallSteps {
    MainPage mainPage = new MainPage();

    @Given("The user is on the main page")
    public void user_is_on_the_main_page() {
        assertTrue(mainPage.categoriesButton.isDisplayed());
        scenario.log("Hallo");
    }

    @Then("The user will see the error message {string}")
    public void userWillSeeTheAlertMessageLogin(String alertDisplayed) {
        getWait().until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        String alertExpected = alert.getText();
        assertEquals(alertExpected,ConfigurationReader.get(alertDisplayed));
    }

    @And("The user confirm Alert message")
    public void userConfirmAlertMessage() {
        alert.accept();
    }
}
