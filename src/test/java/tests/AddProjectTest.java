package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void successAddProjectTest(){

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageOpened();
        Assert.assertTrue(addProjectStep.addProject("QA18").isPageOpened());

    }
}
