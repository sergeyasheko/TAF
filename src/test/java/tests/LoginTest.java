package tests;

import baseentities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test(description = "Успешный логин")
    public void successfulLoginTest() {
        open(ReadProperties.getUrl());
        $(".input[type='text']").setValue(ReadProperties.username());
        $(".input[type='password']").setValue(ReadProperties.password());
        $(".button.is-vcentered").click();

        $(".button.is-ligdht.is-").shouldBe(visible).shouldHave(text("Logout Sergey"));
    }

    @Test(description = "Некорректный емейл")
    public void incorrectEmailTest() {
        open(ReadProperties.getUrl());
        $(".input[type='text']").setValue("sergey");
        $(".input[type='password']").setValue(ReadProperties.password());
        $(".button.is-vcentered").click();

        $(".notification.is-danger.is-small").shouldBe(visible).shouldHave(text("Invalid email address"));
    }

    @Test(description = "Некорректный пароль")
    public void incorrectPasswordTest() {
        open(ReadProperties.getUrl());
        $(".input[type='text']").setValue(ReadProperties.username());
        $(".input[type='password']").setValue("123");
        $(".button.is-vcentered").click();

        $(".notification.is-danger").shouldBe(visible).shouldHave(text("Your email or password is wrong"));
    }
}
