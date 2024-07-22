package CucumberHomeWork.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InternalPage extends BasePage {

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;

    public void getHomeButton() {
        homeButton.click();
    }


}
