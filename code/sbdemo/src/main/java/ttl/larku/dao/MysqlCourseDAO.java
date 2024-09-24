package ttl.larku.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class MysqlCourseDAO implements CourseDAO{

   public MysqlCourseDAO() {
      int stop = 0;
   }

   public void doit() {
      System.out.println("In Mysql OtherDAO::doit");
   }
}
