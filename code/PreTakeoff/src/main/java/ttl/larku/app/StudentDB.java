package ttl.larku.app;

import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;

/**
 * @author whynot
 */
public class StudentDB {

    public static void initService(StudentService ss) {
        ss.addStudent(new Student("Frank", LocalDate.of(2000, 10, 10)));
        ss.addStudent(new Student("Tarla", LocalDate.of(1999, 8, 15), Student.Status.PART_TIME));
        ss.addStudent(new Student("Oz", LocalDate.of(2010, 6, 8)));
        ss.addStudent(new Student("Manoj", LocalDate.of(1976, 7, 10), Student.Status.HIBERNATING));
    }
}
