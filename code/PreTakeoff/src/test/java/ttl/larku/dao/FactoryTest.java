package ttl.larku.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class FactoryTest {

   @Test
   public void testThatOnlyOneInstanceOfAnObjectIsCreated() {

      StudentDAO dao1 = DaoFactory.studentDAO();
      StudentDAO dao2 = DaoFactory.studentDAO();

      assertSame(dao1, dao2);
   }
}
