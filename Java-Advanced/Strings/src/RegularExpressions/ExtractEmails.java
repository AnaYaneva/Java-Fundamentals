package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String string = reader.readLine();

        String regex = "(?<=\\s|^)([a-z0-9]+)([\\.\\-_]{0,1})([a-z0-9]*)@[a-z]+[\\.\\-]*[a-z]*(\\.[a-z]{2,})+(?=[\\s\\.,$])";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        while(!string.equals("end")) {
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                System.out.println(matcher.group(0));
            }

            string = reader.readLine();
        }
    }
}
