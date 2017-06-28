package E3013June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
//import java.util.Scanner;

public class P04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        int n=Integer.valueOf(reader.readLine());

       //StringBuilder sb=new StringBuilder();

       //for (int i = 0; i < n; i++) {
       //    sb.append(reader.readLine().trim());
       //}

        TreeMap<String,List<String>> methods=new TreeMap<>();

        String regex = "\\.*([A-Z][\\w]*)\\([\\w\\[\\]\\<>, ]*";
        Pattern pattern = Pattern.compile(regex);
        String method = "";
        //String string = sb.toString();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);


            if (input.trim().startsWith("static")) {
                if (matcher.find()) {
                    method = matcher.group(1);
                    methods.put(method, new ArrayList<>());
                }
            }

            while (matcher.find()) {
                methods.get(method).add(matcher.group(1));
            }
        }
        //System.out.println(methods);

        methods.entrySet().stream()
                .sorted((x,y)->Integer.compare(y.getValue().size(),x.getValue().size()))
                .forEach(m->{
                    if (m.getValue().isEmpty()){
                        System.out.println(m.getKey()+" -> None");
                    }else{
                        System.out.printf("%s -> %d -> %s%n",
                                m.getKey(),
                                m.getValue().size(),
                                String.join(", ",m.getValue()
                                .stream()
                                .sorted(String::compareTo)
                                .collect(Collectors.toList())));
                    }
                });
    }
}
