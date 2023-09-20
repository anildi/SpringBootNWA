package ttl.larku.service;

import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

import java.util.List;

/**
 * @author whynot
 */
public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public Student getStudent(int id) {
        return studentDAO.get(id);
    }

    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    public Student addStudent(Student student) {
        return studentDAO.insert(student);
    }

    public boolean updateStudent(Student student) {
        return studentDAO.update(student);
    }

    public boolean deleteStudent(int id) {
        return studentDAO.delete(id);
    }
}
