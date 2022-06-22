package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
    public void poSelenideTest() {
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }

}