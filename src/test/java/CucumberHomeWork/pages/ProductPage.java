package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    @FindBy(css = ".btn-success")
    public WebElement productToCartButton;


}
