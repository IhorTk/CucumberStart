package CucumberHomeWork.context;

import CucumberHomeWork.utils.ConfigurationReader;
import CucumberHomeWork.utils.DriverFactory;
import CucumberHomeWork.utils.TableWork;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {

   private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
   private static final ThreadLocal<WebDriverWait> waitThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Actions> actionThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<JavascriptExecutor> javascriptExecutorThreadLocal = new ThreadLocal<>();

    public static Alert alert;
    public static Scenario scenario ;
    public static TableWork tableWork;

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }
    public static WebDriverWait getWait(){
     return waitThreadLocal.get();
    }

    public static JavascriptExecutor getJs(){
        return javascriptExecutorThreadLocal.get();
    }

    public static Actions getActions(){
        return actionThreadLocal.get();
    }

   public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
        waitThreadLocal.set(new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout")))));
        javascriptExecutorThreadLocal.set((JavascriptExecutor) driver);
        actionThreadLocal.set(new Actions(driver));
   }


    public static void remoteDriver() {
        driverThreadLocal.remove();
    }
}
