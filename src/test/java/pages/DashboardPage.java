package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    public TopMenuPage topMenuPage;

    // Блок описания селекторов для элементов
    @FindBy(css = ".content-header-title")
    public WebElement headerTitleLabel;

    public DashboardPage(WebDriver driver) {
        super(driver);

        topMenuPage = new TopMenuPage(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabel;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
