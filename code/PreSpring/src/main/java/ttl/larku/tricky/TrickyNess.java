package ttl.larku.tricky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author whynot
 */
interface Trick {
    public void doTrick();
}

@Component
//@Primary
//@Profile("prod")
@Qualifier("us-east")
class Trick1 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("Handstand");
    }
}

@Component
@Qualifier("us-west")
//@Profile("dev")
@Order(2)
class Trick2 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("CartWheel");
    }
}

@Component
@Qualifier("us-west")
//@Profile("dev")
@Order(-1)
class Trick3 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("Somersault");
    }
}

@Component
class Circus {
    //    @Autowired
    private Trick trick2;

    //    @Autowired
//    @Qualifier("us-west")
    private List<Trick> tricks;

    public Circus(@Qualifier("us-west") List<Trick> tricks, Trick trick2) {
        this.tricks = tricks;
        this.trick2 = trick2;
    }

    public void startShow() {
        tricks.forEach(Trick::doTrick);
//        trick2.doTrick();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
        context.scan("ttl.larku.tricky");
        context.refresh();

        Circus circus = context.getBean("circus", Circus.class);
        circus.startShow();
    }
}
