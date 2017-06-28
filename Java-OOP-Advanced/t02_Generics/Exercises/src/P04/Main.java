package P04;

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

        String[] swaps=reader.readLine().split("\\s+");
        int swap1=Integer.valueOf(swaps[0]);
        int swap2=Integer.valueOf(swaps[1]);
        Box.swap(boxes, swap1, swap2);

        for (Box box : boxes) {
            System.out.println(box);
        }

    }
}
