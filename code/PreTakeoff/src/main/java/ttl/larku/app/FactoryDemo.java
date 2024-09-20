package ttl.larku.app;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class FactoryDemo {

   private StudentService studentService = new StudentService();

   public static void main(String[] args) {
      FactoryDemo fd = new FactoryDemo();

      fd.postAStudent();

      fd.getStudents();
   }


   public void postAStudent() {

      Student s = new Student("Charlie", LocalDate.of(1986, 5, 5));
      studentService.createStudent(s);

      List<Student> students = studentService.getAllStudents();
      out.println("Students: " + students.size());
      students.forEach(out::println);
   }

   public void getStudents() {

      List<Student> students = studentService.getAllStudents();
      out.println("Get Students: " + students.size());
      students.forEach(out::println);
   }
}
