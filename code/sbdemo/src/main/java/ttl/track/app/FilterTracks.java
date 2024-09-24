package ttl.track.app;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import ttl.track.dao.TrackData;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

import static java.lang.System.out;

public class FilterTracks {

   public static void main(String[] args) {
      FilterTracks ft = new FilterTracks();
      ft.go();
   }

   public void go() {
      TrackService trackService = new TrackService();
      TrackData.initTracks(trackService);

      List<Track> tracks = trackService.getAllTracks();

//      tracks.forEach(out::println);

      List<Track> mp3s = findBy(tracks, t -> t.getFormat() == Track.Format.MP3);

//      mp3s.forEach(out::println);

      List<Track> durationLt3Minutes = findBy(tracks, t -> t.getDuration().compareTo(Duration.ofMinutes(3)) > 0);

      durationLt3Minutes.forEach(out::println);

      List<String> strings = List.of("one", "two", "threeeeeee");
      List<String> largerThan4 = findBy(strings, s -> s.startsWith("o") || s.length() > 4);

      out.println("num: " + largerThan4.size());

   }

   public <T> List<T> findBy(List<T> tracks, Predicate<T> pred) {
      List<T> result = new ArrayList<>();
      for(T track : tracks) {
         if(pred.test(track)) {
            result.add(track);
         }
      }

      return result;
   }

   public List<Track> findByAlmostThere(List<Track> tracks, Predicate<Track> pred) {
      List<Track> result = new ArrayList<>();
      for(Track track : tracks) {
         if(pred.test(track)) {
            result.add(track);
         }
      }

      return result;
   }
}
