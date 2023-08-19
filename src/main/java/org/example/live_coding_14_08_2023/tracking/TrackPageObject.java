package org.example.live_coding_14_08_2023.tracking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPageObject extends PageObject {
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/form/div[2]/button")
    private WebElement trackButton;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/form/div[1]/div/div[1]/input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[1]/div[1]")
    private WebElement statusField;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[2]/div/div[1]/p")
    private WebElement orderNumTitle;

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

    public String getStatus() {
        return statusField.getText();
    }

    public String getOrderNum() {
        return orderNumTitle.getText();
    }
}

