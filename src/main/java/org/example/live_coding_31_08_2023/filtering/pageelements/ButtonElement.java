package org.example.live_coding_31_08_2023.filtering.pageelements;

import org.example.live_coding_31_08_2023.utils.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonElement extends PageElement {
    public ButtonElement(WebElement element) {
        super(element);
    }

    public ButtonElement(String xpath, WebDriver driver) {
        super(xpath, driver);
    }

    public void click() {
        element.click();
    }
}
