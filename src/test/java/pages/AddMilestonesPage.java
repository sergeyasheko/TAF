package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/add/1";

    public AddMilestonesPage(WebDriver driver) {
        super(driver);
    }




    @Override
    protected By getPageIdentifier() {
        return null;
    }
}
