package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        UserBuilder userBuilder = UserBuilder
                .builder()
                .email("atrostyanko@gmail.com")
                .psw("Americana#1")
                .build();
        Assert.assertTrue(
                loginStep.successLogin(userBuilder).isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin("sdsd", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin(ReadProperties.username(), "123").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

}
