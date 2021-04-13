import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 */
public class DeepCopy {
    private static Object Man;

    public static void main(String[] args) {

        CopyObj copyObj = new CopyObj();
        copyObj.cloneObject(Man);
    }

    static class CopyObj {
        public static Object cloneObject(Object obj) {
            try {
                Object clone = obj.getClass();
                for (Field field : obj.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.get(obj) == null || Modifier.isFinal(field.getModifiers())) {
                        continue;
                    }
                    if (field.getType().isPrimitive() || field.getType().equals(String.class)
                            || field.getType().getSuperclass().equals(Number.class)
                            || field.getType().equals(Boolean.class)) {
                        field.set(clone, field.get(obj));
                    } else {
                        Object childObj = field.get(obj);
                        if (childObj == obj) {
                            field.set(clone, clone);
                        } else {
                            field.set(clone, cloneObject(field.get(obj)));
                        }
                    }
                }
                return clone;
            } catch (Exception e) {
                return null;
            }
        }

    }
}
