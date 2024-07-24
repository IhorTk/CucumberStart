package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.*;

public class CreationUserPage extends BasePage {

    @FindBy(css = "#sign-username")
    public WebElement inputNewUserName;

    @FindBy(css = "#sign-password")
    public WebElement inputNewUserPassword;

    @FindBy(css = "button.btn-primary[onclick='register()']")
    public WebElement okCreateNewUser;


    public String createUserAs(String login, String password) {
        createUser(login, password);
        wait.until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        return alert.getText();

    }

    private void createUser(String login, String password) {
        inputNewUserName.sendKeys(login);
        inputNewUserPassword.sendKeys(password);
        okCreateNewUser.click();
    }

}
