package E0019Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.Scanner;

public class P04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        //String input = reader.readLine();

        LinkedHashMap<String, Map<String, Integer>> players = new LinkedHashMap<>();

        String input = reader.readLine().replaceAll("<->", " ");

        while (!input.equals("osu!")) {
            String[] data = input.split("\\s+");

            String p1 = data[1].trim();
            int points1 = Integer.valueOf(data[0]);

            String p2 = data[2].trim();
            int points2 = Integer.valueOf(data[3]);

            int diff = -(points2 - points1);

            if (!players.containsKey(p1)) {
                players.put(p1, new HashMap<>());
                players.get(p1).put(p2, diff);
            } else {
                if (!players.get(p1).containsKey(p2)) {
                    players.get(p1).put(p2, diff);
                } else {
                    players.get(p1).put(p2, players.get(p1).get(p2) + diff);
                }
            }
            //.................
            if (!players.containsKey(p2)) {
                players.put(p2, new HashMap<>());
                players.get(p2).put(p1, -diff);
            } else {
                if (!players.get(p2).containsKey(p1)) {
                    players.get(p2).put(p1, -diff);
                } else {
                    players.get(p2).put(p1, players.get(p2).get(p1) -diff);
                }
            }

            input = reader.readLine().replaceAll("<->", " ");

        }

        players.entrySet().stream()
                .sorted((p1,p2)-> {
                    int sum1 = p1.getValue().values().stream().mapToInt(e -> e).sum();
                    int sum2 = p2.getValue().values().stream().mapToInt(e -> e).sum();
                    if (sum1 != sum2) {
                        return Integer.compare(sum2, sum1);
                    }
                    return Integer.compare(sum1, sum2)  ;
                }).forEach(c-> {
            System.out.println(c.getKey() + " - (" + c.getValue().values().stream().mapToInt(e -> e).sum()
                    + ")");
            c.getValue().entrySet().stream()
                    .forEach(cv -> {
                        System.out.println("*   " + cv.getKey() + " <-> " + cv.getValue());
                    });
        });

    }
}






