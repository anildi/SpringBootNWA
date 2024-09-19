package ttl.larku.service;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentServiceTest {

   private StudentService studentService = new StudentService();

   @Test
   public void testInsertStudent() {
      Student student = new Student("Frank", LocalDate.parse("1906-10-10"));

      Student newStudent = studentService.createStudent(student);
      //asdfasdfasdfasdfasdfasdfasdfasdfasdf   asdfasdfasdfasdf
      assertTrue(newStudent.getId() > 0);
   }

   @Test
   public void testInsertTooYoungStudentThrowsException() {
      assertThrows(IllegalArgumentException.class, () -> {

         Student student = new Student("Frank", LocalDate.parse("2022-10-10"));

         Student newStudent = studentService.createStudent(student);

//         assertTrue(newStudent.getId() > 0);
      });
   }
}
