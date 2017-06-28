package E1022August2016;//80/100

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;
//import java.util.Scanner;

public class P01SecondNature {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputFirst = scan.nextLine().split(" ");
        String[] inputSecond = scan.nextLine().split(" ");

        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        ArrayDeque<Integer> water = new ArrayDeque<>();

        for (String in : inputFirst) {
            flowers.add(Integer.valueOf(in));
        }
        for (String in : inputSecond) {
            water.push(Integer.valueOf(in));
        }

        ArrayDeque<Integer> secondNature = new ArrayDeque<>();


        while (!flowers.isEmpty()) {
            int currentFlower = flowers.poll();
            int currentBucket = 0;

            if (!water.isEmpty()) {
                currentBucket = water.pop();
            } else {
                break;
            }

            int waterRemain = currentBucket - currentFlower;
            if (waterRemain == 0) {
                secondNature.add(currentFlower);
            } else if (waterRemain < 0) {
                flowers.addFirst(-waterRemain);
            } else if (waterRemain > 0) {
                if (water.size()>=1) {
                    water.push(waterRemain + water.pop());
                }else if (water.size()==0){
                    water.push(waterRemain);
                }
            }
        }

        if (!water.isEmpty()) {
            while (!water.isEmpty()) {
                System.out.printf("%d ", water.pop());
            }
        } else if (!flowers.isEmpty()) {
            while (!flowers.isEmpty()) {
                System.out.printf("%d ", flowers.poll());
            }
        }
        System.out.println();

        if (!secondNature.isEmpty()) {
            for (Integer integer : secondNature) {
                System.out.printf("%d ", secondNature.poll());
            }
        } else {
            System.out.println("None");
        }
    }

}

