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

   private int id;
   private String title;
   private String artist;
   private String album;
   private Duration duration;
   private LocalDate date;
   private Format format;


   public Track(int id, String title, String artist, String album, Duration duration, LocalDate date, Format format) {
      this.id = id;
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

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   public String getAlbum() {
      return album;
   }

   public void setAlbum(String album) {
      this.album = album;
   }

   public Duration getDuration() {
      return duration;
   }

   public void setDuration(Duration duration) {
      this.duration = duration;
   }

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }
}
