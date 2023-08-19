package live_coding_14_08_2023;

import org.example.live_coding_14_08_2023.tracking.CalculatePageObject;

public class CalculateCourierCallStrategy implements CalculateTypeStrategy {
    @Override
    public CalculatePageObject calculateService() {
        CalculatePageObject calculateCallCourier = new CalculatePageObject();

        calculateCallCourier.tapCookieAcceptBtn()
                .tapCourierCallTab()
                .tapCalculateCourierCallCityFromMoscow()
                .tapCalculateCourierCallCityToNovosibirsk()
                .tapAndChooseCalculateCourierCallEnvelopeSize()
                .tapCalculateCourierCall();

        return null;
    }
}
