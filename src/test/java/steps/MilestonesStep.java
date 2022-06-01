package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;
import pages.NewMilestonePage;


public class MilestonesStep extends BaseStep {
    public String milestoneName = "first";


    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage addNewMilestone(String milestoneName) {
        addMilestonePage.getNameMilestoneInput().sendKeys(milestoneName);
        addMilestonePage.getAddNewMilestoneButton().click();
        return milestonesPage;
    }

    public NewMilestonePage readMilestone() {
        newMilestonePage.getNewMilestonesPage();
        return newMilestonePage;
    }

    public MilestonesPage editMilestone() {
        milestonesPage.getEditNewMilestone().click();
        newMilestonePage.getReferencesInput().clear();
        newMilestonePage.getReferencesInput().sendKeys("T42");
        newMilestonePage.getSaveMilestoneButton().click();
        return milestonesPage;
    }

    public MilestonesPage openUpdateMessage() {
        editMilestone().getSuccessfullyUpdatedMessage();
        return milestonesPage;
    }

    public MilestonesPage deleteNewMilestone() {
        milestonesPage.getDeleteNewMilestone().click();
        milestonesPage.getConfirmationDeleteButton().click();
        return milestonesPage;
    }

    public MilestonesPage openDeleteMessage() {
        deleteNewMilestone().getSuccessfullyDeleteMessage();
        return milestonesPage;
    }


}
