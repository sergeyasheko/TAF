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
        Assert.assertEquals(title.getText(), "It's gone!");

        Assert.assertTrue(wait.waitForElementInvisible(checkBox));

    }

    @Test
    public void inputTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement inputField = wait.waitForExists(By.xpath("//input[@type='text']"));
        Assert.assertFalse(inputField.isEnabled());

        WebElement buttonSwapInput = wait.waitForExists(By.xpath("//button[@onclick='swapInput()']"));
        actions.moveToElement(buttonSwapInput).click().build().perform();

        WebElement title = wait.waitForVisibilityLocatedBy(By.xpath("//p[@id='message']"));
        Assert.assertEquals(title.getText(), "It's enabled!");

        actions.moveToElement(inputField).click().build().perform();
        Assert.assertTrue(inputField.isEnabled());

        Thread.sleep(2000);
    }
}
