package EC2031May2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//class Athlete {
//    private String name;
//    private String country;
//    private Integer wins;
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public Integer getWins() {
//        return wins;
//    }
//
//    public Athlete(String name,
//                   String country,
//                   Integer wins) {
//        this.name = name;
//        this.country = country;
//        this.wins = wins;
//    }
//}

//public class P04 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        //Scanner scan = new Scanner(System.in);
//
//        Map<Athlete,Integer> olimpics=new HashMap<>();
//
//        String input = reader.readLine().replace("\\s+"," ");
//        while (!input.equals("report")){
//            String[] data=input.split("|");
//            String name=data[0].trim();
//            String country=data[1].trim();
//            int wins=1;
//
//            Map<String,Integer>athlete= new HashMap<>();
//
//            if (!olimpics.containsKey(country)) {
//                olimpics.put(country,athlete);
//            }
//
//            if (!athlete.containsKey(name)) {
//                athlete.put(name, 1);
//            }else{
//                athlete.put(name, athlete.get(name)+1);
//            }
//
//            olimpics.put(country,athlete);
//
//
//            input = reader.readLine();
//        }
//
//        olimpics.entrySet().stream()
//                .sorted(Map.Entry.
//
//                .forEach();
//        System.out.println(olimpics);
//    }
//}
public class P04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);

        Map<String,Map<String ,Integer>> olimpics=new LinkedHashMap<>();

        String input = reader.readLine().replaceAll("\\s+"," ");

        while (!input.equals("report")){
            String[] data=input.split("\\|");
            String name=data[0].replaceAll("\\s+"," ").trim();
            String country=data[1].replaceAll("\\s+"," ").trim();

            if (!olimpics.containsKey(country)) {
                olimpics.put(country,new HashMap<>());
                olimpics.get(country).put(name, 1);
            }else{
                if (!olimpics.get(country).containsKey(name)) {
                    olimpics.get(country).put(name, 1);
                }else{
                    olimpics.get(country).put(name, olimpics.get(country).get(name)+1);
                }
            }




            input = reader.readLine();
        }

       olimpics.entrySet().stream()
                        .sorted((r1,r2)-> {
                            int sum1 = r1.getValue().values().stream().mapToInt(e -> e).sum();
                            int sum2 = r2.getValue().values().stream().mapToInt(e -> e).sum();
                            if (sum1 != sum2) {
                                return Integer.compare(sum2, sum1);
                            }
                            return Integer.compare(sum1, sum2)  ;
                        }).forEach(c->
               System.out.println(c.getKey()+" ("+c.getValue().size()+" participants): "+c.getValue().values().stream().mapToInt(e -> e).sum()+" wins")
       );

    }
}
