package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek_insurance.bdd.pages.AccountsPage;
import tek_insurance.bdd.utility.SeleniumUtility;

public class AccountsSteps extends SeleniumUtility {
    @Then("user should be navigated to Accounts page")
    public void userShouldBeNavigatedToAccountsPage() {
        String actualPageHeader = getElementText(AccountsPage.pageHeader);
        Assert.assertEquals("Page title should match", "Primary Accounts", actualPageHeader);
    }
    @When("user selects {string} from Show records dropdown")
    public void userSelectsFromShowPerPageDropdown(String optionText) {
        selectFromDropDown(AccountsPage.showRecordsDropDown, optionText);
    }

}
