package ttl.larku.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

   @Autowired
   private StudentService studentService;

   @GetMapping
   public List<Student> getAllStudents() {
      List<Student> students = studentService.getAllStudents();
      return students;
   }

   @GetMapping("/{id}")
   public Student getStudent(@PathVariable("id") int id) {
      Student student = studentService.getStudent(id);
      return student;
   }

   @PostMapping
   public Student addStudent(@RequestBody Student student) {
      Student newStudent = studentService.createStudent(student);

      return newStudent;
   }

   //REpresentational State Transfer
}
