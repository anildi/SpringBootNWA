package ttl.larku.reflect.inject;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

/**
 * @author whynot
 */
public class SomeController {

    @MyInject
    private StudentService studentService;

    public void doStuff() {
        studentService.createStudent("Paul", LocalDate.of(2000, 10, 10), Student.Status.FULL_TIME);
        List<Student> students = studentService.getAllStudents();
        System.out.println("students: ");
        students.forEach(System.out::println);
    }
}
