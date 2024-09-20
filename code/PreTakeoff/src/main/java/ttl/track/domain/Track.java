package ttl.track.domain;

import java.text.Format;
import java.time.Duration;
import java.time.LocalDate;

public class Track {

   /*
   1. Id – should be unique and of type int
2. Artist – a String
3. Album – a String
4. Duration – of type java.time.Duration. More on how to use Duration
below.
5. Date – of type java.time.LocalDate. More on how to use LocalDate below.
6. Format – can have one of the following values: CD, MP3 or OGG.
    */

   public enum Format {
      CD,
      MP3,
      OGG
   }

   final private int id;
   final private String title;
   final private String artist;
   final private String album;
   final private Duration duration;
   final private LocalDate date;
   final private Format format;


   //Artist, Album
   //Title, Album
   //Album, date
   //date, duration

//   public Track() {}

   public Track(int id, String title, String artist, String album, Duration duration, LocalDate date, Format format) {
      this.id = id;
      this.title = title;
      this.artist = artist;
      this.album = album;
      this.duration = duration;
      this.date = date;
      this.format = format;
   }

   public Track(String title, String artist, String album, Duration duration, LocalDate date, Format format) {
     this(0, title, artist, album, duration, date, format);
   }

   public int getId() {
      return id;
   }

//   public void setId(int id) {
//      this.id = id;
//   }

   public String getTitle() {
      return title;
   }

//   public void setTitle(String title) {
//      this.title = title;
//   }

   public String getArtist() {
      return artist;
   }

//   public void setArtist(String artist) {
//      this.artist = artist;
//   }


   public String getAlbum() {
      return album;
   }

//   public void setAlbum(String album) {
//      this.album = album;
//   }

   public Duration getDuration() {
      return duration;
   }

//   public void setDuration(Duration duration) {
//      this.duration = duration;
//   }

   public LocalDate getDate() {
      return date;
   }

   public Format getFormat() {
      return format;
   }

   public Track withId(int id) {
      return new Track(id,
            this.title,
            this.artist,
            this.album,
            this.duration,
            this.date,
            this.format);
   }

//   public void setDate(LocalDate date) {
//      this.date = date;
//   }

   @Override
   public String toString() {
      return "Track{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", artist='" + artist + '\'' +
            ", album='" + album + '\'' +
            ", duration=" + duration +
            ", date=" + date +
            ", format=" + format +
            '}';
   }

   public static class TrackBuilder {
      private int id;
      private String title;
      private String artist;
      private String album;
      private Duration duration;
      private LocalDate date;
      private Format format = Format.CD;

      public TrackBuilder title(String title) {
         this.title = title;
         return this;
      }

      public TrackBuilder artist(String arg) {
         this.artist = arg;
         return this;
      }

      public TrackBuilder album(String arg) {
         this.album = arg;
         return this;
      }

      public TrackBuilder duration(String str) {
         return duration(Duration.parse(str));
      }

      public TrackBuilder duration(Duration arg) {
         this.duration = arg;
         return this;
      }

      public TrackBuilder date(LocalDate date) {
         this.date = date;
         return this;
      }

      public TrackBuilder format(Format arg) {
         this.format = arg;
         return this;
      }

      public Track build() {
         Track track = new Track(id, title, artist, album, duration, date, format);

         return track;
      }

   }
}
