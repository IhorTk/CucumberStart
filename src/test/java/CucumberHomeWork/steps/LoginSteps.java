package CucumberHomeWork.steps;

import CucumberHomeWork.pages.LoginPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static CucumberHomeWork.context.TestContext.alert;
import static CucumberHomeWork.context.TestContext.scenario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps{
    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        scenario.log("Hallo");
    }

    @When("enter data a registered user")
    public void enterDataARegisteredUser() {
        new LoginPage().loginRegisteredUser();
    }

    @Then("we will see the Welcome message")
    public void weWillSeeTheWelcomeMessage() {
        assertEquals("Welcome " + ConfigurationReader.get("standard_login"), new MainPage()
                .getWelcomeText());
    }

    @And("log out to the main page")
    public void logOutToTheMainPage() {
        new LoginPage().logOut();
    }

    @Then("we will see the Log in button")
    public void weWillSeeTheLogInButton() {
        assertTrue(new MainPage().logInButton.isDisplayed());
    }


    @When("enter data login{string} and password{string} a registered user")
    public void enterDataLoginAndPasswordARegisteredUser(String login, String password) {
        new LoginPage().loginAs(login,password);
    }


    @When("enter data login{word} and password{word} a registered user")
    public void enterDataLoginLoginAndPasswordPasswordARegisteredUser(String login, String password) {
        new LoginPage().loginAs(login,password);
    }

    @Then("we will see the Welcome message{string}")
    public void weWillSeeTheWelcomeMessageLogin(String login) {
        assertEquals("Welcome " + login, new MainPage()
                .getWelcomeText());
    }

    @When("enter data login{word} non-existent credentials and password{word} a registered user")
    public void enterDataLoginLoginNonExistentCredentials(String login, String password) {
        new LoginPage().login(login,password);
    }

    @Then("we will see the Alertuser message{string}")
    public void weWillSeeTheAlertMessageLogin(String alertNotUser) {
        assertEquals(alertNotUser,new LoginPage().inCorrectDataUser());
    }

    @And("user confirm Alert message")
    public void userConfirmAlertMessage() {
        alert.accept();
    }

    @Then("we will see the Alertpassword message{string}")
    public void weWillSeeTheAlertMessagePassword(String alertWrongPassword) {
        assertEquals(alertWrongPassword,new LoginPage().inCorrectDataUser());
    }
}
