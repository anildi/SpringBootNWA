package ttl.track.domain;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrackBuilder {

   @Test
   public void testTrackBuilder() {
      Track newTrack = new Track.TrackBuilder()
            .title("Blah")
            .album("Nights of Quiet")
            .date(LocalDate.of(1960, 5, 5))
            .build();

//      Track t = new Track();
//      t.setArtist("Blah");
//      t.setAlbum("Blah");



      assertEquals("Blah", newTrack.getTitle());
   }
}
