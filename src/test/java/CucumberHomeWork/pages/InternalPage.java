package CucumberHomeWork.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.*;
import static CucumberHomeWork.context.TestContext.alert;


public class InternalPage extends BasePage {

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;

    public void getHomeButton() {
        homeButton.click();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = getDriver().switchTo().alert();
        return alert.getText();
    }


}
