package org.example.live_coding_31_08_2023.filtering.pageelements;

import org.example.live_coding_31_08_2023.filtering.ProductPageObject;
import org.example.live_coding_31_08_2023.utils.PageElement;
import org.example.live_coding_31_08_2023.utils.PageObject;
import org.openqa.selenium.WebElement;

public class GridCatalogProduct extends PageElement {
    public GridCatalogProduct(WebElement element) {
        super(element);
    }

    public ProductPageObject click(PageObject prev) {
        element.click();

        return new ProductPageObject(prev);
    }
}
