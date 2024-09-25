package ttl.larku.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentRepoService;
import ttl.larku.service.StudentService;

@RestController
@RequestMapping("/studentrepo")
public class StudentRepoController {

   @Autowired
   private StudentRepoService studentService;

   @GetMapping
   public List<Student> getAllStudents() {
      List<Student> students = studentService.getAllStudents();
      return students;
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
      Student student = studentService.getStudent(id);
      if (student == null) {
         var r = ResponseEntity.status(404).body("No Student with id: " + id);
         return r;
      }
      return ResponseEntity.ok(student);
   }

   @PostMapping
   public ResponseEntity<?> addStudent(@RequestBody Student student) throws URISyntaxException {
      Student newStudent = studentService.createStudent(student);

      //URI uri = new URI("http://localhost:8080/student/" + newStudent.getId());

      URI newResource = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newStudent.getId())
            .toUri();

      //return ResponseEntity.created(newResource).body(newStudent);
      return ResponseEntity.created(newResource).build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
      boolean result = studentService.deleteStudent(id);
      if(!result) {
         var r = ResponseEntity.status(404).body("No Student with id: " + id);
         return r;
      }

      return ResponseEntity.noContent().build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> updateStudent(@PathVariable("id") int id,
                                          @RequestBody Student student) {
      boolean result = studentService.updateStudent(student);
      if(!result) {
         var r = ResponseEntity.status(404).body("No Student with id: " + id);
         return r;
      }

      return ResponseEntity.noContent().build();
   }

   //Safe   GET
   //Idempotent DELETE, PUT


   //POST  do whatever you want

   //REpresentational State Transfer
}
