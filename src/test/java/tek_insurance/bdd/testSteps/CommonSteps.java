package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek_insurance.bdd.utility.HelperMethods;
import tek_insurance.bdd.utility.RandomEmail;
import tek_insurance.bdd.utility.RandomUserName;
import tek_insurance.bdd.utility.SeleniumUtility;

import java.text.SimpleDateFormat;


public class CommonSteps extends SeleniumUtility {
    static String emailToUse;
    static String userNameToUse;
    @When("user clicks on {string} link")
    public void clickOnLink(String linkText) {
        clickOnElement(By.linkText(linkText));
    }
    @When("user enters {string} in {string} field")
    public void userEnterInField(String value, String field) {
        String fieldXpath = HelperMethods.getFieldXpath(field);
        if (value.equalsIgnoreCase("random email")) {
            emailToUse = RandomEmail.generateRandomEmail();
            sendTextToElement(By.xpath(fieldXpath), emailToUse);
        }
        else if (value.equalsIgnoreCase("random userName")) {
            userNameToUse = RandomUserName.generateRandomUserName();
            sendTextToElement(By.xpath(fieldXpath),userNameToUse);
        } else if (value.equalsIgnoreCase("username")) {
            sendTextToElement(By.xpath(fieldXpath),userNameToUse);
        } else sendTextToElement(By.xpath(fieldXpath), value);
    }
    @When("user clicks on {string} button")
    public void userClickOnButton(String buttonText) {
        clickOnElement(By.xpath("//button[text()='"+buttonText+"']"));
    }
}
