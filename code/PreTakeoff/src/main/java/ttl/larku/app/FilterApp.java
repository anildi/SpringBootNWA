package ttl.larku.app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class FilterApp {
   public static void main(String[] args) {
      FilterApp fa = new FilterApp();
      //fa.simpleFilter();
//      fa.callSlightlyBetterChecker();
      fa.callBetterChecker();
   }

   public void simpleFilter() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      List<Student> withM = findStudentsStartingWith(students, "M");

      out.println("num: " + withM.size());
      //withM.forEach(s -> System.out.println(s));
      withM.forEach(out::println);
   }

   public void callSlightlyBetterChecker() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

//      NameStartsWithM nswm = new NameStartsWithM();

      Checker withMChecker = s -> s.getName().startsWith("M");

//      List<Student> withM = slightlyBetterChecker(students, nswm);
      //List<Student> withM = slightlyBetterChecker(students, withMChecker);
//      List<Student> withM = slightlyBetterChecker(students, s -> s.getName().startsWith("M"));

      //List<Student> withM = slightlyBetterChecker(students, s -> s.getPhoneNumber().startsWith("579"));

      List<Student> withM = slightlyBetterChecker(students,
            s -> s.getDob().until(LocalDate.now(), ChronoUnit.YEARS) >= 30);

      out.println("num: " + withM.size());
      //withM.forEach(s -> System.out.println(s));
      withM.forEach(out::println);
   }

   public void callBetterChecker() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      BetterChecker<Student> withMChecker = s -> s.getName().startsWith("M");

//      List<Student> withM = betterChecker(students, withMChecker);

      //List<Student> withM = slightlyBetterChecker(students, withMChecker);
//      List<Student> withM = slightlyBetterChecker(students, s -> s.getName().startsWith("M"));

//      List<Student> withM = betterChecker(students, s -> s.getPhoneNumber().startsWith("579"));

      List<Student> withM = bestChecker(students,
            s -> s.getDob().until(LocalDate.now(), ChronoUnit.YEARS) >= 30);

      List<String> strings = List.of("one", "two", "threeeeeee");
      List<String> largerThan4 = bestChecker(strings, s -> s.startsWith("o") || s.length() > 4);

      out.println("num: " + largerThan4.size());
      //withM.forEach(s -> System.out.println(s));
      largerThan4.forEach(out::println);
   }

   public <T> List<T> bestChecker(List<T> input, Predicate<T> checker) {
      List<T> result = new ArrayList<>();
      for(T s : input) {
         if(checker.test(s)) {
            result.add(s);
         }
      }
      return result;
   }

   @FunctionalInterface
   public interface BetterChecker<T>
   {
      public boolean check(T t);
   }

   public <T> List<T> betterChecker(List<T> input, BetterChecker<T> checker) {
      List<T> result = new ArrayList<>();
      for(T s : input) {
         if(checker.check(s)) {
            result.add(s);
         }
      }
      return result;
   }

   public interface Checker
   {
      public boolean check(Student s);
   }

   public List<Student> slightlyBetterChecker(List<Student> input, Checker checker) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         if(checker.check(s)) {
            result.add(s);
         }
      }
      return result;
   }

   class NameStartsWithM implements Checker
   {
      @Override
      public boolean check(Student s) {
         return s.getName().startsWith("M");
      }
   }

   class AgeGreaterThan30 implements Checker
   {
      @Override
      public boolean check(Student s) {
         return s.getDob().until(LocalDate.now(), ChronoUnit.YEARS) >= 30;
      }
   }


   public List<Student> findStudentsStartingWith(List<Student> input, String prefix) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         if(s.getName().startsWith(prefix)) {
            result.add(s);
         }
      }
      return result;
   }

   public List<Student> findStudentsWithPhoneNumbersStartingWith(List<Student> input, String prefix) {
      List<Student> result = new ArrayList<>();
      for(Student s : input) {
         if(s.getPhoneNumber().startsWith(prefix)) {
            result.add(s);
         }
      }
      return result;
   }


}
