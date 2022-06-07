package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class FramesTest extends BaseTest {

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        driver.switchTo().frame("mce_0_ifr");
        WebElement title = wait.waitForExists(By.id("tinymce"));
        Assert.assertEquals(title.getText(), "Your content goes here.");

    }
}


