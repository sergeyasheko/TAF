package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertsTest extends BaseTest {

    @Test
    public void clickJSAlertsTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsExecutor.executeScript("arguments[0].click();", webElement);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("123");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        Assert.assertEquals(result.getText(), "You entered: 123");
    }
}
