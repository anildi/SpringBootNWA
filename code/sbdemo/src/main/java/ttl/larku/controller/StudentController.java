package ttl.larku.controller;

import java.net.URI;
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
import ttl.larku.service.StudentService;

/**
 * @author whynot
 */

@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
    private final StudentService studentService;
//    @Autowired
    private final UriCreator uriCreator;

    @Autowired
    public StudentController(StudentService studentService, UriCreator uriCreator) {
        this.studentService = studentService;
        this.uriCreator = uriCreator;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Here we go with REST";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if(student == null) {
        	return ResponseEntity.badRequest().body("Not student found with id: " + id);
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.createStudent(student);

        //String str = "http://localhost:8080/student/" + newStudent.getId();
        
//        URI newResource = ServletUriComponentsBuilder
//              .fromCurrentRequest()
//              .path("/{id}")
//              .buildAndExpand(newStudent.getId())
//              .toUri();

        URI newResource = uriCreator.getURI(student.getId());

        return ResponseEntity.created(newResource).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
    	boolean result = studentService.deleteStudent(id);
    	
    	if(!result) {
        	return ResponseEntity.badRequest().body("Not student found with id: " + id);
    	} 
    		
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
    	boolean result = studentService.updateStudent(student);

    	if(!result) {
        	return ResponseEntity.badRequest().body("Not student found with id: " + student.getId());
    	} 
    		
    	return ResponseEntity.noContent().build();

    }


    //REST = Representational State Transfer
}
