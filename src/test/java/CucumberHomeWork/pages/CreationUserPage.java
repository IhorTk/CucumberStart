package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreationUserPage extends BasePage {

    @FindBy(css = "#sign-username")
    public WebElement inputNewUserName;

    @FindBy(css = "#sign-password")
    public WebElement inputNewUserPassword;

    @FindBy(css = "button.btn-primary[onclick='register()']")
    public WebElement okCreateNewUser;


    public void createUser(String login, String password) {
        inputNewUserName.sendKeys(login);
        inputNewUserPassword.sendKeys(password);
        okCreateNewUser.click();
    }

}
