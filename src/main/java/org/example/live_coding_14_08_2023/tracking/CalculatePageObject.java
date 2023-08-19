package org.example.live_coding_14_08_2023.tracking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatePageObject extends PageObject {
    @FindBy(xpath = "/html/body/div[2]/div/div[3]/div/div/div[2]/button")
    private WebElement cookieAcceptBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/div[3]/div[1]/div/div[2]/button[1]")
    private WebElement orderDeliveryCityFromMoscowInputBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/div[3]/div[2]/div/div[2]/button[3]")
    private WebElement orderDeliveryCityToNovosibirskInputBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/div[3]/div[3]/div/div/div[1]")
    private WebElement orderDeliveryPackageSizeDropdown;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/div[3]/div[3]/div/div[2]/div[2]/div[1]")
    private WebElement orderDeliveryEnvelopeSize;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div[1]/div/div[4]/button")
    private WebElement orderDeliveryCalculateBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[4]/a[1]")
    private WebElement courierCallBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div/div/div[3]/div[1]/div/div[2]/button[1]")
    private WebElement courierCallCityFromMoscowInputBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div/div/div[3]/div[2]/div/div[2]/button[3]")
    private WebElement courierCallCityToNovosibirskInputBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div/div/div[3]/div[3]/div/div/div[1]")
    private WebElement courierCallPackageSizeDropdown;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div/div/div[3]/div[3]/div/div[2]/div[2]/div[1]")
    private WebElement courierCallEnvelopeSize;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div/div/div[4]/button")
    private WebElement courierCallCourierBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/div[2]/div[2]/div/div[6]/div[1]/div[2]/span")
    private WebElement servicePrice;

    public CalculatePageObject(){
        super();
    }

    public CalculatePageObject tapCookieAcceptBtn(){
        cookieAcceptBtn.click();

        return this;
    }

    public CalculatePageObject tapCalculateOrderDelivery() {
        orderDeliveryCalculateBtn.click();

        return this;
    }

    public CalculatePageObject tapCalculateOrderDeliveryCityFromMoscow(){
        orderDeliveryCityFromMoscowInputBtn.click();

        return this;
    }

    public CalculatePageObject tapCalculateOrderDeliveryCityToNovosibirsk(){
        orderDeliveryCityToNovosibirskInputBtn.click();

        return this;
    }

    public CalculatePageObject tapAndChooseCalculateOrderDeliveryEnvelopeSize(){
        orderDeliveryPackageSizeDropdown.click();
        orderDeliveryEnvelopeSize.click();

        return this;
    }

    public CalculatePageObject tapCourierCallTab(){
        courierCallBtn.click();

        return this;
    }

    public CalculatePageObject tapCalculateCourierCallCityFromMoscow(){
        courierCallCityFromMoscowInputBtn.click();

        return this;
    }

    public CalculatePageObject tapCalculateCourierCallCityToNovosibirsk(){
        courierCallCityToNovosibirskInputBtn.click();

        return this;
    }

    public CalculatePageObject tapAndChooseCalculateCourierCallEnvelopeSize(){
        courierCallPackageSizeDropdown.click();
        courierCallEnvelopeSize.click();

        return this;
    }

    public CalculatePageObject tapCalculateCourierCall() {
        courierCallCourierBtn.click();

        return this;
    }

    public String getServicePrice() {
        return servicePrice.getText();
    }
}
