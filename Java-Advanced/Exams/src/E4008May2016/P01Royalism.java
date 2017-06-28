package E4008May2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Scanner;

public class P01Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String[] input = reader.readLine().split("\\s");

        List<String> royals=new ArrayList<>();
        List<String> nonRyals=new ArrayList<>();

        for (String s : input) {
            int sum=0;
            char[] ch=s.toCharArray();
            for (char c : ch) {
                sum+=(int)c;
            }
            int n=sum/26;
            sum=sum-n*26;

            if (sum==18){
                royals.add(s);
            }else{
                nonRyals.add(s);
            }
        }

        if (royals.size()>=nonRyals.size()){
            System.out.println("Royalists - "+royals.size());
            for (String royal : royals) {
                System.out.println(royal);
            }
            System.out.println("All hail Royal!");
        }else{
            for (String nonroyal : nonRyals) {
                System.out.println(nonroyal);
            }
            System.out.println("Royalism, Declined!");
        }

    }
}
