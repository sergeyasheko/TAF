package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class FileUploaderTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        fileUploadPath.sendKeys("D:\\Testing\\TAF\\src\\test\\resources\\qaq.jpg");
        wait.waitForExists(By.id("file-submit")).submit();

        WebElement titleUploadFile = wait.waitForExists(By.id("uploaded-files"));
        Assert.assertEquals(titleUploadFile.getText(), "qaq.jpg");
    }
}
