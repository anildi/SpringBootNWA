package ttl.larku.app;

import ttl.larku.domain.Student;

import java.time.LocalDate;

/**
 * @author whynot
 */
public class StudentApp {

    public static void main(String[] args) {
        Student student = new Student(1, "Alex", LocalDate.of(1990, 2, 5), Student.Status.HIBERNATING);

        Student student2 = new Student(2, "Alex", LocalDate.of(1990, 2, 5));

        System.out.println("student : " + student.toString());

    }
}
