package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test
    public void validate_Dashboard_Menu_Test() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        Assert.assertTrue(loginStep.successLogin(user).topMenuPage.isPageOpened());
    }

    @Test
    public void validate_Projects_SideMenu_Test() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        Assert.assertTrue(navigationStep.navigateToProjectsPage().sideMenuPage.isPageOpened());
    }
}
