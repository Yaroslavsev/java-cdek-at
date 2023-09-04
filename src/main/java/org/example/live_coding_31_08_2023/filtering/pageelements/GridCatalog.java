package org.example.live_coding_31_08_2023.filtering.pageelements;

import org.example.live_coding_31_08_2023.filtering.ProductPageObject;
import org.example.live_coding_31_08_2023.utils.PageElement;
import org.example.live_coding_31_08_2023.utils.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GridCatalog extends PageElement {
    private List<GridCatalogProduct> catalogProductList = new ArrayList<>();

    public GridCatalog(WebElement element) {
        super(element);

        element
                .findElements(By.xpath("/div/div/div/a"))
                .stream()
                .forEach(webElement -> catalogProductList.add(new GridCatalogProduct(webElement)));
    }

    public ProductPageObject clickOnProduct(int number, PageObject prev) {
        return catalogProductList.get(number).click(prev);
    }
}
