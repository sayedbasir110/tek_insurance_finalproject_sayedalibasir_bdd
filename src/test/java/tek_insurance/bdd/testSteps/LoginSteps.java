package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek_insurance.bdd.pages.CustomerServicePortalPage;
import tek_insurance.bdd.utility.SeleniumUtility;

public class LoginSteps extends SeleniumUtility {
    @Then("validate user is in Customer Service Portal")
    public void validateUserIsInCustomerServicePortal() {
        String actualCornerPageTitle = getElementText(CustomerServicePortalPage.cornerPageTitle);
        Assert.assertEquals("Page title should match", "Customer Service Portal", actualCornerPageTitle);
    }
}
