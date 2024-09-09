package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek_insurance.bdd.pages.HomePage;
import tek_insurance.bdd.utility.SeleniumUtility;

public class HomePageSteps extends SeleniumUtility {

    @Then("page title should be {string}")
    public void pageTitleShouldBeAsExpected(String expectedPageTitle) {
        String actualPageTitle = getDriver().getTitle();
        Assert.assertEquals("Page title should match", expectedPageTitle, actualPageTitle);
    }
    @Then("Create Primary Account button should be displayed")
    public void buttonShouldBeDisplayed() {
        boolean isBtnDisplayed = isElementDisplayed(HomePage.createPrimaryAccountBtn);
        Assert.assertTrue( "Button should be visible", isBtnDisplayed);
    }
}
