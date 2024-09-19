package ttl.track.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ttl.track.domain.Track;

public class TrackDAO {

   private Map<Integer, Track> tracks = new HashMap<>();
   private int nextId = 1;

   public Track create(Track track) {
      int id = nextId++;
      track.setId(id);
      tracks.put(track.getId(), track);

      return track;
   }

   public Track findById(int id) {
      return tracks.get(id);
   }

   public List<Track> findAll() {
      return new ArrayList<>(tracks.values());
   }

   public boolean update(Track track) {
      return tracks.replace(track.getId(), track) != null;
   }

   public boolean delete(int id) {
      return tracks.remove(id) != null;
   }
}
