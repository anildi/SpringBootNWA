package ttl.track.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrackRecord {

   @Test
   public void testCreateTrackRecord() {
      TrackRecord tr = new TrackRecordBuilder()
            .title("Blah")
            .album("Album Blah")
            .build();


      TrackRecord tr2 = new TrackRecord(0, "Blah", "Album blah",
            null, null, null, null);
      System.out.println("tr: " + tr);

      assertEquals("Blah", tr.title());
   }
}
