package baseEntities;

import configuration.ReadProperties;
import models.Milestone;
import models.UserBuilder;
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
    protected Milestone milestone;
    protected UserBuilder userBuilder;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);
        addProjectStep = new AddProjectStep(driver);
        milestonesStep = new MilestonesStep(driver);

        driver.get(ReadProperties.getUrl());

        Milestone milestone = Milestone
                .builder()
                .name("first")
                .build();
        UserBuilder userBuilder = UserBuilder
                .builder()
                .email("atrostyanko@gmail.com")
                .psw("Americana#1")
                .build();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
