package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestonesTest extends BaseTest {

    @Test(description = "Создание майлстона")
    public void addNewMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonesPage();
        Assert.assertTrue(milestonesStep.addNewMilestone("first").getSuccessMessageMilestone().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneTest")
    @Description("Читаем наш майлстон")
    public void readMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationStep.navigateToNewMilestonesPage();
        Assert.assertTrue(milestonesStep.readNewMilestone().getNewMilestonesPage().isDisplayed());
    }

    @Test(dependsOnMethods = "readMilestoneTest")
    public void editMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        milestonesStep.editNewMilestone();
        Assert.assertTrue(milestonesStep.openUpdateMessage().getSuccessfullyUpdatedMessage().isDisplayed());
    }
    @Test(dependsOnMethods = "editMilestoneTest")
    public void deleteMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(),ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        Assert.assertTrue(milestonesStep.deleteNewMilestone().isPageOpened());

    }
    }

