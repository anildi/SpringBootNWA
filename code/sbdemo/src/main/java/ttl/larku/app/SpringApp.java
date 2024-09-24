package ttl.larku.app;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.OtherService;
import ttl.larku.service.StudentService;

import static java.lang.System.out;

public class SpringApp {

   public static void main(String[] args) {
      SpringApp springApp = new SpringApp();

      //springApp.go();
      springApp.otherService();
   }

   public void go() {
      //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

      StudentService studentService = context.getBean("mybean", StudentService.class);

//      StudentService studentService2 = context.getBean("studentService", StudentService.class);

      List<Student> students = studentService.getAllStudents();
      out.println("Students: " + students.size());
      students.forEach(out::println);
   }

   public void otherService() {
      //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

      OtherService otherService = context.getBean("otherService", OtherService.class);

      otherService.doit();
   }
}
