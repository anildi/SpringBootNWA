package ttl.larku.dao;

import org.junit.jupiter.api.Test;
import ttl.larku.domain.Student;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author whynot
 */
public class TestStudentDAO {

    @Test
    public void testInsertAndGet() {
        String name = "Francine";
        Student newStudent = new Student(name, LocalDate.of(2000, 10, 20));
        assertEquals(0, newStudent.getId());

        StudentDAO dao = new StudentDAO();

        Student insertedStudent = dao.insert(newStudent);
        assertEquals(1, insertedStudent.getId());

        Student foundStudent = dao.get(1);

        assertEquals(name, foundStudent.getName());

        List<Student> students = dao.getAll();
        assertEquals(1, students.size());
    }

    @Test
    public void breakUpdate() {
        String name = "Francine";
        Student newStudent = new Student(name, LocalDate.of(2000, 10, 20));

        StudentDAO dao = new StudentDAO();
        Student insertedStudent = dao.insert(newStudent);

        Student brandNew = new Student("Faker", LocalDate.of(2000, 10, 20));
        brandNew.setId(100);

        boolean result = dao.update(brandNew);
        assertFalse(result);

        Student foundStudent = dao.get(100);

        assertNull(foundStudent);
    }

    @Test
    public void testDelete() {
        String name = "Francine";
        Student newStudent = new Student(name, LocalDate.of(2000, 10, 20));

        StudentDAO dao = new StudentDAO();

        boolean result = dao.delete(100000);

        assertFalse(result);

    }
}
