package tek_insurance.bdd.pages;

import org.openqa.selenium.By;

public class PlansPage {
    public static final By pageHeader = By.xpath("//h2[contains(text(),'Plans Price')]");
    public static final By tableRows = By.xpath("//table/tbody/tr");
    public static final By dateCreatedColumn = By.xpath("//table/tbody/tr/td[4]");
    public static final By dateExpireColumn = By.xpath("//table/tbody/tr/td[5]");
}
