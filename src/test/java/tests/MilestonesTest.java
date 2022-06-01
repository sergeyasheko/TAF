package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestonesTest extends BaseTest {

    @Test(priority = 1)
    public void addNewMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonesPage();
        Assert.assertTrue(milestonesStep.addNewMilestone("first").getSuccessMessageMilestone().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneTest", priority = 2)
    public void readMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToNewMilestonesPage();
        Assert.assertTrue(milestonesStep.readMilestone().getNewMilestonesPage().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneTest", priority = 3)
    public void editMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        milestonesStep.editMilestone();
        Assert.assertTrue(milestonesStep.editMilestone().getSuccessfullyUpdatedMessage().isDisplayed());
    }

    @Test(dependsOnMethods = "editMilestoneTest")
    public void deleteMilestoneTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        Assert.assertTrue(milestonesStep.deleteNewMilestone().isPageOpened());

    }
}

