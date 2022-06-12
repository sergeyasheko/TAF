package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowserService;
import steps.AddProjectStep;
import steps.LoginStep;
import steps.MilestonesStep;
import steps.NavigationStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected AddProjectStep addProjectStep;
    protected MilestonesStep milestonesStep;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);
        addProjectStep = new AddProjectStep(driver);
        milestonesStep = new MilestonesStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
