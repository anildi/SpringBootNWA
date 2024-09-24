package ttl.larku.app;

import java.util.List;
import java.util.Map;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.StudentData;
import ttl.larku.service.StudentService;

public class LambdaGames {

   public static void main(String[] args) {
      LambdaGames lg = new LambdaGames();
      lg.consumers();
   }

   public void consumers() {
      StudentService studentService = new StudentService();
      StudentData.initStudentService(studentService);

      List<Student> students = studentService.getAllStudents();

      //students.forEach(new PrintConsumer());

      students.forEach((Student s) -> System.out.println(s));
      students.forEach((s) -> System.out.println(s));

      students.forEach(s -> {
         //Lots of work
               System.out.println(s);
               //Lots of other work
            }
      );

      //void accept(T t)
      students.forEach(System.out::println);
      students.forEach(this::prettyPrintingWithLotsOfOtherWork);

      Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three");

      //void accept(T t, U u)
      map.forEach((k, v) -> {
         System.out.println("k: " + k + ", v: " + v);
      });

      map.forEach(this::doStuffWithMapEntries);
      map.forEach(LambdaGames::doStuffStatically);

      MyInterface mi = x -> System.out.println(x);

   }

   public interface MyInterface {
      public void fun(int i);
   }

   public static void doStuffStatically(Integer it, String str) {

   }

   public void doStuffWithMapEntries(Integer it, String str) {

   }

   public void prettyPrintingWithLotsOfOtherWork(Student s) {
      //Lots of work
      System.out.println(" [[ " + s + " ]]");
      //Lots of work
   }

//   class PrintConsumer implements Consumer<Student>
//   {
//      @Override
//      public void accept(Student student) {
//         System.out.println(student);
//      }
//   }

}
