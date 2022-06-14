package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashboardPage successLogin(User user) {
        login(user.getEmail(), user.getPsw());

        return dashboardPage;
    }

    public LoginPage incorrectLogin(User user) {
        login(user.getEmail(), user.getPsw());

        return loginPage;
    }

    public void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage logout() {

        return loginPage;
    }
}
