package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
    }

    public AddProjectPage navigateToAddProjectPage(){
        addProjectPage.openPageByUrl();
        return addProjectPage;
    }

    public DashboardPage navigateToDashboardPage(){
        dashboardPage.openPageByUrl();
        return dashboardPage;
    }

    public NewProjectPage navigateToNewProjectPage() {
        newProjectPage.openPageByUrl();
        return newProjectPage;
    }

    public MilestonesPage navigateToMilestonePage() {
        milestonesPage.openPageByUrl();
        return milestonesPage;
    }

    public AddMilestonePage navigateToAddMilestonesPage() {
        addMilestonePage.openPageByUrl();
        return addMilestonePage;
    }
}
