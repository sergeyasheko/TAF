package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement username = $(".input[type='text']");
    public SelenideElement password = $(".input[type='password']");
    public SelenideElement loginButton = $(".button.is-vcentered");
}