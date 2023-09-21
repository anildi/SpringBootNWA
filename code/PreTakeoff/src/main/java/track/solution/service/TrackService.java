package track.solution.service;

import track.solution.dao.TrackDAO;
import track.solution.domain.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

   /*
  Write a method called findBy that takes a list of Tracks and returns a list of
Tracks that match search criteria that you specify as a second argument. Use
the appropriate Java interface for filtering.
    */

    public List<Track> findBy(List<Track> input, Predicate<Track> criteria) {
        List<Track> result = new ArrayList<>();
        for(Track track : input) {
            if(criteria.test(track)) {
                result.add(track);
            }
        }
        return result;
    }

    public <T> List<T> findByG(List<T> input, Predicate<T> criteria) {
        List<T> result = new ArrayList<>();
        for(T t : input) {
            if(criteria.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
