package CucumberHomeWork.pages;

import CucumberHomeWork.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.*;

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
    public WebElement itogPurschase;

    @FindBy(css = "button.confirm.btn-primary")
    public WebElement confirmPurchaseButton;


    public void confirmPurchase() {
        confirmPurchaseButton.click();
    }

    public void inputDataPlaceOrderBase() {
        inputCompleteDataPlaceOrderAs(ConfigurationReader.get("name"), ConfigurationReader.get("country"),
                ConfigurationReader.get("city"), ConfigurationReader.get("card"),
                ConfigurationReader.get("month"), ConfigurationReader.get("year"));
    }

    public String inputNoCompleteDataPlaceOrderAs() {

        inputDataPlaceOrder("", ConfigurationReader.get("country"), ConfigurationReader.get("city"),
                "", ConfigurationReader.get("month"), ConfigurationReader.get("year"));
        wait.until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public void inputCompleteDataPlaceOrderAs(String name, String country, String city, String card, String month, String year) {
        inputDataPlaceOrder(name, country, city, card, month, year);
        wait.until(ExpectedConditions.visibilityOf(itogPurschase));
    }

    private void inputDataPlaceOrder(String name, String country, String city, String card, String month, String year) {
        inputName.sendKeys(name);
        inputCountry.sendKeys(country);
        inputCity.sendKeys(city);
        inputCard.sendKeys(card);
        inputMonth.sendKeys(month);
        inputYear.sendKeys(year);
        okPurchaseButton.click();
    }

}
