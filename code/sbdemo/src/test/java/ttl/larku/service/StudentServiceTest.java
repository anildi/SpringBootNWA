package ttl.larku.service;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {LarkUConfig.class})

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentServiceTest {

   @Autowired
   private StudentService studentService; // = new StudentService();

   @BeforeEach
   public void init() {

   }

   @Test
   public void testInsertStudent() {
      Student student = new Student("Frank", LocalDate.parse("1906-10-10"));

      Student newStudent = studentService.createStudent(student);
      //asdfasdfasdfasdfasdfasdfasdfasdfasdf   asdfasdfasdfasdf
      assertTrue(newStudent.getId() > 0);
      List<Student> students = studentService.getAllStudents();
      assertEquals(1, students.size());
   }

   @Test
   public void testUpdateStudent() {
      Student student = new Student("Frank", LocalDate.parse("1906-10-10"));

      student = studentService.createStudent(student);

      student.setName("New Name");

      boolean result = studentService.updateStudent(student);
      assertTrue(result);

      assertEquals(1, studentService.getAllStudents().size());
   }

   @Test
   public void testDeleteStudent() {
      Student student = new Student("Frank", LocalDate.parse("1906-10-10"));
      student = studentService.createStudent(student);

      Student student2 = new Student("Samang", LocalDate.parse("1906-10-10"));
      student2 = studentService.createStudent(student2);

      assertEquals(2, studentService.getAllStudents().size());

      boolean result = studentService.deleteStudent(student.getId());
      assertTrue(result);

      assertEquals(1, studentService.getAllStudents().size());
   }


   @Test
   public void testInsertTooYoungStudentThrowsException() {
      assertThrows(IllegalArgumentException.class, () -> {

         Student student = new Student("Frank", LocalDate.parse("2022-10-10"));

         Student newStudent = studentService.createStudent(student);

      });
   }
}
