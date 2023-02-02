package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainImpl {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        CatUsingMyAnnotation catUsingMyAnnotation = new CatUsingMyAnnotation("MyCat");
        // Filter methods having MyAnnotation and execute them
        for (Method mtd : catUsingMyAnnotation.getClass().getDeclaredMethods()) {
            if (mtd.isAnnotationPresent(ClassAnnotation.class)) {
                ClassAnnotation annotation = mtd.getAnnotation(ClassAnnotation.class);
                for (int i = 0; i < annotation.times(); i++) {
                    mtd.invoke(catUsingMyAnnotation);
                }
            }
        }

        // Filter fields having StringAnnotation and execute them
        for (Field field: catUsingMyAnnotation.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MethodAnnotation.class)) {
                Object object = field.get(catUsingMyAnnotation);
                if (object instanceof String) {
                    String stringValue = (String) object;
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
