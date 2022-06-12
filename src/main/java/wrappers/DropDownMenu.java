package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private List<UIElement> uiElements;

    public DropDownMenu(WebDriver driver, By by) {
        uiElements = new ArrayList<>();

        for (WebElement element : driver.findElements(by)) {
            uiElements.add(new UIElement(driver, element));
        }
    }

    public void selectByName(String value) throws Exception {
        for (UIElement uiElement : uiElements) {
            if (uiElement.getText().equals(value)) {
                uiElement.click();
                return;
            }
        }
        throw new Exception("DropDown element was not found");
    }
}
