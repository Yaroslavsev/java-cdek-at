package live_coding_31_07_2023;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackingTests {
    private static WebDriver driver;

    @FindBy(xpath = ".//*[@class='tracking-search__form']/descendant::input")
    private WebElement trackNumberInputField;

    @FindBy(xpath = ".//*[@class='tracking-order-card__title']")
    private WebElement trackFoundContainer;

    @FindBy(xpath = ".//*[@class='tracking-order-card__title']")
    private List<WebElement> trackFoundContainerList;

    @FindBy(xpath = ".//*[@class='tracking-search__form-submit-text']/parent::*")
    private WebElement trackButtonSubmit;

    @FindBy(xpath = ".//*[@class='tracking-order-card__title-route']")
    private WebElement trackRoute;

    @FindBy(xpath = ".//*[@class='tracking-order-card__title-status']")
    private WebElement trackStatus;


    @BeforeAll
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.cdek.ru/ru/tracking");
    }

    @BeforeEach
    public void initElements() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void positiveTrackingWithValidTrackNumberTrackFound() {
        trackNumberInputField.click();
        waitSec();
        trackNumberInputField.sendKeys("1443275976");
        trackButtonSubmit.click();

        try {
            assertTrue(trackFoundContainer.isDisplayed());
        } catch (NoSuchElementException ex) {
            assertTrue("Искомый трек не найден", false);
        }

        assertEquals("Новосибирск — Екатеринбург", trackRoute.getText());

        assertEquals("Вручен", trackStatus.getText());
    }

    @Test
    public void negativeTrackingWithInvalidNumberNotFound() {
        trackNumberInputField.click();
        waitSec();
        trackNumberInputField.sendKeys("9993275976");
        trackButtonSubmit.click();

        assertEquals(0, trackFoundContainerList.size());

        assertTrue(trackButtonSubmit.isEnabled());
    }

    @AfterEach
    public void refreshAfterTest() {
        driver.get("https://www.cdek.ru/ru/tracking");
    }

    @AfterAll
    public static void closeChromeWindow() {
        driver.close();
    }

    private void waitSec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}