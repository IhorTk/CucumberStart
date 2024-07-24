package CucumberHomeWork.steps;

import CucumberHomeWork.context.TestContext;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static CucumberHomeWork.context.TestContext.*;

public class Hooks {
    @Before
    public void beforeMethod(Scenario scenario){
        getDriver().get(ConfigurationReader.get("base_url"));
        TestContext.scenario=scenario;
    }

    @After
    public void afterMethod(){
        if (scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) getDriver();

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
       if(getDriver() !=null){
           closeDriver();
       }

    }

}
