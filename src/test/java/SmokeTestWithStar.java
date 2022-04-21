import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTestWithStar {
    private WebDriver driver;
    public static String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    @BeforeMethod
    public void setUp(){
        BrowserService browserService = new BrowserService();
        driver = browserService.getDriver();
    }

    @Test
    public void CalculatorForCalculatingLaminate() throws InterruptedException{
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.sendKeys(deleteString);
        roomLength.sendKeys("500");
        Thread.sleep(1000);
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.sendKeys(deleteString);
        roomWidth.sendKeys("400");
        Thread.sleep(1000);
        WebElement laminatePanelLength = driver.findElement(By.id("ln_lam_id"));
        laminatePanelLength.sendKeys(deleteString);
        laminatePanelLength.sendKeys("2000");
        Thread.sleep(1000);
        WebElement laminatePanelWidth = driver.findElement(By.id("wd_lam_id"));
        laminatePanelWidth.sendKeys(deleteString);
        laminatePanelWidth.sendKeys("200");
        Thread.sleep(1000);

       WebElement selectWebElement1 = driver.findElement(By.id("laying_method_laminate"));
       Select methodOfLayingLaminate = new Select(selectWebElement1);
        methodOfLayingLaminate.selectByValue("2");
        Thread.sleep(2000);
        WebElement selectWebElement2 = driver.findElement(By.cssSelector("input[type='radio'][value='1']"));
        selectWebElement2.click();
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.className("calc-btn-div"));
        button.click();
        Thread.sleep(2000);

        WebElement result1 = driver.findElement(By.cssSelector(".calc-result div:nth-child(1) span"));
        Assert.assertEquals(result1.getAttribute("innerText"),"53");
        WebElement result2 = driver.findElement(By.cssSelector(".calc-result div:nth-child(2) span"));
        Assert.assertEquals(result2.getAttribute("innerText"),"7");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

