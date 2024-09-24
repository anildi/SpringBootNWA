package ttl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.OtherService;
import ttl.larku.service.StudentService;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

import static java.lang.System.out;

@SpringBootApplication
//@Configuration
//@ComponentScan

//@EnableAutoConfiguration
public class SbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdemoApplication.class, args);
	}
}

@Component
class MyRunner implements CommandLineRunner
{
	@Autowired
	private StudentService studentService;

	@Autowired
	private OtherService otherService;

	@Override
	public void run(String... args) throws Exception {
		StudentData.initStudentService(studentService);

		List<Student> students = studentService.getAllStudents();
		out.println("Students: " + students.size());
		students.forEach(out::println);

		otherService.doit();
	}
}

@Component
class YourRunner implements CommandLineRunner
{
	@Autowired
	private TrackService trackService;

	@Override
	public void run(String... args) throws Exception {
		List<Track> tracks = trackService.getAllTracks();
		out.println("Tracks: " + tracks.size());
		tracks.forEach(out::println);
	}
}
