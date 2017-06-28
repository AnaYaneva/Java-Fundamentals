package E1022August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class P04AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input = reader.readLine();

        String regex = "Grow\\s<([A-Z][a-z]+)>\\s<([A-Za-z0-9]+)>\\s([0-9]+)";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        HashMap<String,HashMap<String,Long>> rosesByRegion=new HashMap<>();

        while(!"Icarus, Ignite!".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            fillHashMap(rosesByRegion, matcher);

            input = reader.readLine();

            //for (String region:rosesByRegion.keySet()) {
            //    System.out.println(region);
            //    for (String color:rosesByRegion.get(region).keySet())
            //        System.out.println("*--" + color + " " + rosesByRegion.get(region).get(color));
            //}
            //System.out.println("------------------------");

        }


        rosesByRegion.entrySet().stream()
                .sorted((r1,r2)->{
                    long sum1=r1.getValue().values().stream().mapToLong(e->e).sum();
                    long sum2=r2.getValue().values().stream().mapToLong(e->e).sum();
                    if (sum1==sum2){
                        return r1.getKey().compareTo(r2.getKey());
                    }
                    return Long.compare(sum2,sum1);
                }).forEach(r->{
                                 System.out.println(r.getKey());
                                 r.getValue().entrySet().stream().sorted((c1,c2)->{
                                     if (Long.compare(c1.getValue(),c2.getValue())==0){
                                         return c1.getKey().compareTo(c2.getKey());
                                     }
                                     return Long.compare(c1.getValue(),c2.getValue());
                                         }).forEach(c->{
                                     System.out.println("*--"+c.getKey()+" | "+c.getValue());
                                 });
                             });

    }

    private static void fillHashMap(HashMap<String, HashMap<String, Long>> rosesByRegion, Matcher matcher) {
        if (matcher.find()) {
            String region=matcher.group(1);
            String color=matcher.group(2);
            long amount=Long.valueOf(matcher.group(3));

            if (!rosesByRegion.containsKey(region)) {
                rosesByRegion.put(region, new HashMap<>());
                rosesByRegion.get(region).put(color,amount);
            }else{
                if (!rosesByRegion.get(region).containsKey(color)){
                    rosesByRegion.get(region).put(color,amount);
                }else{
                    rosesByRegion.get(region).put(color,rosesByRegion.get(region).get(color)+amount);
                    rosesByRegion.put(region, rosesByRegion.get(region));
                    //rosesByRegion.get(region).put(color,rosesByRegion.get(region).get(color)+amount);
                }
            }
        }
    }
}
