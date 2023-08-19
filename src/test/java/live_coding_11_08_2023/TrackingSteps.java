package live_coding_11_08_2023;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.live_coding_11_08_2023.TrackPageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackingSteps {

    private TrackPageObject trackPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver.exe");
    }


    @Given("^([^\"]*) on the \"([^\"]*)\" page$")
    public void setupPage(String userName, String url) {
        if ("anonymous".equals(userName)) {
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
    public void orderHasStatusLabel(String statusLabel) {
        assertEquals(statusLabel, trackPage.getStatusLabel());
    }

    @Then("^order was in CREATED status$")
    public void orderWasInCreatedStatus(){
        assertEquals("Создан", trackPage.getCreatedStatus());
    }

    @Then("^order was in IN PROGRESS status$")
    public void orderWasInInProgressStatus(){
        assertEquals("В пути", trackPage.getInProgressStatus());
    }

    @Then("^order was in ISSUED FOR DELIVERY status$")
    public void orderWasInIssuedForDeliveryStatus(){
        assertEquals("Доставляет курьер", trackPage.getIssuedForDeliveryStatus());
    }

    @Then("^order was in HANDED OVER status$")
    public void orderWasInHandedOverStatus(){
        assertEquals("Вручен", trackPage.getHandedOverStatus());
    }

    @Then("^there is \"Error. Order not found\" message$")
    public void orderNotFoundErrorDisplayed(){
        assertTrue(trackPage.getOrderNotFoundError().isDisplayed());
    }
}
