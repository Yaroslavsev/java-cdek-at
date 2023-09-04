package org.example.live_coding_31_08_2023.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageElement {
    protected WebElement element;

    public PageElement(WebElement element) {
        this.element = element;
    }

    public PageElement(String xpath, WebDriver driver) {
        this.element = driver.findElement(By.xpath(xpath));
    }

    public boolean isAvailable() {
        return (element != null & element.isEnabled());
    }

    public boolean isVisible() {
        return (element != null & element.isDisplayed());
    }
}
