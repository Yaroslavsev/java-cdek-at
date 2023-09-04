package org.example.live_coding_31_08_2023.filtering.pageelements;

import org.example.live_coding_31_08_2023.utils.PageElement;
import org.openqa.selenium.WebElement;

public class ProductProperty extends PageElement {
    private String propertyKey;
    private String propertyValue;

    public ProductProperty(WebElement element) {
        super(element);
        String elementRawValue = element.getText();
        if(elementRawValue.length() > 0) {
            propertyKey = elementRawValue.substring(0, elementRawValue.indexOf("\n"));
            propertyValue = elementRawValue
                    .substring(elementRawValue.lastIndexOf("\n") + 1,
                            elementRawValue.length());
        } else {
            propertyKey = "";
            propertyValue = "";
        }
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }
}
