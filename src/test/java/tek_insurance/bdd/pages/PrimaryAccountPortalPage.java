package tek_insurance.bdd.pages;

import org.openqa.selenium.By;

public class PrimaryAccountPortalPage {
    public static final By cornerPageTitle = By.xpath("//h2[text()='Primary Account Portal']");
    public static final By profileBtn = By.xpath("//button[@aria-label='profile']");
    public static final By profileName = By.xpath("//p[text()='FULL NAME']/following-sibling::p");

}
