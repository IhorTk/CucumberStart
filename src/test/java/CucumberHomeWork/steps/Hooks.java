package CucumberHomeWork.steps;

import CucumberHomeWork.context.TestContext;
import CucumberHomeWork.utils.ConfigurationReader;
import CucumberHomeWork.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static CucumberHomeWork.context.TestContext.*;

public class Hooks {
    @Before
    public void set(Scenario scenario) {
        WebDriver driver = DriverFactory.get();
        TestContext.setDriver(driver);
        driver.get(ConfigurationReader.get("base_url"));
        TestContext.scenario = scenario;
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = getDriver();
            if (driver != null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            }
        }
        closeDriver();
    }

    private  void closeDriver(){
        WebDriver driver = getDriver();
        if (driver!=null){
            driver.quit();
            remoteDriver();
        }
    }
}
