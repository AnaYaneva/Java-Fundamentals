package E0019Feb2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class P03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        String line=reader.readLine();
        Pattern pat = Pattern.compile("(_|,)([a-zA-z]+)([0-9])");


        //String message="";

        while (!"Ascend".equals(line)) {
            input.append("\n");
            input.append(line);
            line=reader.readLine();
        }

            Matcher matcher = pat.matcher(input);

            while (matcher.find()) {

                HashMap<String,String> decoded=new HashMap<>();
                String coded=matcher.group(2);;
                String encoded="";
                String text=matcher.group(0);

                if (decoded.containsKey(coded)){
                    coded=decoded.get(coded);
                }

                int start=input.indexOf(matcher.group(0));
                int end=input.indexOf(matcher.group(0))+text.length()-1;

                int sign=1;
                int digit=Integer.valueOf(matcher.group(3));
                if (matcher.group(1).equals("_")){
                    sign=-1;
                }

                for (char c : coded.toCharArray()) {
                    int charAscii= ((int)c);
                    char ch=(char)(charAscii+sign*digit);
                    encoded+=ch;
                }

                decoded.put(coded, encoded);

                input.replace(start,end+1,decoded.get(coded));
                matcher = pat.matcher(input);
            }


            System.out.println(input);

        }

    }

