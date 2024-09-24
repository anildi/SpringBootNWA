package ttl.track.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ttl.track.domain.Track;

@Repository
@Profile("prod")
public class MysqlTrackDAO implements TrackDAO {

   private Map<Integer, Track> tracks = new ConcurrentHashMap<>();
   private AtomicInteger nextId = new AtomicInteger(1);

   @Override
   public Track create(Track track) {
      //int id = nextId++;
      int id = nextId.getAndIncrement();
//      track.setId(id);
      track = track.withId(id);
      tracks.put(track.getId(), track);

      return track;
   }

   @Override
   public Track findById(int id) {
      return tracks.get(id);
   }

   @Override
   public List<Track> findAll() {
      return new ArrayList<>(tracks.values());
   }

   @Override
   public boolean update(Track track) {
      return tracks.replace(track.getId(), track) != null;
   }

   @Override
   public boolean delete(int id) {
      return tracks.remove(id) != null;
   }
}
