package ttl.larku.app;

import java.time.LocalDate;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

public class RegistrationApp {

   public static void main(String[] args) {
      RegistrationApp registrationApp = new RegistrationApp();
      //registrationApp.go();
//      registrationApp.overrideEqualsAndHashCode();
      registrationApp.equalsForStrings();
   }

   public void go() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);

      List<Student> students = studentService.getAllStudents();

      System.out.println("Num students: " + students.size());
      for(Student student : students) {
         System.out.println("student: " + student.toString());
      }
   }

   public void overrideEqualsAndHashCode() {
      Student student1 = new Student("Joe", LocalDate.of(2000, 10, 10));
      Student student2 = new Student("Joe", LocalDate.of(2000, 10, 10));


      if(student1.toString().equals(student2.toString())) {
         System.out.println("Equal");
      }else {
         System.out.println("Not Equal");
      }
   }

   public void equalsForStrings() {
      int i = 10;
      String s1 = "hello";
      String s2 = new String("hello");

//      s2 = "bye";


      if(s1.equals(s2)) {
         System.out.println("Equal");
      }else {
         System.out.println("Not Equal");
      }
   }
}
