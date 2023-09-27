package ttl.larku.reflect.inject;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class BeanFactoryComplex {
    /**
     * Create an instance of the given type and do dependency injection
     * on it.  In this case, we also recurse check and maybe do
     * depencency injection on the newly created object(s).
     *
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> T getBean(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T result = clazz.getConstructor().newInstance();

        doInjection(result);

        return result;
    }

    static final private Class<? extends Annotation> myInject = MyInject.class;

    public static void doInjection(Object target) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = target.getClass();

        Field[] fields = clazz.getDeclaredFields();

        //Look for our @MyInject annotation on all declared fields.
        for (Field field : fields) {
            if (field.isAnnotationPresent(myInject)) {
                //Get the class
                Class<?> targetType = field.getType();
                //If it is an interface, get an implementing
                //class.
                if (targetType.isInterface()) {
                    targetType = findSingleImplementation(field);
                }
                //Create the new instance
                Object newInstance = targetType.getConstructor().newInstance();

                //and now do the actual "injection"
                field.setAccessible(true);
                field.set(target, newInstance);

                //Now look through your new created object and
                //possibly do injection on it.
                //This needs severe testing.
                doInjection(newInstance);
            }
        }
    }

    /**
     * Find a single implementation for a given interface.
     * We are using the fabulous Reflections library for this.
     * For now, if we find multiple implementations, we return
     * the *last* one we find.
     *
     * https://github.com/ronmamo/reflections
     *
     * @param field the interface field we want to find an implementation
     *              for.
     * @return
     */
    public static Class<?> findSingleImplementation(Field field) {
        Class<?> result = null;
        Class<?> inputClass = field.getType();
        if(inputClass.isInterface()) {

            //Search in the top package.
            Reflections reflections = new Reflections("ttl.larku");

            Set<Class<?>> subTypes =
                    reflections.get(SubTypes.of(inputClass).asClass());

            //Get the generic field Type.
            Type fieldGenericType = field.getGenericType();
            var tc = fieldGenericType.getClass();

            for (Class<?> cls : subTypes) {
                //The types of Interfaces implemented by the class
                Type[] types = cls.getGenericInterfaces();
                //System.out.println("cls: " + cls + ", type: ");
                for (Type type : types) {
//                System.out.println("type: " + type);
                    if (type.equals(fieldGenericType)) {
                        result = cls;
                        System.out.println("Found it!!!: cls: " + cls + ", type: " + type);
                    }
                }
            }
        }

        return result;
    }
}
