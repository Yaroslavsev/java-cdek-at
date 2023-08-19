package live_coding_14_08_2023;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.live_coding_14_08_2023.tracking.CalculatePageObject;
import org.example.live_coding_14_08_2023.tracking.TrackPageObject;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertEquals;

public class TrackingSteps {

    private TrackPageObject trackPage;

    private CalculatePageObject calculatePage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");
    }


    @Given("^([^\"]*) on the \"([^\"]*)\" page$")
    public void setupPage(String userName, String url) {
        if ("anonimous".equals(userName)) {
            trackPage = new TrackPageObject(url);//TODO refactor to fabriq based on url
        } else {
            //TODO login
        }
    }

    @When("^enter \"(\\d+)\" to the search pane$")
    public void enterTrackNumber(long trackNumber) {
        trackPage.enterTrackNumber(trackNumber);
    }

    @When("^tap track$")
    public void tapTrack() {
        trackPage.tapTrack();
    }

    @Then("^there is \"([^\"]*)\" on the order pane$")
    public void trackOnOrderPane(String orderNum) {
        assertEquals(orderNum, trackPage.getOrderNum());
    }

    @Then("^has \"([^\"]*)\"$")
    public void orderHasStatus(String status) {
        assertEquals(status, trackPage.getStatus());
    }

    @When("^search \"(\\d+)\" in ([^\"]*)$")
    public void searchTrackByStrategy(long trackNumber, String strategy) {
        TrackSearchStrategy searchStrategy;

        switch (strategy) {
            case "UI":
                searchStrategy = new UITrackSearchStrategy();
                break;
            case "URL":
            default:
                searchStrategy = new URLTrackSearchStrategy();
                break;
        }

        trackPage = searchStrategy.searchTrack(trackNumber);
    }
//--------------------------------------------------------------------------------------------------------------------//

    @When("^calculate ([^\"]*) FROM Moscow TO Novosibirsk and PACKAGE SIZE is Envelope$")
    public void calculateByStrategy(String strategy) {
        CalculateTypeStrategy calculateStrategy;

        switch (strategy) {
            case "order delivery":
                calculateStrategy = new CalculateOrderDeliveryStrategy();
                break;
            case "courier call":
            default:
                calculateStrategy = new CalculateCourierCallStrategy();
                break;
        }

        calculatePage = calculateStrategy.calculateService();
    }

    @Then("^service price is \"([^\"]*)\"$")
    public void servicePriceIs(String price){
        assertEquals(price, calculatePage.getServicePrice());
    }


    @AfterEach
    public void disposeDriver() {
        trackPage.close();
    }
}
