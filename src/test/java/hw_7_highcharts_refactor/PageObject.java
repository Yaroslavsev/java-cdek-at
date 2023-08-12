package hw_7_highcharts_refactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageObject {
    protected WebDriver driver;

    private String baseUrl;

    public PageObject() {
        this.driver = new ChromeDriver();
        initTimeouts(driver);
        PageFactory.initElements(driver, this);
        baseUrl = "http://www.highcharts.com/demo/line-basic";
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    private void initTimeouts(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
