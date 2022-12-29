package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat("MyCat");
        // Filter methods having MyAnnotation and execute them
        for (Method mtd : cat.getClass().getDeclaredMethods()) {
            if (mtd.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = mtd.getAnnotation(MyAnnotation.class);
                for (int i = 0; i < annotation.times(); i++) {
                    mtd.invoke(cat);
                }
            }
        }

        // Filter fields having StringAnnotation and execute them
        for (Field field: cat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(StringAnnotation.class)) {
                Object object = field.get(cat);
                if (object instanceof String) {
                    String stringValue = (String) object;
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
