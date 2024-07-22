package CucumberHomeWork.pages;

import CucumberHomeWork.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static CucumberHomeWork.context.TestContext.*;

public class CartPage extends BasePage {


    @FindBy(css = "td>a[onclick^='deleteItem']")
    public List<WebElement> deleteArticleButton;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    public WebElement tableCartProduct;

    @FindBy(css = "#totalp")
    public WebElement totalPrise;

    @FindBy(css = "#tbodyid>tr")
    public List<WebElement> rowsListOrdersTable;

    @FindBy(css = "button.btn-success")
    public WebElement goPlaceOrderButton;


    public void addArticleToCartAny(String nameArticle) {
        new ArticlePage().searchArticle(nameArticle);
        addArticleToCart();
        new InternalPage().getHomeButton();
    }


    public void addArticleToCart() {
        new ArticlePage().getAddToCart();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        if (alert.getText().equals(ConfigurationReader.get("alertArticle"))) {
            alert.accept();
        }
    }


    public void remoteArticleFromCart(String nameArticle) {
        int count = 0;
        for (WebElement order : rowsListOrdersTable) {
            if (order.getText().contains(nameArticle)) {
                break;
            }
            count++;
        }
        deleteArticleButton.get(count).click();
        wait.until(ExpectedConditions.stalenessOf(rowsListOrdersTable.getLast()));
        wait.until(ExpectedConditions.visibilityOf(totalPrise));
    }


    public void goToPlaceOrder() {
        goPlaceOrderButton.click();
    }

}
