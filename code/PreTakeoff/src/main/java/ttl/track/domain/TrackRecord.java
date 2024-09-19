package ttl.track.domain;

import java.time.Duration;
import java.time.LocalDate;

public record TrackRecord(int id, String title,
                          String artist,
                          String album,
                          Duration duration,
                          LocalDate date,
                          Track.Format format
                          ) { }
