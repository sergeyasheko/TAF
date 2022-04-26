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
    public void setUp() {

        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void cssSelectorsTest() {
        driver.get(ReadProperties.getUrl());

        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#form")).isDisplayed());

        //Поиск по class name
        Assert.assertTrue(driver.findElement(By.cssSelector(".logo-loginpage")).isDisplayed());

        // Поиск по нескольким значения в аттрибуте class
        Assert.assertTrue(driver.findElement(By.cssSelector(".logo.loginpage-logo")).isDisplayed());

        driver.findElement(By.cssSelector("#name")).sendKeys(ReadProperties.username());
        driver.findElement(By.cssSelector("#password")).sendKeys(ReadProperties.password());
        driver.findElement(By.cssSelector("#button_primary")).click();

        // Поиск по tag name
        Assert.assertEquals(5, driver.findElements(By.cssSelector("form")).size());

        // Поиск по tag и значению из атрибута class
        Assert.assertTrue(driver.findElement(By.cssSelector("div.top-panel")).isDisplayed());

        // Поиск по 2 элементам, ID и названию класса
        Assert.assertEquals(1, driver.findElements(By.cssSelector("#confirmDialogOkCancel .dialog-title")).size());

        // Поиск всех элементов с тэгом form или input
        Assert.assertEquals(16, driver.findElements(By.cssSelector("form, input")).size());

        // Поиск всех элементов с тэгом input у которых непосредственный родитель с тэгом form
        Assert.assertEquals(3, driver.findElements(By.cssSelector("form>input")).size());

        // Поиск всех элементов с тэгом script которые идут сразу за элементом с тэгом div
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div+script")).size());

        // Поиск всех элементов с тэгом script которые являются братьями элементу с тэгом div
        Assert.assertEquals(14, driver.findElements(By.cssSelector("div~script")).size());

        // Поиск всех элементов у которых присутствует аттрибут tabindex
        Assert.assertEquals(5, driver.findElements(By.cssSelector("[tabindex]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title='Test User']")).size());

        // Поиск всех элементов у которых присутствует аттрибут class со значением заканчивающимся на какое-то value, в конкретном случае на log
        Assert.assertEquals(10, driver.findElements(By.cssSelector("[class$=log]")).size());

        // Поиск всех элементов у которых присутствует аттрибут class со значением начинающимся на value-
        Assert.assertEquals(13, driver.findElements(By.cssSelector("[class|=top]")).size());

        // Поиск всех элементов у которых присутствует аттрибут class со значением начинающимся на какое-то value, с какого-то символа
        Assert.assertEquals(12, driver.findElements(By.cssSelector("[class^=form]")).size());

        // Поиск всех элементов у которых присутствует аттрибут href со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[href~='#helpDropdown']")).size());

        // Поиск всех элементов у которых присутствует аттрибут href со значением содержащим какой текст
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[href*='Dro']")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(21, driver.findElements(By.cssSelector(":enabled")).size());

        // Выбор корневого элемента документа
        Assert.assertTrue(driver.findElement(By.cssSelector(":root")).isDisplayed());

        // Выбор  элементов с НЕ указанным атрибутом "только для чтения"
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":read-write")).size());

        // Выбор элементов с teg form и с указанным атрибутом "только для чтения"
        Assert.assertEquals(5, driver.findElements(By.cssSelector("form:read-only")).size());

        // Выбор элементов с teg input и без атрибута "required"
        Assert.assertEquals(11, driver.findElements(By.cssSelector("input:optional")).size());

        // Выбор элемента, который является единственным дочерним элементом своего родительского элемента
        Assert.assertTrue(driver.findElement(By.cssSelector(".top-panel-inner:only-child")).isDisplayed());

        // Поиск элемента с тэгом li и которым является первым дочерним элементом
        Assert.assertEquals(4, driver.findElements(By.cssSelector("li:first-child")).size());

        // Поиск элемента с тэгом form и которым является последним дочерним элементом
        Assert.assertEquals(3, driver.findElements(By.cssSelector("form:last-child")).size());

        // Поиск элемента с тэгом a и которым является 3-тим дочерним элементом
        Assert.assertEquals(9, driver.findElements(By.cssSelector("a:nth-child(3)")).size());

    }

}
