package ttl.larku.dao.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestStudentRepo {

   @Autowired
   private StudentRepo studentRepo;

   @Test
   public void testGetAllStudents() {
      List<Student> students = studentRepo.findAll();

      assertEquals(4, students.size());
   }

   @Test
   public void testCustomFindMethods() {
//      List<Student> students = studentRepo.findAll();
      //List<Student> students = studentRepo.findStudentByName("Frank_Mysql");
      //List<Student> students = studentRepo.findStudentByNameContaining("Frank");
      List<Student> students = studentRepo.findStudentByNameContaining("frank");

      System.out.println(students);

      assertEquals(1, students.size());
   }
}
