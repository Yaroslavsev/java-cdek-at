package hw_7_highchart_refactor_workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*public class ChartTest {

    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.highcharts.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/demo/line-basic");
        wait = new WebDriverWait(driver, 10, 100);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void elementTest() {
        driver.findElement(By.linkText("Basic line")).click();
        WebElement element = driver.findElement(By.id("highcharts-0"));

        System.out.println("element text " + element.getText());
        System.out.println("element getTagName " + element.getTagName());
    }

//-------------OLD VERSION-------------------
//    @Test
//    public void baseTest() {
//        driver.findElement(By.linkText("Basic line")).click();
//
//        WebElement element = driver.findElement(By.id("highcharts-0"));
//        WebElement legend = driver.findElement(By.cssSelector("g.highcharts-legend"));
//        WebElement toolTip = driver.findElement(By.cssSelector("g.highcharts-tooltip"));
//
//        System.out.println("is char displayed " + wait.until(visibilityOf(element)) != null);
//        System.out.println("is char isLegendDisplayed " + legend.isDisplayed());
//        System.out.println("is char isLegendDisplayed " + legend.getText());
//        System.out.println("is char isTooltipDisplayed " + wait.until(visibilityOf(toolTip)) != null);
//    }

    @Test
    public void baseTest() {
        driver.findElement(By.linkText("Basic line")).click();

        WebElement element = driver.findElement(By.id("highcharts-0"));
        LineChart base = new LineChart(driver, element);

        System.out.println("is char displayed " + base.isChartDisplayed());
        System.out.println("is char isLegendDisplayed " + base.isLegendDisplayed());
        System.out.println("is char isLegendDisplayed " + base.getLegendText());
        System.out.println("is char isTooltipDisplayed " + base.isTooltipDisplayed());
        System.out.println("getXAxisLabelsAsArray() length" + base.getXAxisLabelsAsArray().length);
    }

//-------------OLD VERSION-------------------
//    @Test
//    public void labelsTest() {
//        driver.findElement(By.linkText("Basic line")).click();
//
//        List<String> labels = new ArrayList<>();
//        List<WebElement> axisLabels = driver.findElements(By.cssSelector("g.highcharts-axis"));
//        List<WebElement> xAxisLabels = axisLabels.get(0).findElements(By.cssSelector("text"));
//
//        for (WebElement xAxisLabel : xAxisLabels) {
//            labels.add(xAxisLabel.getText());
//        }
//
//        System.out.println("getXAxisLabelsAsArray() length" + xAxisLabels.size());
//        for (WebElement label : xAxisLabels) {
//            System.out.println("label : " + label.getText());
//        }
//    }

    @Test
    public void labelsTest() {
        driver.findElement(By.linkText("Basic line")).click();

        WebElement element = driver.findElement(By.id("highcharts-0"));
        LineChart base = new LineChart(driver, element);

        for (String label : base.getXAxisLabelsAsArray()) {
            System.out.println("label : " + label);
        }
    }
}*/