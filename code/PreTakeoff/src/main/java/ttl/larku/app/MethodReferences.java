package ttl.larku.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class MethodReferences {

   public static void main(String[] args) {
      MethodReferences mr = new MethodReferences();
      mr.useFunctions();
   }

   public static void foo(int i) {
      System.out.println("From static foo: " + i);
   }

   public void bar(int i) {
      System.out.println("From instance fn bar: " + i);
   }

   public void useFunctions() {
      List<Integer> lints = List.of(0, 2, 4, 6, 9);

      lints.forEach(MethodReferences::foo);

      lints.forEach(this::bar);

      lints.forEach(System.out::println);
   }

   public void callBestMap() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

//      NameExtractor ne = new NameExtractor();
      Function<Student, String> e = Student::getName;
      Function<Student, String> phoneExtractor = Student::getPhoneNumber;
      Function<Student, LocalDate> dobExtractor = s -> s.getDob();

      List<String> names = bestMap(students, phoneExtractor);

      List<LocalDate> dobs = bestMap(students, dobExtractor);

      dobs.forEach(out::println);

      MapApp.TriFunction<Student, Integer, String, String> tf = (t, u, v) -> "boo";
   }

   public <T, R> List<R> bestMap(List<T> input, Function<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T s : input) {
         result.add(extractor.apply(s));
      }

      return result;
   }
}
