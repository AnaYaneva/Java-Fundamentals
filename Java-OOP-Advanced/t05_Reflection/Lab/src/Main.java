import sun.plugin.javascript.navig.Array;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class aclass=Reflection.class;
        //System.out.println(aclass);
//
        //System.out.println(aclass.getSuperclass());
//
        //Class[]interf=aclass.getInterfaces();
        //for (Class aClass : interf) {
        //    System.out.println(aClass);
        //}
//
        //Reflection ref= (Reflection) aclass.newInstance();
        //System.out.println(ref);

        Field[] fields=aclass.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));

        Method[] methods=aclass.getDeclaredMethods();

        List<Method> getters=new ArrayList<>();
        List<Method> setters=new ArrayList<>();
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get")){
                getters.add(method);
            }
            else if (method.getName().startsWith("set")){
                setters.add(method);
            }
        }

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())){
                System.out.println(String.format("%s must be private!",
                        field.getName()));
            }
        }

        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())){
                System.out.println(String.format("%s have to be public!",
                        getter.getName()));
            }
        }

        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())){
                System.out.println(String.format("%s have to be private!",
                        setter.getName()));
            }
        }
        //for (Method getter : getters) {
        //    System.out.println(String.format("%s will return %s",
        //            getter.getName(), getter.getReturnType()));
        //}
//
        //for (Method setter : setters) {
        //    System.out.println(String.format("%s and will set field of %s",
        //           setter.getName(), setter.getParameterTypes()[0]));
        //}


    }
}
