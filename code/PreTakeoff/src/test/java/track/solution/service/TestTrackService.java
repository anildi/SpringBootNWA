package track.solution.service;

import org.junit.jupiter.api.Test;
import track.solution.domain.Track;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class TestTrackService {


    @Test
    public void testInserAndGet() {
        Track newTrack = new Track("Joann", "Stars in their eyes", "04:00", "2020-10-08", Track.Format.OGG);
        assertEquals(0, newTrack.getId());

        TrackService service = new TrackService();

        Track addedTrack = service.addTrack(newTrack);

        assertEquals(1, addedTrack.getId());

        assertEquals(1, service.getAllTracks().size());
    }
}
