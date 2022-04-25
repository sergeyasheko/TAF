package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowserService;

public class CssSelectorTest_HW {
    private WebDriver driver;

    @BeforeMethod
    public void  setUp(){

        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
    @Test
    public void cssSelectorsTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).isDisplayed());
        Assert.assertEquals(12, driver.findElements(By.cssSelector(".inventory_item_img")).size());

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);





}}
