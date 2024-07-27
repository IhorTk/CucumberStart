package CucumberHomeWork.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "#loginusername")
    public WebElement inputUserName;

    @FindBy(css = "#loginpassword")
    public WebElement inputUserPassword;

    @FindBy(css = "button.btn-primary[onclick='logIn()']")
    public WebElement inputLogin;

}
