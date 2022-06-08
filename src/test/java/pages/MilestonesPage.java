package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonesPage extends BasePage {

    private final static String pagePath = "/index.php?/milestones/overview/11";

    @FindBy(css = ".content-header-title.page_title")
    public WebElement milestonesPage;

    @FindBy(css = "div.button-group>a.button.button-left.button-add")
    public WebElement addMilestoneButton;

    @FindBy(css = ".message.message-success")
    public WebElement successMessageMilestone;

    @FindBy(xpath = "//*[contains(text(), 'Edit')]")
    public WebElement editMilestone;

    @FindBy(xpath = "//*[contains(text(),'Successfully updated the milestone.')]")
    public WebElement successfullyUpdatedMessage;

    @FindBy(css = ".icon-small-delete ")
    public WebElement deleteMilestone;

    @FindBy(css = ".message.message-success")
    public WebElement successfullyDeleteMessage;

    @FindBy(xpath = "//div[@id='deleteDialog']/div[@class='dialog-body']/following-sibling::div[@class='button-group dialog-buttons-highlighted']/a[contains(text(), 'OK')]")
    public WebElement confirmationDeleteButton;


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return milestonesPage;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
