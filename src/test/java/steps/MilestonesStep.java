package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;
import pages.NewMilestonePage;


public class MilestonesStep extends BaseStep {
    public String milestoneName = "first";
    public String newReferenceName = "T42";


    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage addNewMilestone(String milestoneName) {
        addMilestonePage.nameMilestoneInput.sendKeys(milestoneName);
        addMilestonePage.addNewMilestoneButton.click();
        return milestonesPage;
    }

    public NewMilestonePage readMilestone() {
        return newMilestonePage;
    }

    public MilestonesPage editMilestone() {
        milestonesPage.editMilestone.click();
        newMilestonePage.referencesInput.clear();
        newMilestonePage.referencesInput.sendKeys(newReferenceName);
        newMilestonePage.saveMilestoneButton.click();
        return milestonesPage;
    }


    public MilestonesPage deleteNewMilestone() {
        milestonesPage.deleteMilestone.click();
        milestonesPage.confirmationDeleteButton.click();
        return milestonesPage;
    }

}
