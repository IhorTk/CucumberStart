package CucumberHomeWork.steps;

import CucumberHomeWork.pages.LoginPage;
import CucumberHomeWork.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.getWait;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();


    @When("enter data login{string} and password {string}")
    public void enterDataLoginLoginAndPassword(String login, String password) {
        mainPage.logInButton.click();
        loginPage.inputUserName.sendKeys(login);
        loginPage.inputUserPassword.sendKeys(password);
        loginPage.inputLogin.click();
    }

    @Then("The user will see the Welcome message {string}")
    public void userWillSeeTheWelcomeMessageLogin(String login) {
        getWait().until(ExpectedConditions.visibilityOf(mainPage.welcomeText));
        assertEquals("Welcome " + login, mainPage
                .welcomeText.getText());
    }

    @And("log out to the main page")
    public void logOutToTheMainPage() {
        mainPage.logOutButton.click();
    }

    @Then("The user can see the Log in button")
    public void theUserDoesNotSeeTheWelcomeMessage() {
        assertTrue(mainPage.logInButton.isDisplayed());
    }





}
