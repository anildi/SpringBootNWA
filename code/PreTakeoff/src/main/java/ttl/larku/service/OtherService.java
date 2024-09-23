package ttl.larku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttl.larku.dao.CourseDAO;


@Service
public class OtherService {

   @Autowired
   private CourseDAO otherDAO;

   public OtherService() {
      int stop = 0;
   }

   public void doit() {
      otherDAO.doit();
   }


}
