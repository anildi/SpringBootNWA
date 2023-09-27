package ttl.larku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ttl.larku.service.TrackService;
import ttl.larku.domain.Track;

import java.util.List;

@SpringBootApplication
//@ComponentScan(value = {"ttl.larku", "ttl.track.tracksolution"})
public class TracksolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracksolutionApplication.class, args);
	}

}

@Component
class MyRunner implements CommandLineRunner
{
	@Autowired
	private TrackService trackService;

	@Override
	public void run(String... args) throws Exception {
		List<Track> tracks = trackService.getAllTracks();
		System.out.println("tracks: " + tracks.size());
		tracks.forEach(System.out::println);
	}
}
