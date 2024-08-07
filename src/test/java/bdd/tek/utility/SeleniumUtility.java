package bdd.tek.utility;

import bdd.tek.base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {
    // method to get WebDriverWait (applying explicit wait)
    private WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
    // method to return WebElement and wait for visibility of it
    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // method to click on an element
    public void clickOnElement(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    // method to send text to an element
    public void sendTextToElement(By locator,String value){
        waitForVisibility(locator).sendKeys(value);
    }
    // method to get text from an element
    public String getElementText(By locator){
        return waitForVisibility(locator).getText();
    }
    // method to check if element is enabled
    public boolean isElementEnabled(By locator){
        return waitForVisibility(locator).isEnabled();
    }
    // method to check if element is displayed
    public boolean isElementDisplayed(By locator){
        return waitForVisibility(locator).isDisplayed();
    }
    // method to take screenShot for reporting purpose
    public byte[] takeScreenshot(){
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

}
