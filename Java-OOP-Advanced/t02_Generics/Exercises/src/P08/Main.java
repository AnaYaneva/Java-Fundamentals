package P08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomListImpl<String> list=new CustomListImpl();

        while(true) {
            String input = reader.readLine().trim();
            if ("END".equalsIgnoreCase(input)) break;

            String[]tokens=input.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    list.swap(Integer.valueOf(tokens[1]),Integer.valueOf(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThat(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;
                case "Sort":
                    list.customSort();
                    break;
            }

        }
    }
}
