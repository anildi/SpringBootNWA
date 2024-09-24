package ttl.track.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttl.track.dao.InMemoryTrackDAO;
import ttl.track.dao.TrackDAO;
import ttl.track.domain.Track;

@Service
public class TrackService {

   @Autowired
   private TrackDAO trackDAO;


   public Track addTrack(Track track) {
      return trackDAO.create(track);
   }

   public Track getTrack(int id) {
      return trackDAO.findById(id);
   }

   public List<Track> getAllTracks() {
      return trackDAO.findAll();
   }

   public boolean updateTrack(Track track) {
      return trackDAO.update(track);
   }

   public boolean delete(int id) {
      return trackDAO.delete(id);
   }

}
