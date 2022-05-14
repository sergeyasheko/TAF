package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void successAddProjectTest(){

        Assert.assertTrue(addProjectStep.addProjectButton().isPageOpened());
        Assert.assertTrue(addProjectStep.addProject("QA18").isPageOpened());

    }
}
