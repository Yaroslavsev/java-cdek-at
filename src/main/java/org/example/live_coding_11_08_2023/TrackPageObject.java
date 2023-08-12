package org.example.live_coding_11_08_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPageObject extends PageObject {
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/form/div[2]/button")
    private WebElement trackButton;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/form/div[1]/div/div[1]/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[1]/div[1]")
    private WebElement statusLabel;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[1]/p")
    private WebElement orderNumTitle;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/p[1]")
    private WebElement statusCreated;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/p[1]")
    private WebElement statusInProgress;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div/p[1]")
    private WebElement statusIssuedForDelivery;

    @FindBy(xpath = "//*[@id=\"work-area\"]/div/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div[4]/div/div/div[2]/div/p[1]")
    private WebElement statusHandedOver;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/span/div/div")
    private WebElement orderNotFoundError;

    public TrackPageObject(String url) {
        super(url);
    }

    public void enterTrackNumber(Long trackNumber) {
        searchField.sendKeys(trackNumber.toString());
    }

    public TrackPageObject tapTrack() {
        trackButton.click();

        return this;
    }

    public String getStatusLabel() {
        return statusLabel.getText();
    }

    public String getOrderNum() {
        return orderNumTitle.getText();
    }

    public String getCreatedStatus() {
        return statusCreated.getText();
    }

    public String getInProgressStatus() {
        return statusInProgress.getText();
    }

    public String getIssuedForDeliveryStatus() {
        return statusIssuedForDelivery.getText();
    }

    public String getHandedOverStatus() {
        return statusHandedOver.getText();
    }

    public WebElement getOrderNotFoundError() {
        return orderNotFoundError;
    }
}
