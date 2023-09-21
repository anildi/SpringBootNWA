package track.solution.domain;

/**
 * @author whynot
 */
public class Track {
    /*
    . Id – should be unique
2. Artist
3. Album
4. Duration
5. Date – if using a String, should be of the form “yyyy-mm-dd”
6. Format – can have one of the following values: CD, MP3 or OGG.
     */

    public enum Format {
        CD,
        MP3,
        OGG
    }

    private int id;
    private String artist;
    private String album;
    private String duration;
    private String date;
    private Format format;

    public Track() {}

    public Track(String artist, String album, String duration, String date, Format format) {
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.date = date;
        this.format = format;
    }

    public Track(String artist, String album, String duration, String date) {
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
