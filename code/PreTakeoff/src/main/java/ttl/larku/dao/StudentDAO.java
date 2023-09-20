package ttl.larku.dao;

import ttl.larku.domain.Student;

import java.util.*;

/**
 * @author whynot
 */
public class StudentDAO {

//    Student [] students = new Student[10];
//    List<Student> students = new ArrayList<>();
    private Map<Integer, Student> students = new HashMap<>();
    private int nextId = 1;

    public Student get(int id) {
        return students.get(id);
    }

    public Student insert(Student newStudent) {
        int id = nextId++;
        newStudent.setId(id);

        students.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    public boolean update(Student oldStudent) {
        if(students.containsKey(oldStudent.getId())) {
            students.put(oldStudent.getId(), oldStudent);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return students.remove(id) != null;
    }

}
