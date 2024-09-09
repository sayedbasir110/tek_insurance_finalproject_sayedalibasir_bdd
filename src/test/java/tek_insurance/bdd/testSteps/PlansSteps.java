package tek_insurance.bdd.testSteps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek_insurance.bdd.pages.PlansPage;
import tek_insurance.bdd.utility.SeleniumUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PlansSteps extends SeleniumUtility {
    @Then("user should be navigated to Plans page")
    public void userShouldBeNavigatedToPlansPage() {
        String actualPageHeader = getElementText(PlansPage.pageHeader);
        Assert.assertEquals("Page header should match", "Today's Plans Price", actualPageHeader);
    }
    @Then("validate there are {int} records displayed")
    public void validateNumberOfRecords(int expectedNumberOfRows) {
        List<WebElement> tableRows = getElements(PlansPage.tableRows);
        Assert.assertEquals("Number of rows should match", expectedNumberOfRows, tableRows.size());
    }
    @Then("validate DATE CREATED is today's date")
    public void validateDateCreatedIsTodayDate() {
        List<WebElement> actualCreatedDates = getElements(PlansPage.dateCreatedColumn);
        for (WebElement eachRow : actualCreatedDates){
            Assert.assertEquals("Created date should be today's date",
                    LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), eachRow.getText());
        }
    }
    @Then("validate DATE EXPIRE is tomorrow's date")
    public void validateDateExpireIsTomorrowDate() {
        List<WebElement> actualExpiryDates = getElements(PlansPage.dateExpireColumn);
        for (WebElement eachRow : actualExpiryDates){
            Assert.assertEquals("Expiry date should be tomorrow's date",
                    LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), eachRow.getText());
        }
    }
}
