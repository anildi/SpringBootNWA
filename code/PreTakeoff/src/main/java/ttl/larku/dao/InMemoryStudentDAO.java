package ttl.larku.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ttl.larku.domain.Student;

public class InMemoryStudentDAO {

//   List<Student> studentList = new ArrayList<>();
   private Map<Integer, Student> students = new HashMap<>();
   private int nextId = 1;


   public Student insert(Student student) {
      int id = nextId++;
      student.setId(id);

      students.put(student.getId(), student);

      return student;
   }

   public Student findById(int id) {
     return students.get(id);
   }

   public List<Student> findAll() {
      return new ArrayList<>(students.values());
   }

   public boolean update(Student student) {
      return students.replace(student.getId(), student) != null;
   }

   public boolean delete(int id) {
      return students.remove(id) != null;
   }
}
