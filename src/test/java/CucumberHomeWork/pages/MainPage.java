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

    @FindBy(css = ".carousel-inner")
    public WebElement carouselInner;

    @FindBy(css = ".carousel-control-next-icon")
    public WebElement carouselNextIcon;

    @FindBy(css = "carousel-control-prev-icon")
    public WebElement carouselPrevIcon;

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

    @FindBy(css = ".page-link#prev2")
    public WebElement prevPageButton;


    @FindBy(css = "a.hrefch")
    public List<WebElement> articlesCards;


    public String getWelcomeText() {

        return welcomeText.getText();
    }


    public int amountArticle() {
        return articlesCards.size();
    }


    public MainPage sortingArticles(String nameArticles) {

        switch (nameArticles.toLowerCase()) {
            case "phones" -> sortItemPhone.click();
            case "monitors" -> sortItemMonitor.click();
            case "laptops" -> sortItemNotebook.click();
            default -> throw new IllegalStateException("Unexpected value: " + nameArticles.toLowerCase());
        }
        wait.until(ExpectedConditions.stalenessOf(articlesCards.getFirst()));
        return new MainPage();
    }

    public int amountArticleAll() {
        int amountAll = amountArticle();
        while (nextPageButton.isDisplayed()) {
            nextPageButton.click();
            wait.until(ExpectedConditions.stalenessOf(articlesCards.getLast()));
            amountAll = amountAll + amountArticle();
        }
        return amountAll;
    }

}
