package steps;

import baseEntities.BaseStep;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;
import pages.NewMilestonePage;


public class MilestonesStep extends BaseStep {
    public String milestoneName = "first";
    public String newReferenceName = "T42";


    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage addNewMilestone(Milestone milestone) {
        addMilestonePage.getNameMilestoneInput().sendKeys(milestoneName);
        addMilestonePage.getAddNewMilestoneButton().click();
        return milestonesPage;
    }

    public NewMilestonePage readMilestone(Milestone milestone) {
        milestonesPage.getReadMilestone().click();
        return newMilestonePage;
    }

    public MilestonesPage editMilestone(Milestone milestone) {
        milestonesPage.getEditMilestone().click();
        newMilestonePage.getReferencesInput().clear();
        newMilestonePage.getReferencesInput().sendKeys(newReferenceName);
        newMilestonePage.getSaveMilestoneButton().click();
        return milestonesPage;
    }

    public MilestonesPage deleteNewMilestone(Milestone milestone) {
        milestonesPage.getDeleteMilestone().click();
        milestonesPage.getConfirmationDeleteButton().click();
        return milestonesPage;
    }

}
