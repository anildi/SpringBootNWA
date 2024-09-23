package ttl.larku.jconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import ttl.larku.dao.InMemoryStudentDAO;
import ttl.larku.dao.StudentDAO;
import ttl.larku.service.StudentService;

@Configuration
//@ComponentScan({"ttl.larku.service", "ttl.larku.dao"})
@ComponentScan({"ttl.larku"})
public class LarkUConfig {
   /*
     <bean id="inMemoryStudentDAO" class="ttl.larku.dao.InMemoryStudentDAO"/>
     */

   @Bean
   public StudentDAO studentDAO() {
      var dao = new InMemoryStudentDAO();
      return dao;
   }

   /*
    <bean id="studentService" class="ttl.larku.service.StudentService" >
        <property name="studentDAO" ref="inMemoryStudentDAO"/>
    </bean>

    */

   @Bean
   public StudentService studentService() {
      StudentService ss = new StudentService();

      var dao = studentDAO();
      ss.setStudentDAO(dao);

      return ss;
   }
}
