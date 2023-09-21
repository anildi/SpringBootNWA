package track.solution.service;

import org.junit.jupiter.api.Test;
import track.solution.domain.Track;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class TestTrackFindBy {

    @Test
    public void testFindBy() {
        TrackService ts = new TrackService();
        TrackDB.initTrackService(ts);

        List<Track> tracks = ts.getAllTracks();

        List<Track> result1 = ts.findByG(tracks, t -> t.getArtist().startsWith("S"));
        for(Track t: result1) {
            System.out.println(t);
        }

        assertEquals("Susan Sontag", result1.get(0).getArtist());
    }

    //boolean test(Track)
}
