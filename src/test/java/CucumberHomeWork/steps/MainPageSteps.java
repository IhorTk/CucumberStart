package CucumberHomeWork.steps;

import CucumberHomeWork.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static CucumberHomeWork.context.TestContext.wait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @When("The amount of products on the main page should be {int}")
    public void theAmountOfProductsOnTheMainPageShouldBe(int amount) {
        assertEquals(amount, mainPage.productsCards.size());
    }

    @When("counting products by moving through pages, there should be {int} of them")
    public void countingProductsByMovingThroughPagesThereShouldBeOfThem(int amountAll) {
        int amountAllExpected = mainPage.productsCards.size();
        while (mainPage.nextPageButton.isDisplayed()) {
            mainPage.nextPageButton.click();
            wait.until(ExpectedConditions.stalenessOf(mainPage.productsCards.getLast()));
            amountAllExpected = amountAllExpected + mainPage.productsCards.size();
        }
        assertEquals(amountAll,amountAllExpected);
    }


    @Then("Check amount all items, there should be {int} of them")
    public void checkAmountAllItemsThereShouldBeAmountOfThem(int amount) {
        assertEquals(amount, mainPage.productsCards.size());
    }
}
