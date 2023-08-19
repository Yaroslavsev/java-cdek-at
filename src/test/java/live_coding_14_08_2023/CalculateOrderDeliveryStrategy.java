package live_coding_14_08_2023;

import org.example.live_coding_14_08_2023.tracking.CalculatePageObject;

public class CalculateOrderDeliveryStrategy implements CalculateTypeStrategy {
    @Override
    public CalculatePageObject calculateService() {
        CalculatePageObject calculateOrderDelivery = new CalculatePageObject();

        calculateOrderDelivery.tapCookieAcceptBtn()
                .tapCalculateOrderDeliveryCityFromMoscow()
                .tapCalculateOrderDeliveryCityToNovosibirsk()
                .tapAndChooseCalculateOrderDeliveryEnvelopeSize()
                .tapCalculateOrderDelivery();

        return calculateOrderDelivery;
    }
}
