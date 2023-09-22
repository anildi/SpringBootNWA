package ttl.larku.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */
public class SpringDemo {

    public static void main(String[] args) {
        SpringDemo sd = new SpringDemo();
        //sd.goStudent();
        sd.goCourse();
    }

    public void goStudent() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        StudentService ss = context.getBean("studentService", StudentService.class);

        StudentService ss2 = context.getBean("studentService", StudentService.class);

        List<Student> students = ss.getAllStudents();
        System.out.println("Student: " + students.size());
        students.forEach(System.out::println);
    }

    public void goCourse() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

        CourseService ss = context.getBean("courseService", CourseService.class);

        List<Course> courses = ss.getAllCourses();
        System.out.println("Course: " + courses.size());
        courses.forEach(System.out::println);
    }
}
