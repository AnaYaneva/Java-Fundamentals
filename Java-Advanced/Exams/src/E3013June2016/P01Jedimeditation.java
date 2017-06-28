package E3013June2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
//import java.util.Scanner;

public class P01Jedimeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(reader.readLine());

        StringBuilder out = new StringBuilder();
        ArrayDeque<String> queueIn = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Collections.addAll(queueIn, input);
        }

        ArrayDeque<String> toshkoSlav = new ArrayDeque<>();
        ArrayDeque<String> masters = new ArrayDeque<>();
        ArrayDeque<String> knights = new ArrayDeque<>();
        ArrayDeque<String> padawan = new ArrayDeque<>();
        ArrayDeque<String> yoda = new ArrayDeque<>();

        while (!queueIn.isEmpty()) {
            String next = queueIn.poll();
            switch (next.charAt(0)) {
                case 'm':
                    if (!masters.contains(next)) {
                        masters.add(next);
                    }
                    break;
                case 'k':
                    if (!knights.contains(next)) {
                        knights.add(next);
                    }
                    break;
                case 'p':
                    if (!padawan.contains(next)) {
                        padawan.add(next);
                    }
                    break;
                case 't':
                case 's':
                    if (!toshkoSlav.contains(next)) {
                        toshkoSlav.add(next);
                    }
                    break;
                case 'y':
                    if (!yoda.contains(next)) {
                        yoda.add(next);
                        while (!toshkoSlav.isEmpty()) {
                            padawan.addFirst(toshkoSlav.pollLast());
                        }
                    }
                    break;
            }
        }

        if (!toshkoSlav.isEmpty()) {
            out.append(String.join(" ", toshkoSlav));
            out.append(" ");
        }
        out.append(String.join(" ", masters));
        out.append(" ");
        out.append(String.join(" ", knights));
        out.append(" ");
        out.append(String.join(" ", padawan));

        System.out.println(out);

        //queueIn.addAll(toshkoSlav);
        //queueIn.addAll(masters);
        //queueIn.addAll(knights);
        //queueIn.addAll(padawan);
        //
        //while (!queueIn.isEmpty()) {
        //    System.out.print(queueIn.poll() + " ");
        //}
    }

}
