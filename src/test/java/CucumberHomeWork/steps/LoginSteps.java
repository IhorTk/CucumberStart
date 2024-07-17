package CucumberHomeWork.steps;

import CucumberHomeWork.pages.LoginPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static CucumberHomeWork.context.TestContext.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps{
    @Given("The user is on the main page")
    public void user_is_on_the_main_page() {
        scenario.log("Hallo");
    }

    @When("enter data a registered user")
    public void enterDataARegisteredUser() {
        new LoginPage().loginAsRegisteredUser();
    }

    @Then("The user will see the Welcome message")
    public void userWillSeeTheWelcomeMessage() {
        assertEquals("Welcome " + ConfigurationReader.get("standard_login"), new MainPage()
                .getWelcomeText());
    }

    @And("log out to the main page")
    public void logOutToTheMainPage() {
        new LoginPage().logOutButton.click();
    }


    @Then("The user can see the Log in button")
    public void theUserDoesNotSeeTheWelcomeMessage() {
        assertTrue(new MainPage().logInButton.isDisplayed());
    }


//    @When("enter data login{string} and password{string} a registered user")
//    public void enterDataLoginAndPasswordARegisteredUser(String login, String password) {//*
//        new LoginPage().loginAs(login,password);
//    }


    @When("enter data login{word} and password{word} a registered user")
    public void enterDataLoginLoginAndPasswordPasswordARegisteredUser(String login, String password) {
        new LoginPage().loginAs(login,password);
    }

    @Then("The user will see the Welcome message{string}")
    public void userWillSeeTheWelcomeMessageLogin(String login) {
        assertEquals("Welcome " + login, new MainPage()
                .getWelcomeText());
    }

    @When("enter data login{word} non-existent credentials and password{word} a registered user")
    public void enterDataLoginLoginNonExistentCredentials(String login, String password) {
        new LoginPage().login(login,password);
    }

    @Then("The user will see the error User message {string}")
    public void userWillSeeTheAlertMessageLogin(String alertNotUserExist) {
        assertEquals(ConfigurationReader.get(alertNotUserExist),new LoginPage().inCorrectDataUser());
    }

    @And("The user confirm Alert message")
    public void userConfirmAlertMessage() {
        alert.accept();
    }

    @Then("The user will see the error Password message {string}")
    public void userWillSeeTheAlertMessagePassword(String alertWrongPassword) {
        assertEquals(ConfigurationReader.get(alertWrongPassword),new LoginPage().inCorrectDataUser());
    }

}
