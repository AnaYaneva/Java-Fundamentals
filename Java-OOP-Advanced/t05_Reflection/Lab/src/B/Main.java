import sun.plugin.javascript.navig.Array;

import java.lang.reflect.Method;
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

        for (Method getter : getters) {
            System.out.println(String.format("%s will return %s",
                    getter.getName(), getter.getReturnType()));
        }

        for (Method setter : setters) {
            System.out.println(String.format("%s and will set field of %s",
                   setter.getName(), setter.getParameterTypes()[0]));
        }
    }
}
