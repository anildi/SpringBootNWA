package ttl.larku.app.tricky;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

interface Trick {
   public void doTrick();
}

@Component
//@Primary
//@Profile("dev")
@Qualifier("easy")
class Trick1 implements Trick {
   @Override
   public void doTrick() {
      System.out.println("Handstand");
   }
}

@Component
@Qualifier("difficult")
//@Profile("prod")
class Trick2 implements Trick {
   @Override
   public void doTrick() {
      System.out.println("Somersault");
   }
}

@Component
@Qualifier("difficult")
//@Profile("prod")
class Trick3 implements Trick {
   @Override
   public void doTrick() {
      System.out.println("Cartwheel");
   }
}

@Component
class Circus
{
   @Autowired
//   @Qualifier("trick2")
   //private Trick trick;
   @Qualifier("easy")
   private List<Trick> easyTricks;

   @Autowired
   @Qualifier("difficult")
   private List<Trick> hardTricks;

   public void startShow() {
      //trick.doTrick();
      easyTricks.forEach(Trick::doTrick);
      hardTricks.forEach(Trick::doTrick);
   }

   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
      context.getEnvironment().setActiveProfiles("prod");
      context.scan("ttl.larku.app.tricky");
      context.refresh();

      Circus circus = context.getBean("circus", Circus.class);
      circus.startShow();
   }
}
