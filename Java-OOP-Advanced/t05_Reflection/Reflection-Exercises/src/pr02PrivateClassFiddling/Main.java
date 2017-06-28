package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        Class blBox= BlackBoxInt.class;

        Constructor ctor=blBox.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt bbi= (BlackBoxInt) ctor.newInstance();

        while(true){
            String[]input=scan.readLine().split("_");
            if (input[0].equalsIgnoreCase("end")) break;

            Method method=blBox.getDeclaredMethod(input[0],int.class);
            method.setAccessible(true);
            method.invoke(bbi, Integer.valueOf(input[1]));

            Field field=blBox.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(bbi));
        }
	}
}
