package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MilestonesTest extends BaseTest {

    @Test
    public void addNewMilestoneTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        navigationStep.navigateToAddMilestonesPage();
        Assert.assertTrue(milestonesStep.addNewMilestone("first").getSuccessMessageMilestone().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneTest")
    public void readMilestoneTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        navigationStep.navigateToNewMilestonesPage();
        Assert.assertTrue(milestonesStep.readMilestone().getNewMilestonesPage().isDisplayed());
    }

    @Test(dependsOnMethods = "addNewMilestoneTest")
    public void editMilestoneTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        navigationStep.navigateToMilestonesPage();
        milestonesStep.editMilestone();
        Assert.assertTrue(milestonesStep.editMilestone().getSuccessfullyUpdatedMessage().isDisplayed());
    }

    @Test(dependsOnMethods = "editMilestoneTest")
    public void deleteMilestoneTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());
        loginStep.successLogin(user);
        navigationStep.navigateToMilestonesPage();
        Assert.assertTrue(milestonesStep.deleteNewMilestone().isPageOpened());

    }

    }


