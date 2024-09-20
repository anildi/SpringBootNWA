package ttl.larku.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class MapApp {
   public static void main(String[] args) {
      MapApp fa = new MapApp();
      //fa.callSimpleMap();
      //fa.callSlightlyBetterMap();
      //fa.callBetterMap();
      fa.callBestMap();
   }

   public void callSimpleMap() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      List<String> names = simpleMap(students);

      names.forEach(out::println);
   }

   public void callSlightlyBetterMap() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

//      NameExtractor ne = new NameExtractor();
      Extractor e = s -> s.getName();
      Extractor phoneExtractor = s -> s.getPhoneNumber();

      List<String> names = slightlyBetterMap(students, phoneExtractor);

      names.forEach(out::println);
   }

   public void callBetterMap() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

//      NameExtractor ne = new NameExtractor();
      BetterExtractor<Student, String> e = s -> s.getName();
      BetterExtractor<Student, String> phoneExtractor = s -> s.getPhoneNumber();
      BetterExtractor<Student, LocalDate> dobExtractor = s -> s.getDob();

      List<String> names = betterMap(students, phoneExtractor);

      List<LocalDate> dobs = betterMap(students, dobExtractor);

      dobs.forEach(out::println);
   }

   public static void foo(int i) {}
   public void bar(int i) {}

   public void callBestMap() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

//      NameExtractor ne = new NameExtractor();
      Function<Student, String> e = Student::getName;
      Function<Student, String> phoneExtractor = s -> s.getPhoneNumber();
      Function<Student, LocalDate> dobExtractor = s -> s.getDob();

      List<String> names = bestMap(students, phoneExtractor);

      List<LocalDate> dobs = bestMap(students, dobExtractor);

      dobs.forEach(out::println);

      TriFunction<Student, Integer, String, String> tf = (t, u, v) -> "boo";
   }

   public <T, R> List<R> bestMap(List<T> input, Function<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T s : input) {
         result.add(extractor.apply(s));
      }

      return result;
   }

   public interface TriFunction<T, U, V, R>
   {
      public R extract(T t, U u, V v);
   }

   public interface BetterExtractor<T, R>
   {
      public R extract(T t);
   }

   public <T, R> List<R> betterMap(List<T> input, BetterExtractor<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T s : input) {
         result.add(extractor.extract(s));
      }

      return result;
   }

   public interface Extractor
   {
      public String extract(Student student);
   }

   public List<String> slightlyBetterMap(List<Student> input, Extractor extractor) {
      List<String> result = new ArrayList<>();
      for(Student s : input) {
         result.add(extractor.extract(s));
      }

      return result;
   }

   class NameExtractor implements Extractor
   {
      @Override
      public String extract(Student student) {
         return student.getName();
      }
   }


   public List<String> simpleMap(List<Student> input) {
      List<String> result = new ArrayList<>();
      for(Student s : input) {
         result.add(s.getName());
      }

      return result;
   }

   public List<String> simpleMapForPhoneNumbers(List<Student> input) {
      List<String> result = new ArrayList<>();
      for(Student s : input) {
         result.add(s.getPhoneNumber());
      }

      return result;
   }

}
