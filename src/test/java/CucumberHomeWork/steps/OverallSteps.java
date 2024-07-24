package CucumberHomeWork.steps;

import CucumberHomeWork.pages.InternalPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static CucumberHomeWork.context.TestContext.alert;
import static CucumberHomeWork.context.TestContext.scenario;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverallSteps {



    @Given("The user is on the main page")
    public void user_is_on_the_main_page() {
        if (new MainPage().categoriesButton.isDisplayed()) {
            scenario.log("Hallo");
        }
    }


    @Then("The user will see the error message {string}")
    public void userWillSeeTheAlertMessageLogin(String alertDisplayed) {
        assertEquals(ConfigurationReader.get(alertDisplayed), new InternalPage().getAlertText());
    }

    @And("The user confirm Alert message")
    public void userConfirmAlertMessage() {
        alert.accept();
    }
}
