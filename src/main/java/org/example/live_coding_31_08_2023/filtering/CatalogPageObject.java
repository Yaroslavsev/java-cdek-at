package org.example.live_coding_31_08_2023.filtering;

import org.example.live_coding_31_08_2023.filtering.pageelements.ButtonElement;
import org.example.live_coding_31_08_2023.filtering.pageelements.GridCatalogProduct;
import org.example.live_coding_31_08_2023.filtering.pageelements.PoperFilter;
import org.example.live_coding_31_08_2023.utils.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogPageObject extends PageObject {
    @FindBy(className = "grid__catalog")
    private WebElement gridCatalogElement;

    //@FindBy(className = "v-popper-target")
    @FindBy(xpath = "//*[@class='v-popper-target']/div/div/div/span")
    private List<WebElement> filtersElements;

    @FindBy(xpath = "//*[@class='vue-recycle-scroller__item-view']/div/div/div/div/div/div/span")
    private List<WebElement> innerFilterElements;

    @FindBy(xpath = "//*[@class='_footer_1x1qp_7']/button")
    private List<WebElement> setFilterElements;

    @FindBy(xpath = "//*[@class='grid__catalog']/div/div/div/a")
    private List<WebElement> productCatalogElements;

    private List<PoperFilter> poperFilters = new ArrayList<>();
    private List<PoperFilter> innerFilters = new ArrayList<>();
    private List<ButtonElement> innerButtonsSetFilter = new ArrayList<>();
    private List<GridCatalogProduct> catalogProductList = new ArrayList<>();

    public CatalogPageObject(String url) {
        super(url);

        filtersElements
                .stream()
                .forEach(webElement -> poperFilters.add(new PoperFilter(webElement)));

        productCatalogElements
                .stream()
                .forEach(webElement -> catalogProductList.add(new GridCatalogProduct(webElement)));
    }

    public CatalogPageObject checkFilter(String main, String inner) {
        poperFilters
                .stream()
                .filter(popep -> popep.getFilterName().equals(main))
                .findFirst()
                .get()
                .click();

        innerFilterElements
                .stream()
                .filter(webElement -> webElement.isDisplayed() && webElement.isEnabled())
                .forEach(webElement -> innerFilters.add(new PoperFilter(webElement)));

        innerFilters
                .stream()
                .filter(poper -> poper.getInnerFilterName().equalsIgnoreCase(inner))
                .findFirst()
                .get()
                .click();

        setFilterElements
                .stream()
                .forEach(webElement -> innerButtonsSetFilter.add(new ButtonElement(webElement)));

        innerButtonsSetFilter.get(0).click();

        return this;
    }

    public ProductPageObject clickOnProduct(int number) {
        catalogProductList.clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productCatalogElements
                .stream()
                .forEach(webElement -> catalogProductList.add(new GridCatalogProduct(webElement)));

        return catalogProductList.get(number).click(this);
    }

    public int getNumberOfProductsInResult(){
        return catalogProductList.size();
    }
}
