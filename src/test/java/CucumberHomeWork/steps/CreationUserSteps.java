package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CreationUserPage;
import CucumberHomeWork.pages.MainPage;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class CreationUserSteps {

    @When("press to button Sign up")
    public void pressToButtonSignUp() {
        new MainPage().signUpButton.click();
    }

    @And("When enter data login{word} and password{word} a registered user")
    public void whenEnterDataLoginLoginAndPasswordPasswordARegisteredUser(String login, String password) {
        new CreationUserPage().createUserAs(login,password);
    }

    @Then("The user will see the error registration message {string}")
    public void weWillSeeTheErrorRegistrationMessage(String string) {
        assertEquals(ConfigurationReader.get(string), ConfigurationReader.get(string) );
    }

}
