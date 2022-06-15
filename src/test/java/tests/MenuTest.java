package tests;

import baseEntities.BaseTest;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void validate_Dashboard_Menu_Test() {
        UserBuilder userBuilder = UserBuilder
                .builder()
                .email("atrostyanko@gmail.com")
                .psw("Americana#1")
                .build();
        Assert.assertTrue(
                loginStep.successLogin(userBuilder)
                        .topMenuPage.isPageOpened());
    }

    @Test
    public void validate_Projects_SideMenu_Test() {
        UserBuilder userBuilder = UserBuilder
                .builder()
                .email("atrostyanko@gmail.com")
                .psw("Americana#1")
                .build();
        loginStep.successLogin(userBuilder);
        Assert.assertTrue(navigationStep.navigateToProjectsPage().sideMenuPage.isPageOpened());
    }
}
