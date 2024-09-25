package ttl.larku.service;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class StudentServiceUnitTest {

   @Mock
   private StudentDAO studentDAO;

   @InjectMocks
   private StudentService studentService;

   private List<Student> fakeStudents =
         List.of(new Student("Joe", LocalDate.of(2000, 10, 10)),
               new Student("Rachna", LocalDate.of(1960, 11, 2)));

   @Test
   public void testGetOneStudent() {
      Mockito.when(studentDAO.findById(1)).thenReturn(fakeStudents.get(0));

      Student student = studentService.getStudent(1);

      assertSame(student, fakeStudents.get(0));
//      assertEquals(student, fakeStudents.get(0));

      Mockito.verify(studentDAO).findById(1);
   }

   @Test
   public void testUpateExistingStudent() {
      Student student = fakeStudents.get(0);
      Mockito.when(studentDAO.update(student)).thenReturn(true);

      boolean result = studentService.updateStudent(student);

      assertTrue(result);
//      assertEquals(student, fakeStudents.get(0));

      Mockito.verify(studentDAO).update(student);
   }

   @Test
   public void testUpateNonExistingStudent() {
      Student student = fakeStudents.get(0);
      Mockito.when(studentDAO.update(student)).thenReturn(false);

      boolean result = studentService.updateStudent(student);

      assertFalse(result);
//      assertEquals(student, fakeStudents.get(0));

      Mockito.verify(studentDAO).update(student);
   }
}
