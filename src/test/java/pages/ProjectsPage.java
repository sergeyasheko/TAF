package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    @FindBy(xpath = ".content-header-title.page_title")
    public WebElement projectTitleLabel;

    public SideMenuPage sideMenuPage;


    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return projectTitleLabel;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}

