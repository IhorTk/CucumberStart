package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static CucumberHomeWork.context.TestContext.getWait;


public class MainPage extends BasePage {

    @FindBy(css = "#signin2")
    public WebElement signUpButton;

    @FindBy(css = "#login2")
    public WebElement logInButton;

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


    public MainPage sortingProducts(String groupProducts) {

        switch (groupProducts.toLowerCase()) {
            case "phones" -> sortItemPhone.click();
            case "monitors" -> sortItemMonitor.click();
            case "laptops" -> sortItemNotebook.click();
            default -> throw new IllegalStateException("Unexpected value: " + groupProducts);
        }
        getWait().until(ExpectedConditions.stalenessOf(productsCards.getFirst()));
        return new MainPage();
    }

    public int amountProductAll() {
        int amountAll = productsCards.size();
        while (nextPageButton.isDisplayed()) {
            nextPageButton.click();
            getWait().until(ExpectedConditions.stalenessOf(productsCards.getLast()));
            amountAll = amountAll + productsCards.size();
        }
        return amountAll;
    }
    public void getGoToCart() {
        goToCart.click();
        getWait().until(ExpectedConditions.visibilityOf(new CartPage().tableCartProduct));
        getWait().until(ExpectedConditions.visibilityOf(new CartPage().totalPrise));
    }

}
