package P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(reader.readLine());

        List<Box> boxes= new ArrayList<>();

        while(n-->0){
            Box<Integer> box=new Box<>(Integer.valueOf(reader.readLine()));
            boxes.add(box);
        }

        for (Box box : boxes) {
            System.out.println(box);
        }

    }
}
