package ttl.listexample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ttl.larku.domain.Student;

public class ListCreation {

   @Test
   public void listCreation() {
      List<Student> students = new ArrayList<>(List.of(
            new Student("a", LocalDate.EPOCH),
            new Student("b", LocalDate.now())
      ));
   }
}
