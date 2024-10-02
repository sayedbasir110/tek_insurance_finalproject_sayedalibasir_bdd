package tek_insurance.bdd.base;

import tek_insurance.bdd.broswers.BaseBrowser;
import tek_insurance.bdd.broswers.ChromeBrowser;
import tek_insurance.bdd.broswers.EdgeBrowser;
import tek_insurance.bdd.broswers.FirefoxBrowser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    private final Properties properties;
    private static WebDriver driver;
    protected final int waitTimeInSeconds = 25;
    public BaseSetup(){
        try{
            String configFilePath = getConfigFilePath();
            LOGGER.info("Reading config file from {}", configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }
        catch (IOException ex){
            throw new RuntimeException("\"Something wrong with Config file", ex);
        }
    }
    private String getConfigFilePath(){
        String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/{env}-config.properties";
        String env = System.getProperty("env");
        if (env == null) return configFilePath.replace("{env}", "dev");
        return configFilePath.replace("{env}", env);
    }
    // method to open the browser
    public void openBrowser(){
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Opening browser {}, isHeadless {}",browserType, isHeadless);
        BaseBrowser browser;
        switch (browserType.toLowerCase()){
            case "chrome":
                browser = new ChromeBrowser();
                break;
            case "edge":
                browser = new EdgeBrowser();
                break;
            case "firefox":
                browser = new FirefoxBrowser();
                break;
            default:
                throw new RuntimeException("Wrong browser type, choose between chrome, edge or firefox");
        }
        driver = browser.openBrowser(isHeadless);

        String url = properties.getProperty("ui.url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
    }
    // method to close the browser
    public void quitBrowser(){
        LOGGER.info("Closing browser");
        if (driver != null) driver.quit();
    }
    // method to read the driver variable
    public static WebDriver getDriver() {
        return driver;
    }
}
