package hw_7_highchart_refactor_workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/*abstract class HighCharts {
    protected WebDriver driver;
    protected WebElement chart;
    protected WebDriverWait wait;
    protected Actions performAction;

    // Что это такое, как подключается. для чего используется?
    //protected JavascriptLibrary javascript = new JavascriptLibrary();

    private WebElement toolTip;
    private WebElement legend;
    private List<WebElement> axisLabels;

    @FindBy(how = How.CSS, using = "g.highcharts-tooltip")
    private WebElement toolTip;

    @FindBy(how = How.CSS, using = "g.highcharts-legend")
    private WebElement legend;

    @FindBy(how = How.CSS, using = "g.highcharts-axis")
    private List<WebElement> axisLabels;

    public HighCharts(WebDriver driver, WebElement chart) {
        PageFactory.initElements(new DefaultElementLocatorFactory(chart), this);

        this.driver = driver;
        this.chart = chart;

        int waitTimeoutInSeconds = 15;
        wait = new WebDriverWait(driver, waitTimeoutInSeconds, 100);
        performAction = new Actions(driver);
    }

    public boolean isChartDisplayed() {
        return wait.until(visibilityOf(this.chart)) != null;
    }

    public boolean isLegendDisplayed() {
        return legend.isDisplayed();
    }

    public boolean isTooltipDisplayed() {
        return wait.until(visibilityOf(toolTip)) != null;
    }

    public String getLegendText() {
        return legend.getText();
    }

    protected WebElement getXAxisLabels() {
        return axisLabels.get(0);
    }

    public List<String> getXAxisLabelsText() {
        List<String> labels = new ArrayList<String>();
        List<WebElement> xAxisLabels = getXAxisLabels().findElements(By.cssSelector("text"));
        for (WebElement xAxisLabel : xAxisLabels) {
            labels.add(xAxisLabel.getText());
        }
        return labels;
    }

    public String[] getXAxisLabelsAsArray() {
        List<String> xAxisLabels = getXAxisLabelsText();
        return xAxisLabels.toArray(new String[xAxisLabels.size()]);
    }

    protected WebElement getYAxisLabels() {
        return axisLabels.get(1);
    }

    public List<String> getYAxisLabelsText() {
        List<String> labels = new ArrayList<String>();
        List<WebElement> yAxisLabels = getYAxisLabels().findElements(By.cssSelector("text"));
        for (WebElement yAxisLabel : yAxisLabels) {
            labels.add(yAxisLabel.getText());
        }
        return labels;
    }
}
*/