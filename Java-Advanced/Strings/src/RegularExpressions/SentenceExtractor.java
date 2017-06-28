package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input = reader.readLine();
        String text = reader.readLine();

        String regex = "(?<= |^)[A-Z]+[\\w\\s]+\\s"+input+"\\s*[\\w\\s]*([\\.\\!\\?])";


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(0));

        }
    }
}
