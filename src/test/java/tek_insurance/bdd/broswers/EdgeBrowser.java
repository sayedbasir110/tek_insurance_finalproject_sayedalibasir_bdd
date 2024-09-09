package tek_insurance.bdd.broswers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser implements BaseBrowser{
    @Override
    public WebDriver openBrowser(boolean isHeadless){
        EdgeOptions options = new EdgeOptions();
        if (isHeadless) options.addArguments("--isHeadless");
        return new EdgeDriver(options);
    }
}
