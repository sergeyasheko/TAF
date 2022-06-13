package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addNewProjectTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        navigationStep.navigateToAddProjectPage();
        Assert.assertTrue(addProjectStep.addNewProject("QA18").getSuccessMessage().isDisplayed());

    }

}

