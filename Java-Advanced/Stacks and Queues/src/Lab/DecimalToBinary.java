package Lab;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal=Integer.valueOf(scan.nextLine());

        ArrayDeque<Integer> bin=new ArrayDeque<>();

        if (decimal==0){

             bin.push(0);
        }

        while(decimal!=0){
            bin.push(decimal%2);
            decimal/=2;
        }

        while(!bin.isEmpty()){
            System.out.print(bin.pop());
        }


    }
}
