package hw_6_highcharts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChartTest {

    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.highcharts.com";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(baseUrl + "/demo/line-basic");
        wait = new WebDriverWait(driver, 10, 100);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void elementTest() {

        resetToDefaultContentFromIframe(driver);
        switchToIframeDemo(driver);

        WebElement element = driver.findElement(By.xpath("//*[@class=\"highcharts-title\"]"));

        assertEquals("U.S Solar Employment Growth", element.getText());
        assertEquals("text", element.getTagName());
    }

    @Test
    public void baseTest() {

        resetToDefaultContentFromIframe(driver);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"demo-container\"]"));

        assertTrue(element.isDisplayed());

        switchToIframeDemo(driver);

        WebElement legend = driver.findElement(By.xpath("//*[@class=\"highcharts-legend highcharts-no-tooltip\"]"));
        WebElement description = driver.findElement(By.xpath("//*[@class=\"highcharts-description highcharts-linked-description\"]"));
        //-----Tooltip динмаческий, не понимаю как его проверять без выбора конкретной кривой, на замену взял Описание под графиком

        assertTrue(legend.isDisplayed());
        assertEquals("""
                Installation & Developers
                Manufacturing
                Sales & Distribution
                Operations & Maintenance
                Other""", legend.getText());
        assertTrue(description.isDisplayed());
    }

    @Test
    public void labelsTest() {

        resetToDefaultContentFromIframe(driver);
        switchToIframeDemo(driver);

        List<WebElement> xAxisLabels = driver.findElements(By.xpath("//*[@class=\"highcharts-axis-labels highcharts-xaxis-labels\"]/child::*"));

        List<String> xAxisLabelsStringList = new ArrayList<>();

        List<String> standardXAxisLabelsList = List.of("2010", "2012", "2014", "2016", "2018", "2020");

        for (WebElement label : xAxisLabels) {
            String xAxisLabelsAsString = label.getText();
            xAxisLabelsStringList.add(xAxisLabelsAsString);
        }

        assertEquals(6, xAxisLabels.size());
        Assert.assertEquals(standardXAxisLabelsList, xAxisLabelsStringList);
    }

    public void resetToDefaultContentFromIframe(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void switchToIframeDemo(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"demo\"]")));
    }
}
