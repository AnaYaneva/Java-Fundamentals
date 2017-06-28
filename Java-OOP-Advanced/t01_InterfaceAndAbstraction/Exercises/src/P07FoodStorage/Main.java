package P07FoodStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputs = Integer.valueOf(reader.readLine());

        Map<String,Buyer> buyers=new HashMap<>();

        while(inputs-->0) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            Buyer unit;
            switch (tokens.length) {
                case 4:
                    unit = new Citizen(tokens[0],
                            Integer.valueOf(tokens[1]), tokens[2], tokens[3]);
                    buyers.putIfAbsent(tokens[0], unit);
                    break;
                case 3:
                    unit = new Rebel(tokens[0],
                            Integer.valueOf(tokens[1]), tokens[2]);
                    buyers.putIfAbsent(tokens[0], unit);
                    break;
            }
        }
        int food=0;
        while(true){
            String input=reader.readLine();

            if ("End".equalsIgnoreCase(input)){
                break;
            }

            if (buyers.containsKey(input)) {
                food += buyers.get(input).BuyFood();
            }
        }

        System.out.println(food);
    }
}
