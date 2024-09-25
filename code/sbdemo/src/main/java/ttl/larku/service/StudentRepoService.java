package ttl.larku.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttl.larku.dao.StudentDAO;
import ttl.larku.dao.repository.StudentRepo;
import ttl.larku.domain.Student;

@Service
public class StudentRepoService {

   @Autowired
   private StudentRepo studentDAO;

   public StudentRepoService() {
      int stop = 0;
   }


   public Student createStudent(Student student) {
      long years = student.getDob().until(LocalDate.now(), ChronoUnit.YEARS);
      if (years < 18) {
         throw new IllegalArgumentException("Student should be at least 18: " + years);
      }

      Student newStudent = studentDAO.save(student);

      return newStudent;
   }

   public Student getStudent(int id) {
      Optional<Student> student = studentDAO.findById(id);
      return student.orElse(null);
   }

   public List<Student> getAllStudents() {
      return studentDAO.findAll();
   }

   public boolean updateStudent(Student student) {
      var result = studentDAO.save(student);
      return true;
   }

   public boolean deleteStudent(int id) {
      studentDAO.deleteById(id);
      return true;
   }
}
