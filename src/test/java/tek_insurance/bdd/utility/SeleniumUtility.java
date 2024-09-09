package tek_insurance.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import tek_insurance.bdd.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);
    // method to get WebDriverWait (applying explicit wait)
    private WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(waitTimeInSeconds));
    }
    // method to return WebElement and wait for visibility of it
    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // method to click on an element
    public void clickOnElement(By locator){
        LOGGER.info("Clicking on element: {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    // method to send text to an element
    public void sendTextToElement(By locator,String value){
        LOGGER.info("Sending {} to element: {}", value, locator);
        WebElement element =  waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }
    // method to get text from an element
    public String getElementText(By locator){
        LOGGER.info("Getting element text from: {} ", locator);
        return waitForVisibility(locator).getText();
    }
    // method to check if element is enabled
    public boolean isElementEnabled(By locator){
        LOGGER.info("Checking if element: {} is enabled", locator);
        return waitForVisibility(locator).isEnabled();
    }
    // method to check if element is displayed
    public boolean isElementDisplayed(By locator){
        LOGGER.info("Checking if element: {} is displayed", locator);
        return waitForVisibility(locator).isDisplayed();
    }
    // method to select from drop down
    public void selectFromDropDown(By locator, String optionText){
        LOGGER.info("Selecting {} from dropdown {}", optionText, locator);
        WebElement dropDownElement = waitForVisibility(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(optionText);
    }
    // method to get all elements
    public List<WebElement>  getElements(By locator){
        LOGGER.info("Getting all elements from: {}", locator);
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    // method to take screenShot for reporting purpose
    public byte[] takeScreenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

}
