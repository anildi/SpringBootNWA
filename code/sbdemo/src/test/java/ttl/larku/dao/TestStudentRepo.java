package ttl.larku.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ttl.larku.dao.respository.StudentRepo;
import ttl.larku.domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
@SpringBootTest
public class TestStudentRepo {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void testStudentRepoGetAll() {
        List<Student> students = studentRepo.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        assertEquals(4, students.size());
    }

    @Test
    public void testFindByName() {
        //List<Student> students = studentRepo.findByName("Madhu");
        //List<Student> students = studentRepo.findByNameContaining("Madhu");
        List<Student> students = studentRepo.findByNameContainingIgnoreCase("madhu");
        for (Student student : students) {
            System.out.println(student);
        }

        assertEquals(1, students.size());


    }

}
