package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.NewProjectPage;
import pages.ProjectsPage;

public class AddProjectStep extends BaseStep {

    public String projectName = "QA18";

    public AddProjectStep(WebDriver driver) {
        super(driver);

    }

    // создание проекта заполнение имени и нажатие кнопки создать

    public NewProjectPage addNewProject(String projectName) {
        addProjectPage.getProjectNameInput().sendKeys(projectName);
        addProjectPage.getAddProjectButton().click();
        return newProjectPage;
    }

    public ProjectsPage clickMenuReports() {
        projectsPage.getReportsButton().click();
        return projectsPage;
    }

}
