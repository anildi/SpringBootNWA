package ttl.larku.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import ttl.larku.domain.Student;

public class MysqlStudentDAO implements StudentDAO {

//   List<Student> studentList = new ArrayList<>();
//   private Map<Integer, Student> students = new HashMap<>();
//   private int nextId = 1;
   private Map<Integer, Student> students = new ConcurrentHashMap<>();
   private AtomicInteger nextId = new AtomicInteger(1);


   public Student insert(Student student) {
//      int id = nextId++;
      int id = nextId.getAndIncrement();
      student.setId(id);
      student.setName("Mysql: " + student.getName());

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
