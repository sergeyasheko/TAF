package tests;

import baseEntities.BaseTest;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addNewProjectTest() {
        UserBuilder userBuilder = UserBuilder
                .builder()
                .email("atrostyanko@gmail.com")
                .psw("Americana#1")
                .build();
        loginStep.successLogin(userBuilder);
        navigationStep.navigateToAddProjectPage();
        Assert.assertTrue(addProjectStep.addNewProject("QA18").getSuccessMessage().isDisplayed());

    }

}

