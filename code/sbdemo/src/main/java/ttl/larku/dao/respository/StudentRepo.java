package ttl.larku.dao.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttl.larku.domain.Student;

import java.util.List;

/**
 * @author whynot
 */
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);
    List<Student> findByNameContaining(String name);
    List<Student> findByNameContainingIgnoreCase(String name);
}
