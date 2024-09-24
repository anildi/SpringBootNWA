package ttl.larku.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class StreamsApp {

   public static void main(String[] args) {
      StreamsApp mr = new StreamsApp();
//      mr.tryFilterAndStream();
//      mr.simpleStreams();
      mr.terminalOps();
   }

   public void tryFilterAndStream() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      //get the dob of all students whose names start with M
      List<Student> withM = bestChecker(students, s -> s.getName().startsWith("M"));
      List<String> namesWithM = bestMap(withM, Student::getName);

      List<String> names2 = bestMap(bestChecker(students, s -> s.getName().startsWith("M")), Student::getName);

      namesWithM.forEach(out::println);

   }

   public void byHand() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();
      List<String> result = new ArrayList<>();

      for (Student student : students) {
         if (student.getName().startsWith("M")) {
            String name = student.getName();
            result.add(name);
         }
      }

      for (Student student : students) {
         String name = student.getName();
         if (name.startsWith("M")) {
            result.add(name);
         }
      }

   }

   public void simpleStreams() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      List<String> namesWithM = students.stream()
            .peek(s -> out.println("Peek 1: " + s))
            .filter(s -> s.getName().startsWith("M"))
            .peek(s -> out.println("Peek 2: " + s))
            .map(s -> s.getName())
            .peek(s -> out.println("Peek 3: " + s))
            .toList();

      var namesWithM2 = students.stream()
            //.filter(s -> s.getName().startsWith("M"))
            .filter(s -> s.getStatus() == Student.Status.FULL_TIME)
            .map(s -> s.getDob())
            .toList();

      namesWithM2.forEach(out::println);

   }

   public void terminalOps() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      var namesWithM2 = students.stream()
            //.filter(s -> s.getName().startsWith("M"))
            .filter(s -> s.getStatus() == Student.Status.FULL_TIME)
//            .toArray(Student[]::new);
            .toList();

      var listToMap = students.stream()
//            .toArray(Student[]::new);
            .collect(Collectors.groupingBy(s -> s.getStatus(), Collectors.counting()));

      var mapById = students.stream()
//            .toArray(Student[]::new);
            .collect(Collectors.groupingBy(s -> s.getId()));

      var map2 = students.stream()
//            .toArray(Student[]::new);
            .collect(Collectors.toMap(s -> s.getId(), s -> s));

      map2.forEach((k, v) -> out.println("k: " + k + ", v: " + v)) ;

   }

   public void customPredAndFunction() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);
      List<Student> students = studentService.getAllStudents();

      Predicate<Student> pred = s -> s.getStatus() == Student.Status.FULL_TIME;
      //Function<Student, LocalDate> func = s -> s.getDob();
      Function<Student, LocalDate> func = Student::getDob;

      var result = filterAndMap(students, pred, func);
      out.println(result);
   }

   public <T, R> List<R> filterAndMap(List<T> input, Predicate<T> pred, Function<T, R> extractor) {
      List<R> result = input.stream()
            .filter(pred)
            .map(extractor)
            .toList();
      return result;
   }

   public <T, R> List<R> bestMap(List<T> input, Function<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for (T s : input) {
         result.add(extractor.apply(s));
      }

      return result;
   }

   public <T> List<T> bestChecker(List<T> input, Predicate<T> checker) {
      List<T> result = new ArrayList<>();
      for (T s : input) {
         if (checker.test(s)) {
            result.add(s);
         }
      }
      return result;
   }
}
