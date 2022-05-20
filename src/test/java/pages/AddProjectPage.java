package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final static String pagePath = "/index.php?/admin/projects/add/1";
    public TopMenuPage topMenuPage;
    private By allProjectPageLocator = By.cssSelector(".content-header-title"); //локатор страницы
    private By projectNameInputLocator = By.cssSelector("#name.form-control ");   // локатор поля имя
    private By addProjectButtonLocator = By.cssSelector("#accept.button"); // локатор кнопки создать проект


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {return allProjectPageLocator; }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getProjectNameInput(){return driver.findElement(projectNameInputLocator);}
    public WebElement getAddProjectButton(){return driver.findElement(addProjectButtonLocator);}
}
