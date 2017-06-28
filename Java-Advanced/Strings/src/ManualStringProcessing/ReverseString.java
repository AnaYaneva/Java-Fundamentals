package ManualStringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String input=reader.readLine();

        StringBuilder sb = new StringBuilder(input);
        System.out.println(sb.reverse());


    }
}
