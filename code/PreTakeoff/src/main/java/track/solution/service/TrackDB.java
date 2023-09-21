package track.solution.service;

import track.solution.domain.Track;

/**
 * @author whynot
 */
public class TrackDB {

    public static void initTrackService(TrackService trackService) {
       trackService.addTrack(new Track("Susan Sontag", "The hills of Dover", "10:00", "2000-10-10", Track.Format.MP3));
        trackService.addTrack(new Track("Dave Hill", "MyLife", "80:00", "2000-10-10", Track.Format.MP3));
        trackService.addTrack(new Track("Miles Davis", "Kind of Blue", "7:54", "2000-10-10", Track.Format.OGG));
        trackService.addTrack(new Track("Lenny Bruea", "Two Guitars", "6:00", "2000-10-10", Track.Format.MP3));
    }
}
