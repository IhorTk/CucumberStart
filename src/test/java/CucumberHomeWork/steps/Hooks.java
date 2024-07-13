package CucumberHomeWork.steps;

import CucumberHomeWork.context.TestContext;
import CucumberHomeWork.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static CucumberHomeWork.context.TestContext.getDriver;
import static CucumberHomeWork.context.TestContext.closeDriver;

public class Hooks {
    @Before
    public void beforeMethod(Scenario scenario){
        getDriver().get(ConfigurationReader.get("base_url"));
        TestContext.scenario=scenario;
    }

    @After
    public void afterMethod(){
       if(getDriver() !=null){
           closeDriver();
       }

    }

}
