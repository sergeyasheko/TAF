package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/overview";

    @FindBy(css = ".message.message-success")
    public WebElement successMessage;

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return successMessage;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
