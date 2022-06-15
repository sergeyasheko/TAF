package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestonesTest extends BaseTest {

    @Test(priority = 1)
    public void addNewMilestoneBuilderTest() {
        Milestone milestone = Milestone
                .builder()
                .name("first")
                .build();
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddMilestonesPage();
        Assert.assertTrue(milestonesStep.addNewMilestone(milestone).getSuccessMessageMilestone().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneBuilderTest", priority = 3)
    public void readMilestoneBuilderTest() {
        Milestone milestone = Milestone
                .builder()
                .name("first")
                .build();
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        Assert.assertTrue(milestonesStep.readMilestone(milestone).getNewMilestonesPage().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneBuilderTest", priority = 2)
    public void editMilestoneBuilderTest() {
        Milestone milestone = Milestone
                .builder()
                .name("first")
                .build();
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        milestonesStep.editMilestone(milestone);
        Assert.assertTrue(milestonesStep.editMilestone(milestone).getSuccessfullyUpdatedMessage().isDisplayed());
    }

    @Test(dependsOnMethods = "editMilestoneBuilderTest", priority = 4)
    public void deleteMilestoneBuilderTest() {
        Milestone milestone = Milestone
                .builder()
                .name("first")
                .build();
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToMilestonesPage();
        Assert.assertTrue(milestonesStep.deleteNewMilestone(milestone).isPageOpened());

    }
}

