package ttl.track.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ttl.track.domain.Track;
import ttl.track.domain.TrackRecord;
import ttl.track.service.TrackService;

public class TrackData {
   public static void initTracks(TrackService trackService) {
      trackService.addTrack(new Track("Have You Met Miss Jones", "George Van Eps", "Pioneers of the Electric Guitar",
            Duration.ofMinutes(2).plusSeconds(18), LocalDate.parse("2013-01-02"), Track.Format.MP3));
      trackService.addTrack(new Track("My Funny Valentine", "Johnny Smith", "Moonlight in Vermont",
            Duration.parse("PT2M5S"), LocalDate.parse("2000-10-10"), Track.Format.MP3));
      trackService.addTrack(new Track("I'll Remember April", "Jim Hall and Ron Carter", "Alone Together",
            Duration.ofMinutes(5).plusSeconds(54), LocalDate.parse("1972-01-02"), Track.Format.OGG));
      trackService.addTrack(new Track("What's New", "John Coltrane", "Ballads",
            Duration.ofMinutes(3).plusSeconds(47), LocalDate.parse("1970-05-10"), Track.Format.CD));
      trackService.addTrack(new Track("Leave It To Me", "Herb Ellis", "Three Guitars in Bossa Nova Time",
            Duration.ofMinutes(3).plusSeconds(13), LocalDate.parse("1963-01-02"), Track.Format.MP3));
   }

   public static List<TrackRecord> initTracksRecords() {
      List<TrackRecord> result = new ArrayList<>();
      result.add(new TrackRecord(1, "Have You Met Miss Jones", "George Van Eps", "Pioneers of the Electric Guitar",
            Duration.ofMinutes(2).plusSeconds(18), LocalDate.parse("2013-01-02"), Track.Format.MP3));
      result.add(new TrackRecord(2, "My Funny Valentine", "Johnny Smith", "Moonlight in Vermont",
            Duration.parse("PT2M5S"), LocalDate.parse("2000-10-10"), Track.Format.MP3));
      result.add(new TrackRecord(3, "I'll Remember April", "Jim Hall and Ron Carter", "Alone Together",
            Duration.ofMinutes(5).plusSeconds(54), LocalDate.parse("1972-01-02"), Track.Format.OGG));
      result.add(new TrackRecord(4, "What's New", "John Coltrane", "Ballads",
            Duration.ofMinutes(3).plusSeconds(47), LocalDate.parse("1970-05-10"), Track.Format.CD));
      result.add(new TrackRecord(5, "Leave It To Me", "Herb Ellis", "Three Guitars in Bossa Nova Time",
            Duration.ofMinutes(3).plusSeconds(13), LocalDate.parse("1963-01-02"), Track.Format.MP3));

      return result;
   }
}
