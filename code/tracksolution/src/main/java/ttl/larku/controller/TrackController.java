package ttl.larku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ttl.larku.domain.Track;
import ttl.larku.service.TrackService;

import java.net.URI;
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
    public ResponseEntity<?> getTrack(@PathVariable("id") int id) {
        Track track = trackService.getTrack(id);
        if(track == null) {
            return ResponseEntity.status(404).body("No track with id: " + id);
        }
        return ResponseEntity.ok(track);
    }

    @PostMapping
    public ResponseEntity<?> addTrack(@RequestBody Track track) {
        Track newTrack = trackService.createTrack(track);

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(track.getId())
                .toUri();

        return ResponseEntity.created(newResource).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) {
        boolean result = trackService.deleteTrack(id);
        if(!result) {
            return ResponseEntity.status(404).body("No track with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        boolean result = trackService.updateTrack(track);
        if(!result) {
            return ResponseEntity.status(404).body("No track with id: " + track.getId());
        }
        return ResponseEntity.noContent().build();
    }


}
