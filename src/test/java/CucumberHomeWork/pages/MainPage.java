package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(css = "#signin2")
    public WebElement signUpButton;

    @FindBy(css = "#login2")
    public WebElement logInButton;

    @FindBy(css = "#logout2")
    public WebElement logOutButton;

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;

    @FindBy(css = ".list-group-item#cat")
    public WebElement categoriesButton;

    @FindBy(css = "#itemc[onclick=\"byCat('phone')\"]")
    public WebElement sortItemPhone;

    @FindBy(css = "#itemc[onclick=\"byCat('notebook')\"]")
    public WebElement sortItemNotebook;

    @FindBy(css = "#itemc[onclick=\"byCat('monitor')\"]")
    public WebElement sortItemMonitor;

    @FindBy(css = "#nameofuser")
    public WebElement welcomeText;

    @FindBy(css = "#cartur")
    public WebElement goToCart;

    @FindBy(css = ".page-link#next2")
    public WebElement nextPageButton;

    @FindBy(css = "a.hrefch")
    public List<WebElement> productsCards;
}
