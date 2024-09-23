package ttl.larku.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class InMemoryCourseDAO implements CourseDAO {

   public InMemoryCourseDAO() {
      int stop = 0;
   }

   @Override
   public void doit() {
      System.out.println("In Inmem OtherDAO::doit");
   }
}
