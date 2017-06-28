package ManualStringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input = reader.readLine();

        String s="*";
        StringBuilder sb =new StringBuilder(20);
        sb.append(input);
        sb.append(new String(new char[20-input.length()]).replace("\0",s));

        System.out.println(sb);
    }
}
