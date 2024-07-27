package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage {

    @FindBy(css = "#name")
    public WebElement inputName;

    @FindBy(css = "#country")
    public WebElement inputCountry;

    @FindBy(css = "#city")
    public WebElement inputCity;

    @FindBy(css = "#card")
    public WebElement inputCard;

    @FindBy(css = "#month")
    public WebElement inputMonth;

    @FindBy(css = "#year")
    public WebElement inputYear;

    @FindBy(css = "button.btn-primary[onclick='purchaseOrder()']")
    public WebElement okPurchaseButton;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible")
    public WebElement confirmPurchase;

    @FindBy(css = "button.confirm.btn-primary")
    public WebElement confirmPurchaseButton;
}
