package Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) {
       Class c = Person.class;

       Method[] methods = c.getMethods();
//        for (Method m : methods) {
//            System.out.println(m.getName() + ", " +
//            m.getReturnType() + ", " + Arrays.toString(m.getParameterTypes()));
//        }

        Field[] fields = c.getDeclaredFields();
//        for (Field f : fields) {
//            System.out.println(f.getName() + ", " +
//                    f.getType());
//        }

        Annotation[] annotations = c.getAnnotations();
        for (Annotation a : annotations) {
           if (a instanceof Author)
               System.out.println("Yes");
        }
    }
}
