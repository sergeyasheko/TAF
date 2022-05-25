package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;
import pages.NewMilestonePage;


public class MilestonesStep extends BaseStep {
    public String milestoneName = "first";

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    @Step("Создание майлстона с {name}/{milestoneName}")
    public MilestonesPage addNewMilestone(String milestoneName) {
        addMilestonePage.getNameMilestoneInput().sendKeys(milestoneName);
        addMilestonePage.getAddNewMilestoneButton().click();
        return milestonesPage;
    }
    @Step("Чтение майлстона с {name}/{first}")
    public NewMilestonePage readNewMilestone() {
        newMilestonePage.getNewMilestonesPage();
        return newMilestonePage;
    }

    @Step("Редактирование майлстона с {name}/{first}")
    public MilestonesPage editNewMilestone(){
        milestonesPage.getEditNewMilestone().click();
        newMilestonePage.getReferencesInput().clear();
        newMilestonePage.getReferencesInput().sendKeys("T42");
        newMilestonePage.getSaveMilestoneButton().click();
        return milestonesPage;
    }

    @Step("Открытие сообщения {value}/{Successfully updated the milestone.}")
    public MilestonesPage openUpdateMessage(){
        editNewMilestone().getSuccessfullyUpdatedMessage();
        return milestonesPage;
    }

    @Step("Удаление майлстона с {name}/{first}")
    public MilestonesPage deleteNewMilestone(){
        milestonesPage.getDeleteNewMilestone().click();
        milestonesPage.getConfirmationDeleteButton().click();
        return milestonesPage;
    }
    public MilestonesPage openDeleteMessage(){
        deleteNewMilestone().getSuccessfullyDeleteMessage();
        return milestonesPage;
    }


}
