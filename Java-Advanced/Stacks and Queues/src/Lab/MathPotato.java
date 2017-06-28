package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split(" ");

        int step=Integer.valueOf(scan.nextLine());

        ArrayDeque<String> queue=new ArrayDeque<>();

        for (String kid : kids) {
            queue.offer(kid);
        }

        int cycle=1;

        while(queue.size()>1){
            for (int i = 1; i <step ; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)){
                System.out.println("Prime "+queue.peek());
            }
            else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is "+queue.poll());

    }

    private static boolean isPrime(int cycle) {

        boolean isPrime=true;

        if (cycle<2){
            isPrime=false;;
        }

        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if (cycle%i==0){
                isPrime=false;;
            }

        }

        return isPrime;
    }
}
