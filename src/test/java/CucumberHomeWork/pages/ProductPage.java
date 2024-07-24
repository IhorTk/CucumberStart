package CucumberHomeWork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    @FindBy(css = ".btn-success")
    public WebElement productToCartButton;

    public void getAddToCart() {
        productToCartButton.click();
    }

    public void searchProduct(String nameProduct) {

        for (WebElement product : new MainPage().productsCards) {
            if (product.getText().contains(nameProduct)) {
                product.click();
                break;
            }
        }
    }
}
