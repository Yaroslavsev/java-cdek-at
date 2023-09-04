package hw_7_highcharts_refactor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DemoLineBasicObject extends PageObject {

    private String standardTitle = "U.S Solar Employment Growth";
    private String standardTitleTagName = "text";

    private String standardLegend = """
                Installation & Developers
                Manufacturing
                Sales & Distribution
                Operations & Maintenance
                Other""";

    List<String> standardXAxisLabelsList = List.of("2010", "2012", "2014", "2016", "2018", "2020");

    private int standardXAxisLabelsListSize = 6;

    @FindBy(xpath = "//*[@class=\"highcharts-title\"]")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"demo-container\"]")
    private WebElement demoContainer;

    @FindBy(xpath = "//*[@class=\"highcharts-legend highcharts-no-tooltip\"]")
    private WebElement legend;

    @FindBy(xpath = "//*[@class=\"highcharts-description highcharts-linked-description\"]")
    private WebElement description;

    @FindBy(xpath = "//*[@class=\"highcharts-axis-labels highcharts-xaxis-labels\"]/child::*")
    private List<WebElement> xAxisLabels;

    @FindBy(xpath = "//*[@id=\"demo\"]")
    private WebElement iframeDemo;

    public DemoLineBasicObject() {
        super();
    }

    public String getStandardTitle() {
        return standardTitle;
    }

    public String getStandardTitleTagName() {
        return standardTitleTagName;
    }

    public String getStandardLegend() {
        return standardLegend;
    }

    public List<String> getStandardXAxisLabelsList() {
        return standardXAxisLabelsList;
    }

    public int getStandardXAxisLabelsListSize() {
        return standardXAxisLabelsListSize;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getDemoContainer() {
        return demoContainer;
    }

    public WebElement getLegend() {
        return legend;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getIframeDemo() {
        return iframeDemo;
    }

    public void resetToDefaultContentFromIframe() {
        driver.switchTo().defaultContent();
    }

    public void switchToIframeDemo() {
        driver.switchTo().frame(iframeDemo);
    }

    public List<String> getXAxisLabelsAsString() {
        xAxisLabels = driver.findElements(By.xpath("//*[@class=\"highcharts-axis-labels highcharts-xaxis-labels\"]/child::*"));

        List<String> xAxisLabelsStringList = new ArrayList<>();
        for (WebElement label : xAxisLabels) {
            String xAxisLabelsAsString = label.getText();
            xAxisLabelsStringList.add(xAxisLabelsAsString);
        }
        return xAxisLabelsStringList;
    }
}