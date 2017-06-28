package ExercisesSetsAndMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/*You are given a sequence of strings, each on a new line.
 Every odd line on the console is representing a resource
 (e.g. Gold, Silver, Copper, and so on) ,
  and every even – quantity. Your task is to collect the resources and
  print them each on a new line.
Print the resources and their quantities in format:
{resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000]*/

public class AMinersTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        LinkedHashMap<String, Integer> resources=new LinkedHashMap<>();

        while(!"stop".equals(input)) {
            int quantity = Integer.valueOf(scan.nextLine());

            if (!resources.containsKey(input)) {
                resources.put(input, quantity);
            }else{
                resources.put(input,resources.get(input)+quantity);
            }
            input = scan.nextLine();
        }

        for (String key : resources.keySet()) {
            System.out.printf("%s -> %d%n",key,resources.get(key));
        }
    }
}
