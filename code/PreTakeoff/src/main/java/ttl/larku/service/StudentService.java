package ttl.larku.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.domain.Student;

public class StudentService {

   private InMemoryStudentDAO studentDAO = new InMemoryStudentDAO();

   public Student createStudent(Student student) {
      long years = student.getDob().until(LocalDate.now(), ChronoUnit.YEARS);
      if(years < 18) {
         throw new IllegalArgumentException("Student should be at least 18: " + years);
      }

      Student newStudent = studentDAO.insert(student);

      return newStudent;
   }

   public Student getStudent(int id) {
      return studentDAO.findById(id);
   }

   public List<Student> getAllStudents() {
      return studentDAO.findAll();
   }

   public boolean updateStudent(Student student) {
      return studentDAO.update(student);
   }

   public boolean deleteStudent( int id) {
     return studentDAO.delete(id);
   }
}
