package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.util.List;

/**
 * @author whynot
 */

@RestController
@RequestMapping("/track")
public class TrackController {

//    @Autowired
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;

    }

    @GetMapping
    public List<Track> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        return tracks;
    }

    @GetMapping("/{id}")
    public Track getTrack(@PathVariable("id") int id) {
        Track track = trackService.getTrack(id);
        return track;
    }

    @PostMapping
    public Track addTrack(@RequestBody Track track) {
        Track newTrack = trackService.createTrack(track);

        return newTrack;
    }

}
