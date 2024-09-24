package ttl.track.dao;

import java.util.List;
import ttl.track.domain.Track;

public interface TrackDAO {
   Track create(Track track);

   Track findById(int id);

   List<Track> findAll();

   boolean update(Track track);

   boolean delete(int id);
}
