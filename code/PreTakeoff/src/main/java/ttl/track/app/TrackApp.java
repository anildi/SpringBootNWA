package ttl.track.app;

import java.util.List;
import ttl.track.dao.TrackData;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

public class TrackApp {

   public static void main(String[] args) {
      go();
   }

   public static void go() {
      TrackService trackService = new TrackService();
      TrackData.initTracks(trackService);

      List<Track> tracks = trackService.getAllTracks();
      for(Track track : tracks) {
         System.out.println(track);
      }
   }
}
