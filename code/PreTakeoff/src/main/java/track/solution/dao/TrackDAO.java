package track.solution.dao;

import track.solution.domain.Track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author whynot
 */
public class TrackDAO {

    private Map<Integer, Track> tracks = new HashMap<>();
    private int nextId = 1;

    public Track get(int id) {
        return tracks.get(id);
    }

    public List<Track> getAll() {
       return new ArrayList<>(tracks.values());
    }

    public Track insert(Track newTrack) {
        int newId = nextId++;
        newTrack.setId(newId);
        tracks.put(newId, newTrack);

        return newTrack;
    }

    public boolean update(Track track) {
        if(tracks.containsKey(track.getId())) {
            tracks.put(track.getId(), track);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return tracks.remove(id) == null;
    }
}
