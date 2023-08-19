package live_coding_14_08_2023;

import org.example.live_coding_14_08_2023.tracking.TrackPageObject;

public class UITrackSearchStrategy implements TrackSearchStrategy{
    @Override
    public TrackPageObject searchTrack(long trackNumber) {
        TrackPageObject trackPage = new TrackPageObject("tracking");
        trackPage.enterTrackNumber(trackNumber);
        trackPage.tapTrack();

        return trackPage;
    }
}
