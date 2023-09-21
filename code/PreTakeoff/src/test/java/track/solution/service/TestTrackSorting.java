package track.solution.service;

import org.junit.jupiter.api.Test;
import track.solution.domain.Track;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class TestTrackSorting {

    @Test
    public void testSortByNaturalOrder() {
        TrackService ts = new TrackService();
        TrackDB.initTrackService(ts);

        List<Track> tracks = ts.getAllTracks();

        Collections.sort(tracks);

        for(Track track : tracks) {
            System.out.println(track);
        }

        assertEquals(1, tracks.get(0).getId());
    }


    @Test
    public void testSortByArtist() {
        TrackService ts = new TrackService();
        TrackDB.initTrackService(ts);

        List<Track> tracks = ts.getAllTracks();

        //int compare(T o1, T o2)

        //Collections.sort(tracks, (t1, t2) -> t1.getArtist().compareTo(t2.getArtist()));
        Collections.sort(tracks, (t1, t2) -> t1.getFormat().compareTo(t2.getFormat()));

        for(Track track : tracks) {
            System.out.println(track);
        }

//        assertEquals(2, tracks.get(0).getId());

    }
}
