package ttl.larku.dao;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryStudentDAOTest {

   private InMemoryStudentDAO studentDAO = new InMemoryStudentDAO();

   @Test
   public void testInsertCreatesId() {
      Student student = new Student("Farly", LocalDate.of(1960, 4, 4));
      assertEquals(0, student.getId());

      student = studentDAO.insert(student);
      assertEquals(1, student.getId());
   }
}
