package E5023April2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class P01MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        StringBuilder string = new StringBuilder(reader.readLine());
        StringBuilder pattern =  new StringBuilder(reader.readLine());

        int startIndex=string.indexOf(pattern.toString());
        int lastIndex=string.lastIndexOf(pattern.toString());

       if (string.equals("")||pattern.equals("")){
           System.out.println("No shake.");
           System.out.println(string);
       }else {
            while (startIndex != lastIndex||pattern.length()>1) {
                System.out.println("Shaked it.");

                string.replace(lastIndex, lastIndex + pattern.length(), "");
                string.replace(startIndex, startIndex + pattern.length(), "");

                //System.out.println(string);
                int index = pattern.length() / 2;
                //System.out.println(index);
                if (pattern.length()==1){
                    break;
                }else {
                    pattern.replace(index, index + 1, "");
                }
                //System.out.println(pattern);
                startIndex = string.indexOf(pattern.toString());
                lastIndex = string.lastIndexOf(pattern.toString());
            }

            System.out.println("No shake.");
            System.out.println(string);
       }

    }
}
