package ttl.larku.domain;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentTest {

   @Test
   public void testCreateStudentWith2ArgConstrucotr() {
      Student student = new Student("Joey", LocalDate.of(2000, 10, 10));

      assertNotNull(student.getName());

      assertEquals(Student.Status.FULL_TIME, student.getStatus());
   }

   @Test
   public void testCreateStudentWithAllArgsConstrucotr() {
      Student student = new Student(1, "Joey",
            LocalDate.of(2000, 10, 10), "383 922 9229929", Student.Status.HIBERNATING);

      assertNotNull(student.getName());
      assertEquals(Student.Status.HIBERNATING, student.getStatus());
   }


}
