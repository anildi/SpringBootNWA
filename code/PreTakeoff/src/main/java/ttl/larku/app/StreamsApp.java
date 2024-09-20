package ttl.larku.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class StreamsApp {

   public static void main(String[] args) {
      StreamsApp mr = new StreamsApp();
//      mr.tryFilterAndStream();
      mr.simpleStreams();
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

      for(Student student : students) {
         if(student.getName().startsWith("M")) {
            String name = student.getName();
            result.add(name);
         }
      }

      for(Student student : students) {
         String name = student.getName();
         if(name.startsWith("M")) {
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
            .peek(s -> out.println("Peek 1: " + s))
            .filter(s -> s.getName().startsWith("M"))
            .peek(s -> out.println("Peek 2: " + s))
            .map(s -> s.getDob())
            .peek(s -> out.println("Peek 3: " + s));
//            .toList();

      namesWithM2.forEach(out::println);
      namesWithM2.toList();

   }


   public <T, R> List<R> bestMap(List<T> input, Function<T, R> extractor) {
      List<R> result = new ArrayList<>();
      for(T s : input) {
         result.add(extractor.apply(s));
      }

      return result;
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
}
