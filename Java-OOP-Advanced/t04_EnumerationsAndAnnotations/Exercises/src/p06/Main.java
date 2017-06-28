package p06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String info=reader.readLine();

        Class<CardRank> rank=CardRank.class;
        Class<CardSuit> suit=CardSuit.class;

        Enum enumRank=rank.getAnnotation(Enum.class);
        Enum enumSuit=suit.getAnnotation(Enum.class);
        String type="";
        String descr="";

     if (enumRank.category().equalsIgnoreCase(info)){
         type=enumRank.type();
         descr=enumRank.description();
     }else if (enumSuit.category().equalsIgnoreCase(info)){
         type=enumSuit.type();
         descr=enumSuit.description();
     }

        System.out.println(String.format("Type = %s, Description = %s",
               type,descr));
    }
}
