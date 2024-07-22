package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ArticlePage extends BasePage {

    @FindBy(css = ".btn-success")
    public WebElement articleToCartButton;

    public void getAddToCart() {
        articleToCartButton.click();
    }

    public void searchArticle(String nameArticle) {

        for (WebElement article : new MainPage().articlesCards) {
            if (article.getText().contains(nameArticle)) {
                article.click();
                break;
            }
        }
    }
}
