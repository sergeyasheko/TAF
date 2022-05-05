package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElement = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        actions
                .moveToElement(targetElement.get(0), 10,10)
                .pause(2000)
                .moveToElement(targetElement.get(1), 10,10)
                .pause(2000)
                .moveToElement(targetElement.get(2), 10,10)
                .pause(2000)
                .build()
                .perform();

    }
    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath();
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }
}
