package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMilestonePage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/11/1";
    @FindBy(css = ".content-header-title.page_title")
    public WebElement addMilestonePage;

    @FindBy(css = ".form-control#name")
    public WebElement nameMilestoneInput;

    @FindBy(css = "#accept.button")
    public WebElement addNewMilestoneButton;


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return addMilestonePage;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
