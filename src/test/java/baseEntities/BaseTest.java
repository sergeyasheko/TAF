package baseEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowserService;
import steps.LoginStep;
import steps.NavigationStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected Actions actions;

    @BeforeMethod
    public void setup() {
        driver = new BrowserService().getDriver();

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);
        actions = new Actions(driver);

       // driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
