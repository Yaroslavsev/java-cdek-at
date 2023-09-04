package org.example.live_coding_31_08_2023.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class PageObject {
    protected WebDriver driver;
    protected PageObject prevPage;
    protected PageObject nextPage;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        initTimeouts(driver);
        PageFactory.initElements(driver, this);
    }

    public PageObject() {
        this.driver = WebDriverPool.get();
        initTimeouts(driver);
        PageFactory.initElements(driver, this);
    }

    public PageObject(String url) {
        this.driver = new ChromeDriver();
        initTimeouts(driver);
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public PageObject(PageObject prevPage) {
        this.driver = prevPage.driver;
        PageFactory.initElements(driver, this);
    }

    private void initTimeouts(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public PageObject refresh() {
        driver.navigate().refresh();

        return this;
    }

    protected PageObject forward() throws Exception {
        if(nextPage != null) {
            driver.navigate().forward();
            nextPage.prevPage = this;
            return nextPage;
        } else {
            throw new Exception("No next page to forward");
        }
    }

    public PageObject backward() throws Exception {
        if(prevPage != null) {
            driver.navigate().back();
            prevPage.nextPage = this;
            return prevPage;
        } else {
            throw new Exception("No prev Page");
        }
    }

    public void close() {
        driver.close();
        WebDriverPool.returnDriver(driver);
    }
}
