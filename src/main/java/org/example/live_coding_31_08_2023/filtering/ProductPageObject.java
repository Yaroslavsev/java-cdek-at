package org.example.live_coding_31_08_2023.filtering;

import org.example.live_coding_31_08_2023.filtering.pageelements.ProductProperty;
import org.example.live_coding_31_08_2023.utils.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductPageObject extends PageObject {
    @FindBy(className = "_item_ajirn_2")
    private List<WebElement> elementsProperties;

    @FindBy(className = "_root_rumwo_2")
    private WebElement brandName;

    private List<ProductProperty> productProperties = new ArrayList<>();

    public ProductPageObject(String url, PageObject prevPage) {
        super(url);
        this.prevPage = prevPage;

        elementsProperties
                .stream()
                .forEach(webElement -> productProperties.add(new ProductProperty(webElement)));
    }

    public ProductPageObject(PageObject prevPage) {
        super(prevPage);
        this.prevPage = prevPage;

        elementsProperties
                .stream()
                .forEach(webElement -> productProperties.add(new ProductProperty(webElement)));
    }

    public String getProductPropertyValue(String propertyKey) {
        return productProperties
                .stream()
                .filter(productProperty -> productProperty.getPropertyKey().contains(propertyKey))
                .findFirst()
                .get()
                .getPropertyValue();
    }

    public String getProductBrandName(){
        return brandName.getText();
    }
}
