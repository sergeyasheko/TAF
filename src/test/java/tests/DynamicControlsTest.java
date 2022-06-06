package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkBoxTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkBox = wait.waitForExists(By.xpath("//input[@type='checkbox']"));
        actions.moveToElement(checkBox).click().build().perform();

        WebElement buttonRemove = wait.waitForExists(By.xpath("//button[@onclick='swapCheckbox()']"));
        actions.moveToElement(buttonRemove).click().build().perform();

        WebElement title = wait.waitForVisibilityLocatedBy(By.xpath("//p[@id='message']"));
        actions.moveToElement(title).build().perform();

        Assert.assertTrue(wait.waitForElementInvisible(checkBox));

    }
}
