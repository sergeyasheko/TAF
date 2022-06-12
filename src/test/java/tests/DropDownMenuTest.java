package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import wrappers.DropDownMenu;

public class DropDownMenuTest extends BaseTest {

    @Test
    public void DropDownMenuTest() throws Exception {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        driver.get("https://aqa1803.testrail.io/index.php?/projects/overview/61");
        addProjectStep.clickMenuReports();

        DropDownMenu dropDownMenu = new DropDownMenu(driver, By.cssSelector("[tooltip-position='left']"));
        dropDownMenu.selectByName("Property Distribution");
    }
}
