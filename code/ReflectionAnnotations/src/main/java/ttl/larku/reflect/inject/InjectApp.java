package ttl.larku.reflect.inject;

import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;

/**
 * @author whynot
 */
public class InjectApp {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        SomeController sc = BeanFactory.getBean(SomeController.class);

        sc.doStuff();
    }
}
