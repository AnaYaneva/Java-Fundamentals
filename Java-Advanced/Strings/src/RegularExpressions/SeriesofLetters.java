package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class SeriesofLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input = reader.readLine();

        Pattern pattern=Pattern.compile("([a-z-A-z])\\1+");
        Matcher matcher=pattern.matcher(input);

        while (matcher.find()){
            String one="$1";
            input=matcher.replaceAll(one);
        }
        System.out.println(input);



    }
}
