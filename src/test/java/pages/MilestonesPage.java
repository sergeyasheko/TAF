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

}
