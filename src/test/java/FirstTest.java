import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {

    private  WebDriver driver;

    @Test
    public void browserTests(){
       SimpleDriver simpleDriver = new SimpleDriver();
       simpleDriver.getDriver();
    }
    @Test
    public void advancedTests(){
        AdvancedDriver AdvancedDriver = new AdvancedDriver();
        AdvancedDriver.getDriver();
    }
    @Test
    public void browserServiceTests(){
        BrowserService browserService = new BrowserService();
        browserService.getDriver();
    }
}
