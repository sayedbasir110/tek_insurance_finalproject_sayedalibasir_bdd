package tek_insurance.bdd.testSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tek_insurance.bdd.utility.SeleniumUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class HooksSteps extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(HooksSteps.class);
    @Before
    public void runBeforeEachScenario(){
        openBrowser();
    }
    @After
    public void runAfterEachScenario(Scenario scenario){
        if (scenario.isFailed()){
            LOGGER.info("Taking screenshot");
            byte[] screenshot = takeScreenshot();
            scenario.attach(screenshot,"image/png","failed_scenario");
        }
        quitBrowser();
    }

}
