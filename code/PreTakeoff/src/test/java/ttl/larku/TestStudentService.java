package ttl.larku;

import org.junit.jupiter.api.Test;
import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class TestStudentService {

    @Test
    public void testInsert() {
        String name = "Francine";
        Student newStudent = new Student(name, LocalDate.of(2000, 10, 20));
        assertEquals(0, newStudent.getId());

        StudentService service = new StudentService();

        Student insertedStudent = service.addStudent(newStudent);
        assertEquals(1, insertedStudent.getId());

        Student foundStudent = service.getStudent(1);

        assertEquals(name, foundStudent.getName());

        List<Student> students = service.getAll();
        assertEquals(1, students.size());
    }
}
