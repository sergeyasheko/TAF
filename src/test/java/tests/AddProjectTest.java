package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void successAddProjectTest() throws InterruptedException {

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageOpened();
        addProjectStep.addProjectButton().isPageOpened();
        addProjectStep.addProject().isPageOpened(); //создан проект QA18
        navigationStep.navigateToDashboardPage();

    }
}
