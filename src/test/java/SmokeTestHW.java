import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTestHW {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }
    @Test
    public void electricUnderfloorHeatingCalculator() throws InterruptedException{
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        WebElement button = driver.findElement(By.name("button"));

        WebElement selectWebElement1 = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectWebElement1);
        WebElement selectWebElement2 = driver.findElement(By.id("heating_type"));
        Select selectTypeOfHeating = new Select(selectWebElement2);

        width.sendKeys("4");
        length.sendKeys("5");
        selectRoom.selectByValue("2");
        selectTypeOfHeating.selectByIndex(2);
        heatLoss.sendKeys("1200");
        button.click();

        WebElement heatingCableOrMatPower = driver.findElement(By.id("floor_cable_power"));
        Assert.assertEquals(668,668);
        WebElement specificPowerOfHeatingCableOrMat = driver.findElement(By.id("spec_floor_cable_power"));
        Assert.assertEquals(33,33);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
