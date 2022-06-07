package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class ContextMenuTest extends BaseTest {

    @Test
    public void rightClickTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement hotSpot = wait.waitForExists(By.id("hot-spot"));
        actions.moveToElement(hotSpot).contextClick().build().perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();

    }
}
