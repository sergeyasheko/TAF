package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/add/1";
    public TopMenuPage topMenuPage;
    @FindBy(css = ".content-header-title")
    public WebElement allProjectPage;

    @FindBy(css = "#name.form-control ")
    public WebElement projectNameInput;

    @FindBy(css = "#accept.button")
    public WebElement addProjectButton;


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return allProjectPage;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
}
