package tek_insurance.bdd.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/", // Directory for Feature file
        glue = "tek_insurance.bdd.testSteps", //Package for all the steps
        dryRun =  false,
        tags = "@smoke",
        plugin = {
                "html:target/cucumber_report/index.html",
                "json:target/json_report/cucumber-report"
        }
)
public class TestRunner {
}
