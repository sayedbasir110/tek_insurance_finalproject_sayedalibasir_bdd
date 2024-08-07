package bdd.tek.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseSetup {
    private static WebDriver driver;
    // method to setup the browser
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa.insurance.tekschool-students.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    // method to close the browser
    public void quitBrowser(){
        if (driver != null) driver.quit();
    }
    // method to read the driver variable
    public static WebDriver getDriver() {
        return driver;
    }
}
