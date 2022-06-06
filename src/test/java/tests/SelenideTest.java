package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1960x1080";
        //Configuration.assertionMode = AssertionMode.SOFT;
        //Configuration.driverManagerEnabled = false;
        //Configuration.fastSetValue = true;
        //Configuration.headless = true;
        Configuration.reportsFolder = "target/screens";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        //   SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        //         .screenshots(false)
        //       .savePageSource(true)
        // );
    }

    @Test
    public void simpleSelenideTest() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

    @Test
    public void selenideTest1() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
        $$("div.project")
                .filter(visible)
                .shouldHave(size(26))
                .find(text("erg"))
                .click();
        $$("div.project")
                .first();
        $$("div.project")
                .get(2);

        sleep(1000);
        refresh();
        title();
        executeJavaScript("");
    }

    @Test
    public void SelenideTest2() {
        open(ReadProperties.getUrl());

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        System.out.println($(byText("asdasdasdfaszc")).innerText()); //текст который отображается на экране
        System.out.println($(byText("asdasdasdfaszc")).getText());
        System.out.println($(byText("asdasdasdfaszc")).innerHtml());
        System.out.println($(byText("asdasdasdfaszc")).data(""));
        System.out.println($(byText("asdasdasdfaszc")).val());
        System.out.println($(byText("asdasdasdfaszc")).getValue()); // получить значение со строк инпута
        $(byText("asdasdasdfaszc")).scrollTo();
        $(byText("asdasdasdfaszc")).doubleClick();
        $(byText("asdasdasdfaszc")).contextClick();
        $(byText("asdasdasdfaszc")).hover();
        $(byText("asdasdasdfaszc")).find(By.xpath(""));
        $(byText("asdasdasdfaszc")).closest("tr");    // найти ближайший элемент
        $(byText("asdasdasdfaszc")).ancestor("div");
        $(byText("asdasdasdfaszc")).sibling(1);
        $(byText("asdasdasdfaszc")).parent();

        $(byText("asdasdasdfaszc")).uploadFile(new File(""));
        // $(byText("asdasdasdfaszc")).download();
    }

    @Test
    public void SelenideTest3() {
        open("/");

        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        open("open('/index.php?/admin/projects/overview');");
        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("erg"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));

        $("#announcement")
                .should(exist).should(hidden).should(disappear).shouldNotBe(visible)
                .should(readonly)
                .shouldHave(name("name"))
                .shouldHave(value("John"))
                .shouldHave(type("checkbox"))
                .shouldBe(empty)
                .shouldBe(focused);

        WebElement webElement = $("#announcement").toWebElement();

        Condition clickable = and("can be clicked", visible, enabled);
        $$("#announcement").findBy(clickable).click();

        $("#announcement").shouldBe(clickable);

        $("#announcement")
                .shouldHave(text("Expected Text"))   //проверка на ожидаемый текст, аналог contains
                .shouldHave(matchText("Expected Text"))  // сверка с текстом с шаблона, который нужно прописать где-нибудь, regex
                .shouldHave(exactText(""))  //проверка на текст полностью с пробелами и т.д., аналог equalsIgnoreCase
                .shouldHave(textCaseSensitive("Expected Result Text")) // проверка текста с учетом регистра
                .shouldHave(exactTextCaseSensitive("Expected Result Text"));  // проверка текста с учетом регистра и всех символов, аналог equals
    }
}