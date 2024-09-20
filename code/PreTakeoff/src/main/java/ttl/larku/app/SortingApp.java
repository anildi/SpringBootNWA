package ttl.larku.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

public class SortingApp {

   public static void main(String[] args) {
      SortingApp sa = new SortingApp();
//      sa.naturalOrder();
      sa.sortByName();
   }

   public void naturalOrder() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);

      List<Student> students = studentService.getAllStudents();
      Student s = students.remove(0);
      students.add(s);

      System.out.println("Before Sort: " + students);

      Collections.sort(students);

      System.out.println("num: " + students.size());
      for(Student student : students) {
         System.out.println(student);
      }
   }

   public void sortByName() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);

      List<Student> students = studentService.getAllStudents();

      NameComparator nc = new NameComparator();

      Comparator<Student> c1 = new Comparator<Student> () {
         @Override
         public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
         }
      };

      Comparator<Student> c2 = (Student o1, Student o2) -> {
            return o1.getName().compareTo(o2.getName());
         };

      Comparator<Student> c3 = (o1, o2) -> {
         return o1.getName().compareTo(o2.getName());
      };

      Comparator<Student> c4 = Collections.reverseOrder((o1, o2) -> o2.getName().compareTo(o1.getName()));
      c4 = c4.reversed();
//      Collections.sort(students, c4);

      //Collections.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));
      Collections.sort(students, Collections.reverseOrder((o1, o2) -> o1.getDob().compareTo(o2.getDob())));



      System.out.println("num: " + students.size());
      for(Student student : students) {
         System.out.println(student);
      }
   }

   class NameComparator implements Comparator<Student> {

      @Override
      public int compare(Student o1, Student o2) {
         return o1.getName().compareTo(o2.getName());
      }
   }


   public static <T extends Comparable<T>> void mysort(List<T> list) {}

   public static <T> void mysort(List<T> list, Comparator<T> c) {}
}
