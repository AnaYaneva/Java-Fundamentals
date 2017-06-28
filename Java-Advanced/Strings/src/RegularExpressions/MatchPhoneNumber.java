package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String string = reader.readLine();

        String regex = "^\\+359( |-)2\\1[0-9]{3}\\1[0-9]{4}$";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        while(!string.equals("end")) {
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }
            string = reader.readLine();
        }
    }
}
