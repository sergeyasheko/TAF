package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowserService;

public class xPathSelectors_HW {
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
    public void basicXPathSelectors() {
        driver.get("https://kermi-fko.ru/");
        driver.findElement(By.xpath("//*[@class = 'el_form btn btn_green']")).click();

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr/td/div[1]/div/div[1]/div/ul[1]/li[1]")).isDisplayed());

        // Все эелемнты на странице начиная с HTML
        driver.findElements(By.xpath("//*"));

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//tr")).isDisplayed());

        // Аналог родительского table и на один уровень ниже tbody
        Assert.assertTrue(driver.findElement(By.xpath("//table/tbody")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//li//i")).isDisplayed());

        // Поиск элемента с тэгом span у которого есть атрибут class
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href]")).isDisplayed());

        // Поиск элемента с тэгом span у которого есть атрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут class cо значением support-number
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'support-number']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением и атрибут style со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'ctl00_ContentUpper_ctl00_imgHeader' and @style ='border-width:0px;']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением или атрибут style со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'ctl00_ContentUpper_ctl00_imgHeader' or @style ='border-width:0px;']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута class начинается с agree
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id,'ctl00_ContentUpper')]")).isDisplayed());
        // Поиск элемента у которого значение аттрибута class содержит кусочек из подстроки со значением link
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'link')]")).isDisplayed());

        // Поиск элемента у которого  tegName small и текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//small[text() =' доставка в любой регион']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'лицами')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'workTime']/span[2]")).isDisplayed());
    }

    @Test
    public void axesXPathTest() {
        driver.get("https://kermi-fko.ru/");
        driver.findElement(By.xpath("//*[@class = 'el_form btn btn_green']")).click();

        // Поиск непосредственного родителя у элемента с тэгом tbody и у элемена с тегом h2
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h2/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом table
        Assert.assertTrue(driver.findElement(By.xpath("//table/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэгом div от td
        Assert.assertTrue(driver.findElement(By.xpath("//td/child::div")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'main-menu']/following::ul")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'categoryTable']/following-sibling::ul")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'categoryTable']/preceding::ul")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'categoryTable']/preceding-sibling::ul")).isDisplayed());
    }
}
