package live_coding_14_08_2023;

import org.example.live_coding_14_08_2023.tracking.TrackPageObject;

public class URLTrackSearchStrategy implements TrackSearchStrategy{
    @Override
    public TrackPageObject searchTrack(long trackNumber) {
        TrackPageObject trackPage = new TrackPageObject("tracking?order_id=" + trackNumber);

        return trackPage;
    }
}
