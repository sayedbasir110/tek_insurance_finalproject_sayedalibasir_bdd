package tek_insurance.bdd.broswers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser implements BaseBrowser{
    @Override
    public WebDriver openBrowser(boolean isHeadless){
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}
