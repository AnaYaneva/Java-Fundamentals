package E1022August2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class P03NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String input = reader.readLine();

        while (!input.equals("---NMS SEND---")){
            sb.append(input);

            input = reader.readLine();
        }


        List<String> words=new ArrayList<>();

        StringBuilder tmp=new StringBuilder();

        sb.toString().replace("\\s+","");
        String rem=sb.toString().toLowerCase();

        tmp.append(sb.charAt(0));
        for (int i = 1; i < rem.length(); i++) {
            tmp.append(sb.charAt(i));
          if (Character.compare(rem.charAt(i-1),rem.charAt(i))>0) {
              tmp.delete(tmp.length()-1,tmp.length());
              words.add(tmp.toString());
              tmp.delete(0,tmp.length());
              tmp.append(sb.charAt(i));
          }else{
              //tmp.append(sb.charAt(i));
          }
          if (i==rem.length()-1){
              //tmp.append(sb.charAt(i));
              words.add(tmp.toString());
              tmp.delete(0,tmp.length()-1);
          }
        }

        String delimiter = reader.readLine();

        //for (String word : words) {
        //    System.out.print(word+delimiter);
        //}
        //System.out.println();
       System.out.println(String.join(delimiter,words));


    }
}
