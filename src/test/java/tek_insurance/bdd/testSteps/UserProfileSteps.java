package tek_insurance.bdd.testSteps;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek_insurance.bdd.pages.CustomerServicePortalPage;
import tek_insurance.bdd.pages.HomePage;
import tek_insurance.bdd.utility.HelperMethods;
import tek_insurance.bdd.utility.SeleniumUtility;

public class UserProfileSteps extends SeleniumUtility {
    @Then("validate profile {string} is {string}")
    public void validateProfileDetailIsAsExpected(String detail, String expectedInfo) {
        String profileDetailXpath = HelperMethods.getAccountProfileDetailXpath(detail);
        String actualProfileInfo = getElementText(By.xpath(profileDetailXpath));
        Assert.assertEquals("Profile information should match", expectedInfo, actualProfileInfo);
    }
    @Then("validate profile AUTHORITIES is {string}")
    public void validateProfileAuthoritiesIsAsExpected(String expectedInfo) {
        String actualProfileAuthorities = getElementText(CustomerServicePortalPage.profileAuthorities);
        Assert.assertEquals("Profile authorities should match", expectedInfo,actualProfileAuthorities);
    }
    @Then("validate user is in Homepage")
    public void validateUserIsInHomepage() {
        String actualPageHeader = getElementText(HomePage.pageHeader);
        Assert.assertEquals("Page header should match", "Lets get you started", actualPageHeader);
    }
}

