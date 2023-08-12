package hw_7_highcharts_refactor;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChartTest {
    private DemoLineBasicObject demoLineBasicPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");
        demoLineBasicPage = new DemoLineBasicObject();
    }

    @AfterClass
    public void tearDown() {
        demoLineBasicPage.getDriver().close();
    }

    @Test
    public void elementTest(){
        demoLineBasicPage.resetToDefaultContentFromIframe();
        demoLineBasicPage.switchToIframeDemo();

        assertEquals(demoLineBasicPage.getStandardTitle(), demoLineBasicPage.getTitle().getText());
        assertEquals(demoLineBasicPage.getStandardTitleTagName(), demoLineBasicPage.getTitle().getTagName());
    }

    @Test
    public void baseTest(){
        demoLineBasicPage.resetToDefaultContentFromIframe();

        assertTrue(demoLineBasicPage.getDemoContainer().isDisplayed());

        demoLineBasicPage.switchToIframeDemo();

        assertTrue(demoLineBasicPage.getLegend().isDisplayed());
        assertEquals(demoLineBasicPage.getStandardLegend(), demoLineBasicPage.getLegend().getText());
    }

    @Test
    public void labelsTest(){
        demoLineBasicPage.resetToDefaultContentFromIframe();
        demoLineBasicPage.switchToIframeDemo();

        assertEquals(demoLineBasicPage.getStandardXAxisLabelsListSize() , demoLineBasicPage.getXAxisLabelsAsString().size());
        Assert.assertEquals(demoLineBasicPage.getStandardXAxisLabelsList(), demoLineBasicPage.getXAxisLabelsAsString());
    }
}
