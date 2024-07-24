package CucumberHomeWork.pages;

import CucumberHomeWork.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.*;

public class LoginPage extends BasePage {

    @FindBy(css = "#loginusername")
    public WebElement inputUserName;

    @FindBy(css = "#loginpassword")
    public WebElement inputUserPassword;

    @FindBy(css = "button.btn-primary[onclick='logIn()']")
    public WebElement inputLogin;

    @FindBy(css = "#logout2")
    public WebElement logOutButton;


    public void loginAsRegisteredUser() {
        loginAs(ConfigurationReader.get("standard_login"), ConfigurationReader.get("standart_password"));
    }

    public void loginAs(String login, String password) {
        login(login, password);
        getWait().until(ExpectedConditions.visibilityOf(new MainPage().welcomeText));
    }


    public void login(String login, String password) {
        new MainPage().logInButton.click();
        inputUserName.sendKeys(login);
        inputUserPassword.sendKeys(password);
        inputLogin.click();
    }
}
