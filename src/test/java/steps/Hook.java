package steps;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import services.BrowserService;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before
    public void initializeTest(Scenario scenario) {
        System.out.println("HOOK: Start browser...");

        baseCucumberTest.driver = new BrowserService().getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Make a screenshot...");
        }

        if (baseCucumberTest.driver != null) {
            baseCucumberTest.driver.quit();
        }
    }
}
