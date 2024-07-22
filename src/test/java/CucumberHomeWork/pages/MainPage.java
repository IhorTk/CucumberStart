package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static CucumberHomeWork.context.TestContext.wait;

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
    public List<WebElement> articlesCards;


    public MainPage sortingArticles(String groupArticles) {

        switch (groupArticles.toLowerCase()) {
            case "phones" -> sortItemPhone.click();
            case "monitors" -> sortItemMonitor.click();
            case "laptops" -> sortItemNotebook.click();
            default -> throw new IllegalStateException("Unexpected value: " + groupArticles);
        }
        wait.until(ExpectedConditions.stalenessOf(articlesCards.getLast()));
        return new MainPage();
    }

    public int amountArticleAll() {
        int amountAll = articlesCards.size();
        while (nextPageButton.isDisplayed()) {
            nextPageButton.click();
            wait.until(ExpectedConditions.stalenessOf(articlesCards.getLast()));
            amountAll = amountAll + articlesCards.size();
        }
        return amountAll;
    }
    public CartPage getGoToCart() {
        goToCart.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(new CartPage().tableCartProduct));
        wait.until(ExpectedConditions.visibilityOf(new CartPage().totalPrise));
        return new CartPage();
    }

}
