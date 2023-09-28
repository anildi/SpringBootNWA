package ttl.larku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import javax.sound.midi.Track;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SbdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SbdemoApplication.class, args);
		System.out.println("context size: " + context.getBeanDefinitionCount());
	}
}

@Component
class MyRunner implements CommandLineRunner
{
	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from MyRunner");
		studentService.createStudent("Fali", "383 939 9393", LocalDate.of(1958, 5, 3), Student.Status.FULL_TIME);
		studentService.createStudent("Sammy", "383 939 9393", LocalDate.of(2000, 7, 3), Student.Status.HIBERNATING);
		studentService.createStudent("Rose", "864 838 83838", LocalDate.of(1987, 8, 4), Student.Status.PART_TIME);
		studentService.createStudent("Cynthia", "383 939 9393", LocalDate.of(1999, 2, 14), Student.Status.FULL_TIME);

		List<Student> students = studentService.getAllStudents();
		students.forEach(System.out::println);
	}
}
