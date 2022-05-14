package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.ProjectsPage;
import pages.SideMenuPage;

public class AddProjectStep extends BaseStep {

    public String name = "QA18";

    public AddProjectStep(WebDriver driver) {
        super(driver);

    }

    // нажатие кнопки Add project
    public AddProjectPage addProjectButton() {
        sideMenuPage.getAddProjectButton().click();
        return addProjectPage;
    }

    // создание проекта заполнение имени и нажатие кнопки создать
    public ProjectsPage addProject(String name) {
        addProjectPage.getProjectName().sendKeys(name);
        addProjectPage.getAddProjectButton().click();
        return projectsPage;

    }
}
