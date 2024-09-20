package ttl.larku.dao;

import java.util.ResourceBundle;

public class DaoFactory {

   public static StudentDAO studentDAO() {
      ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
      String profile = bundle.getString("larku.profile.active");
      switch(profile) {
         case "dev":
            return new InMemoryStudentDAO();
         case "prod":
            return new MysqlStudentDAO();
         default:
            throw new IllegalArgumentException("Unknown profile: " + profile);
      }
   }
}
