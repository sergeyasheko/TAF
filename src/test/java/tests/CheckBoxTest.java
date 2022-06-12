package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.CheckBox;

public class CheckBoxTest extends BaseTest {

    @Test
    public void CheckBoxTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddProjectPage();

        CheckBox checkbox = new CheckBox(driver, By.id("show_announcement"));
        checkbox.click();
    }
}
