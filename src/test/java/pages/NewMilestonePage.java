package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/edit/26";
    private By newMilestonesPageLocator = By.cssSelector(".content-header-title.page_title");
    private By referencesInputLocator = By.cssSelector("#reference");
    private By saveMilestoneButtonLocator = By.cssSelector("#accept");


    public NewMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return newMilestonesPageLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getNewMilestonesPage() {
        return waitsService.waitForExists(newMilestonesPageLocator);
    }

    public WebElement getReferencesInput() {
        return waitsService.waitForExists(referencesInputLocator);
    }

    public WebElement getSaveMilestoneButton() {
        return waitsService.waitForExists(saveMilestoneButtonLocator);
    }

}
