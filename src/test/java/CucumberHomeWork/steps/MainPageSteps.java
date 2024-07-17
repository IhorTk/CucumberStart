package CucumberHomeWork.steps;

import CucumberHomeWork.pages.MainPage;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageSteps {
    @When("The amount of products on the main page should be {int}")
    public void theAmountOfProductsOnTheMainPageShouldBe(int amount) {
        assertEquals(amount, new MainPage().articlesCards.size());
    }

    @When("counting products by moving through pages, there should be {int} of them")
    public void countingProductsByMovingThroughPagesThereShouldBeOfThem(int amountAll) {
        assertEquals(amountAll,new MainPage().amountArticleAll());
    }

    @When("sorting products by group{word}, there should be {int} of them")
    public void sortingProductsByGroupThereShouldBeAmountOfThem(String group, int amount) {
        assertEquals(amount, new MainPage().sortingArticles(group).amountArticle());
    }

//    @When("sorting products by group {string}, there should be {int} of them")
//    public void sortingProductsByGroupThereShouldBeOfThem(String group, Integer amount) {
//        assertEquals(amount, new MainPage().sortingArticles(group).amountArticle());
//    }
}
