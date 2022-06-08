package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.NewProjectPage;

public class AddProjectStep extends BaseStep {

    public String projectName = "QA18";

    public AddProjectStep(WebDriver driver) {
        super(driver);

    }

    // создание проекта заполнение имени и нажатие кнопки создать

    public NewProjectPage addNewProject(String projectName) {
        addProjectPage.projectNameInput.sendKeys(projectName);
        addProjectPage.addProjectButton.click();
        return newProjectPage;
    }

}
