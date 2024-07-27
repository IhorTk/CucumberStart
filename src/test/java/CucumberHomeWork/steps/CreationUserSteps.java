package CucumberHomeWork.steps;

import CucumberHomeWork.pages.CreationUserPage;
import CucumberHomeWork.pages.MainPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CreationUserSteps {

    CreationUserPage creationUserPage = new CreationUserPage();
    MainPage mainPage =new MainPage();

    @When("press to button Sign up")
    public void pressToButtonSignUp() {
        mainPage.signUpButton.click();
    }

    @And("When enter data login{word} and password{word} a registered user")
    public void whenEnterDataLoginLoginAndPasswordPasswordARegisteredUser(String login, String password) {
        creationUserPage.inputNewUserName.sendKeys(login);
        creationUserPage.inputNewUserPassword.sendKeys(password);
        creationUserPage.okCreateNewUser.click();
    }

}
