package P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().trim().split("\\s+");
        Tuple<String,String> one = new Tuple(tokens[0]+" "+tokens[1],tokens[2]);
        System.out.println(one);

        tokens = reader.readLine().trim().split("\\s+");
        Tuple<String, Integer> two = new Tuple(tokens[0],Integer.valueOf(tokens[1]));
        System.out.println(two);

        tokens = reader.readLine().trim().split("\\s+");
        Tuple<Integer, Double> three = new Tuple(Integer.valueOf(tokens[0]),Double.valueOf(tokens[1]));
        System.out.println(three);
    }
}
