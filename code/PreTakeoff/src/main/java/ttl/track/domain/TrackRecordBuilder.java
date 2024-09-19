package ttl.track.domain;

import java.time.Duration;
import java.time.LocalDate;

public class TrackRecordBuilder {
   private int id;
   private String title;
   private String artist;
   private String album;
   private Duration duration;
   private LocalDate date;
   private Track.Format format = Track.Format.CD;

   public TrackRecordBuilder title(String title) {
      this.title = title;
      return this;
   }

   public TrackRecordBuilder artist(String arg) {
      this.artist = arg;
      return this;
   }

   public TrackRecordBuilder album(String arg) {
      this.album = arg;
      return this;
   }

   public TrackRecordBuilder duration(String str) {
      return duration(Duration.parse(str));
   }

   public TrackRecordBuilder duration(Duration arg) {
      this.duration = arg;
      return this;
   }

   public TrackRecordBuilder date(LocalDate date) {
      this.date = date;
      return this;
   }

   public TrackRecordBuilder format(Track.Format arg) {
      this.format = arg;
      return this;
   }

   public TrackRecord build() {
      TrackRecord track = new TrackRecord(id, title, artist, album, duration, date, format);

      return track;
   }

}
