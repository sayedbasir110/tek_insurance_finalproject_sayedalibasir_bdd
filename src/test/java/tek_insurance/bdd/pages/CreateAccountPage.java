package tek_insurance.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountPage {
    public static final By sectionTitle = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By errorMessage = By.xpath("//div[@data-status='error'][@role='alert']");

}
