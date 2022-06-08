package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/edit/22";

    @FindBy(css = ".content-header-title.page_title")
    public WebElement newMilestonesPage;

    @FindBy(css = "#reference")
    public WebElement referencesInput;

    @FindBy(css = "#accept")
    public WebElement saveMilestoneButton;


    public NewMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return newMilestonesPage;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
