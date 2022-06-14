package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/54/1";
    private By addMilestonePageLocator = By.cssSelector(".content-header-title.page_title");
    private By nameMilestoneInputLocator = By.cssSelector(".form-control#name");
    private By addNewMilestoneButtonLocator = By.cssSelector("#accept.button");


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestonePageLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getNameMilestoneInput() {
        return waitsService.waitForExists(nameMilestoneInputLocator);
    }

    public WebElement getAddNewMilestoneButton() {
        return waitsService.waitForExists(addNewMilestoneButtonLocator);
    }

}
