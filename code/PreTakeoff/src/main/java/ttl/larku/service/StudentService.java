package ttl.larku.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import ttl.larku.dao.DaoFactory;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.dao.MysqlStudentDAO;
import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

public class StudentService {

   List<String> l = new ArrayList<>();

   //   private InMemoryStudentDAO studentDAO = new InMemoryStudentDAO();
   //private MysqlStudentDAO studentDAO = new MysqlStudentDAO();
   //private StudentDAO studentDAO = new MysqlStudentDAO();
//   private StudentDAO studentDAO = new InMemoryStudentDAO();
   private StudentDAO studentDAO = DaoFactory.studentDAO();

   public Student createStudent(Student student) {
      long years = student.getDob().until(LocalDate.now(), ChronoUnit.YEARS);
      if (years < 18) {
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

   public boolean deleteStudent(int id) {
      return studentDAO.delete(id);
   }

   //   public InMemoryStudentDAO getStudentDAO() {
//   public MysqlStudentDAO getStudentDAO() {
   public StudentDAO getStudentDAO() {
      return studentDAO;
   }
}
