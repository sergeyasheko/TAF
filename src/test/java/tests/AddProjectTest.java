package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addNewProjectTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddProjectPage();
        Assert.assertTrue(addProjectStep.addNewProject("QA18").successMessage.isDisplayed());

    }

}

