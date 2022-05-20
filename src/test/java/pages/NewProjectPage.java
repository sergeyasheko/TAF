package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewProjectPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/overview";
    private By successMessageLocator = By.cssSelector(".message.message-success"); // сообщение что проек удачно создан

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return successMessageLocator;
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    public WebElement getSuccessMessage(){return driver.findElement(successMessageLocator);}
}
