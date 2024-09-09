package tek_insurance.bdd.pages;

import org.openqa.selenium.By;

public class CustomerServicePortalPage {
    public static final By cornerPageTitle = By.xpath("//h2[text()='Customer Service Portal']");
    public static final By profileAuthorities = By.xpath("//p[text()='AUTHORITIES']//following-sibling::ul");
}
