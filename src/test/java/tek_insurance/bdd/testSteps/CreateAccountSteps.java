package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek_insurance.bdd.pages.CreateAccountPage;
import tek_insurance.bdd.pages.PrimaryAccountPortalPage;
import tek_insurance.bdd.pages.SignInPage;
import tek_insurance.bdd.pages.SignUpPage;
import tek_insurance.bdd.utility.HelperMethods;
import tek_insurance.bdd.utility.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {

    @Then("validate user is in Create Primary Account Page and section title is {string}")
    public void validateSectionTitleIsAsExpected(String expectedSectionTitle) {
        String actualSectionTitle = getElementText(CreateAccountPage.sectionTitle);
        Assert.assertEquals("Section title should match",expectedSectionTitle, actualSectionTitle);
    }
    @When("user selects {string} from {string} dropdown")
    public void userSelectFromDropDown(String text, String dropDown) {
        String dropDownXpath = HelperMethods.getDropDownXpath(dropDown);
        selectFromDropDown(By.xpath(dropDownXpath),text);
    }
    @Then("user should be navigated to sign-up page")
    public void userShouldBeNavigatedToSignUpPage() {
        String pageSectionTitle = getElementText(SignUpPage.pageSectionTitle);
        Assert.assertEquals("Page section title should match", "Sign up your account", pageSectionTitle);
    }
    @Then("email address should match the provided email")
    public void email_address_should_match_the_provided_email() {
        String actualEmail = getElementText(SignUpPage.accountEmail);
        Assert.assertEquals("email should match", CommonSteps.emailToUse, actualEmail);
    }
    @Then("user should see error {string}")
    public void userShouldSeeError(String expectedErrorMessage) {
        String actualErrorMessage = getElementText(CreateAccountPage.errorMessage).replace("ERROR\n","");
        Assert.assertEquals("Error message should match",expectedErrorMessage ,actualErrorMessage);
    }
    @When("user enters {string} in Password field")
    public void userEntersInPasswordField(String password) {
        sendTextToElement(SignUpPage.passwordInput, password);
    }
    @When("user enters {string} in Confirm Password field")
    public void userEntersInConfirmPasswordField(String confirmPassword) {
        sendTextToElement(SignUpPage.confirmPasswordInput, confirmPassword);
    }
    @Then("user should be navigated to sign-in page")
    public void userShouldBeNavigatedToSignInPage() {
        String actualSectionTitle = getElementText(SignInPage.pageSectionTitle);
        Assert.assertEquals("Page section title should match","Sign in to your Account", actualSectionTitle);
    }
    @Then("user should be navigated to Primary Account Portal page")
    public void userShouldBeNavigatedToPrimaryAccountPortalPage() {
        String actualCornerPageTitle = getElementText(PrimaryAccountPortalPage.cornerPageTitle);
        Assert.assertEquals("Corner title should match", "Primary Account Portal", actualCornerPageTitle);
    }
    @When("user clicks on profile button")
    public void userClicksOnProfileButton() {
        clickOnElement(PrimaryAccountPortalPage.profileBtn);
    }
    @Then("profile name should be {string}")
    public void profileNameShouldBe(String expectedProfileName) {
        String actualProfileName = getElementText(PrimaryAccountPortalPage.profileName);
        Assert.assertEquals("Profile name should match", expectedProfileName, actualProfileName);
    }
}
