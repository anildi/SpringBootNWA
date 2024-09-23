package ttl.larku.dao;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import ttl.larku.domain.Student;

public class DaoFactory {

   private static Map<String, Object> objects = new ConcurrentHashMap<>();
   private static String profile;

   static {
      ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
      profile = bundle.getString("larku.profile.active");
   }

//   public static StudentDAO oldBadStudentDAO() {
//
//      switch(profile) {
//         case "dev": {
//            return new InMemoryStudentDAO();
//         }
//         case "prod":
//            return new MysqlStudentDAO();
//         default:
//            throw new IllegalArgumentException("Unknown profile: " + profile);
//      }
//   }

   public static StudentDAO studentDAO() {

      StudentDAO result = switch(profile) {
         case "dev" -> {
            StudentDAO dao = (StudentDAO)objects.computeIfAbsent("studentDAO",
                  k -> new InMemoryStudentDAO());

//            StudentDAO dao = (StudentDAO) objects.get("studentDAO");
//            if(dao == null) {
//               dao = new InMemoryStudentDAO();
//               objects.put("studentDAO", dao);
//            }
            yield dao;
         }
         case "prod" -> {
            StudentDAO dao = (StudentDAO)objects.computeIfAbsent("studentDAO",
                  k -> new MysqlStudentDAO());

//            StudentDAO dao = (StudentDAO) objects.get("studentDAO");
//            if(dao == null) {
//               dao = new MysqlStudentDAO();
//               objects.put("studentDAO", dao);
//            }
            yield dao;
         }
         default -> throw new IllegalArgumentException("Unknown profile: " + profile);
      };

      return result;
   }
}
