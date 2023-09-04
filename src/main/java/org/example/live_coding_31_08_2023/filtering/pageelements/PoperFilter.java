package org.example.live_coding_31_08_2023.filtering.pageelements;

import org.example.live_coding_31_08_2023.utils.PageElement;
import org.openqa.selenium.WebElement;

public class PoperFilter extends PageElement {
    private boolean expanded = false;

    public PoperFilter(WebElement element) {
        super(element);
    }

    public void click() {
        element.click();
        expanded ^= true;
    }

    public String getFilterName() {
        return element
                //.findElement(By.xpath("/div/div/div/span"))
                .getText();
    }

    public String getInnerFilterName() {
        return element
                //.findElement(By.xpath("/div/div/div/div/div/div/span"))
                .getText();
    }
}
