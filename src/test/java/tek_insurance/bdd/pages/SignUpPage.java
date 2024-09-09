package tek_insurance.bdd.pages;

import org.openqa.selenium.By;

public class SignUpPage {
    public static final By pageSectionTitle= By.xpath("//h2[contains(text(),'Sign up')]");
    public static final By accountEmail= By.xpath("//div/h2[3]");
    public static final By passwordInput= By.name("password");
    public static final By confirmPasswordInput= By.name("confirm");
}
