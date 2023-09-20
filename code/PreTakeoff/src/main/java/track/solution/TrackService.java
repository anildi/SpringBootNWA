package track.solution;

import track.solution.dao.TrackDAO;
import track.solution.domain.Track;

import java.util.List;

/**
 * @author whynot
 */
public class TrackService {

    private TrackDAO trackDAO = new TrackDAO();
    public Track getTrack(int id) {
       return trackDAO.get(id);
    }

    public List<Track> getAllTracks() {
        return trackDAO.getAll();
    }

    public Track addTrack(Track newTrack) {
        return trackDAO.insert(newTrack);
    }
}
