package org.example.live_coding_31_08_2023.utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WebDriverPool {
    private static List<WebDriver> drivers = new ArrayList<>();

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver-win64\\chromedriver.exe");
        //drivers.add(new ChromeDriver());
        //drivers.add(new ChromeDriver());
    }

    public static WebDriver get() {
        if(drivers.size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return WebDriverPool.get();
        }
        WebDriver driver = drivers.get(drivers.size() - 1);
        drivers.remove(drivers.size() - 1);

        return driver;
    }

    public static void returnDriver(WebDriver driver) {
        drivers.add(driver);
    }
}
