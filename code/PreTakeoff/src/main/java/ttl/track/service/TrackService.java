package ttl.track.service;

import java.util.List;
import ttl.track.dao.TrackDAO;
import ttl.track.domain.Track;

public class TrackService {

   private TrackDAO trackDAO = new TrackDAO();


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
