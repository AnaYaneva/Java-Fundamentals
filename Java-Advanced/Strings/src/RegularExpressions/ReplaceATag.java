package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Scanner;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String string = reader.readLine();
        StringBuilder sb = new StringBuilder();

        String regex = "(.*)<a\\s+(href=[^>]+)>([^<]+)<\\/a>([^\\d]*)";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        while (!string.equals("END")) {
            sb.append(string).append("\r\n");
            string = reader.readLine();
        }

        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            String link = matcher.group(2);
            String title = matcher.group(3);
            String output=String.format("%s[URL %s]%s[/URL]%s",matcher.group(1),link,title,matcher.group(4));
            System.out.println(output);

        }
    }
}
