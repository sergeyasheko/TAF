package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private final static String pagePath = "/index.php?/milestones/overview/54";
    private By milestonesPageLocator = By.cssSelector(".content-header-title.page_title");
    private By addMilestoneButtonLocator = By.cssSelector("div.button-group>a.button.button-left.button-add");
    private By successMessageMilestoneLocator = By.cssSelector(".message.message-success");
    private By editNewMilestoneLocator = By.xpath("//*[@href='index.php?/milestones/edit/40']");
    private By successfullyUpdatedMessageLocator = By.cssSelector(".message.message-success");
    private By deleteNewMilestoneLocator = By.cssSelector(".icon-small-delete ");
    private By successfullyDeleteMessageLocator = By.cssSelector("message message-success");
    private By confirmationDeleteButtonLocator = By.xpath("//div[@id='deleteDialog']/div[@class='dialog-body']/following-sibling::div[@class='button-group dialog-buttons-highlighted']/a[contains(text(), 'OK')]");


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesPageLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddMilestoneButton(){return driver.findElement(addMilestoneButtonLocator);}
    public WebElement getSuccessMessageMilestone(){return driver.findElement(successMessageMilestoneLocator);}
    public WebElement getEditNewMilestone(){return driver.findElement(editNewMilestoneLocator);}
    public WebElement getSuccessfullyUpdatedMessage(){return driver.findElement(successfullyUpdatedMessageLocator);}
    public WebElement getDeleteNewMilestone(){return driver.findElement(deleteNewMilestoneLocator);}
    public WebElement getSuccessfullyDeleteMessage(){return driver.findElement(successfullyDeleteMessageLocator);}
    public WebElement getConfirmationDeleteButton(){return driver.findElement(confirmationDeleteButtonLocator);}
}
