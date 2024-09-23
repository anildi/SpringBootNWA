package ttl.larku.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlCourseDAO implements CourseDAO{

   public MysqlCourseDAO() {
      int stop = 0;
   }

   public void doit() {
      System.out.println("In Mysql OtherDAO::doit");
   }
}
