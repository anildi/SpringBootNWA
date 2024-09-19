package ttl.larku.jconfig;

import java.time.LocalDate;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

public class StudentData {

   public static void initStudentService(StudentService service) {
      service.createStudent(new Student("Charlene", LocalDate.of(1960, 10, 10), "38 0202 02202", Student.Status.FULL_TIME));
      service.createStudent(new Student("Mingo", LocalDate.of(2000, 5, 14), "579 93 9339939", Student.Status.PART_TIME));
      service.createStudent(new Student("Manoj", LocalDate.of(1955, 8, 15), "895 758 84843", Student.Status.HIBERNATING));
      service.createStudent(new Student("Tanmoy", LocalDate.of(1990, 3, 18), "9378 383 7338", Student.Status.FULL_TIME));
      service.createStudent(new Student("Phiroze", LocalDate.of(1999, 8, 10), "89 93439 93393", Student.Status.PART_TIME));
   }
}
