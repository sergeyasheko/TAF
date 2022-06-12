package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.RadioButton;

public class RadioButtonTest extends BaseTest {

    @Test
    public void RadioButtonTest() throws Exception {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        navigationStep.navigateToAddProjectPage();

        RadioButton suiteMode = new RadioButton(driver, By.name("suite_mode"));
        suiteMode.select("3");
    }
}
