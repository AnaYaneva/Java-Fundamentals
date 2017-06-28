package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input = reader.readLine();
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        while (!input.equals("end")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(matcher.group(0));
            }

            input = reader.readLine();
        }
    }
}
