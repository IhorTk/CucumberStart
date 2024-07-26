package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {


    @FindBy(css = "td>a[onclick^='deleteItem']")
    public List<WebElement> deleteProductButton;

    @FindBy(xpath = "//*[@id='page-wrapper']")
    public WebElement tableCartProduct;

    @FindBy(css = "#totalp")
    public WebElement totalPrise;

    @FindBy(css = "button.btn-success")
    public WebElement goPlaceOrderButton;


}
