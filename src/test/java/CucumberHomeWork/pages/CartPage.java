package CucumberHomeWork.pages;

import CucumberHomeWork.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static CucumberHomeWork.context.TestContext.*;

public class CartPage extends BasePage {


    @FindBy(css = "td>a[onclick^='deleteItem']")
    public List<WebElement> deleteProductButton;

    @FindBy(xpath = "//*[@id='page-wrapper']")
    public WebElement tableCartProduct;

    @FindBy(css = "#totalp")
    public WebElement totalPrise;

    @FindBy(css = "button.btn-success")
    public WebElement goPlaceOrderButton;


    public void addProductToCartAny(String Product) {
        new ProductPage().searchProduct(Product);
        addProductToCart();
        new InternalPage().getHomeButton();
    }


    public void addProductToCart() {
        new ProductPage().getAddToCart();
        getWait().until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        if (alert.getText().equals(ConfigurationReader.get("alertProduct"))) {
            alert.accept();
        }
    }


    public void remoteProductFromCart(String nameProduct) {
        List<WebElement> listOrders = tableWork.getListRowsWithoutHead(tableCartProduct);
        int count = 0;
        for (WebElement order : listOrders) {
            if (order.getText().contains(nameProduct)) {
                break;
            }
            count++;
        }
        deleteProductButton.get(count).click();
        getWait().until(ExpectedConditions.stalenessOf(listOrders.getFirst()));
        getWait().until(ExpectedConditions.stalenessOf(totalPrise));
    }


    public void goToPlaceOrder() {
        goPlaceOrderButton.click();
    }

}
