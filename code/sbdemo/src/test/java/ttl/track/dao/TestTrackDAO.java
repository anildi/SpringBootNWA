package ttl.track.dao;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ttl.track.domain.Track;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTrackDAO {

   private InMemoryTrackDAO trackDAO = new InMemoryTrackDAO();
   @Test
   public void testCreateTrack() {
      Track newTrack = new Track.TrackBuilder()
            .title("Blah")
            .album("Nights of Quiet")
            .date(LocalDate.of(1960, 5, 5))
            .build();

      Track insertedTrack = trackDAO.create(newTrack);

      assertTrue(insertedTrack.getId() > 0);
   }
}
