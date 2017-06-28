package E0019Feb2017;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//import java.util.Scanner;

public class P02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(reader.readLine());

        if (n==0){
            System.out.println(0);
            //System.out.println(0);
            return;
        }

        String line=reader.readLine().trim();


        Deque<Deque<Integer>> waves=new ArrayDeque<>();

        List<Integer> seismicities=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (line.length()>0) {
            String[] ints=line.split("\\s+");
            Deque<Integer> wave=new ArrayDeque<>();
                for (String s : ints) {
                    wave.add(Integer.valueOf(s));
                }
                waves.add(wave);
            }
            line=reader.readLine().trim();
        }

        while (!waves.isEmpty()) {
            Deque<Integer> wave = waves.peek();
            int seism = wave.poll();
            seismicities.add(seism);

            boolean isWaveGreater = false;
            if (wave.isEmpty()) {
                waves.poll();
            } else {
                while (!isWaveGreater) {
                    if (wave.isEmpty()) {
                        waves.poll();
                        break;
                    }else {
                        if (seism < wave.peek()) {
                            //wave.poll();
                            waves.add(waves.poll());

                            isWaveGreater = true;
                        } else {
                            wave.poll();
                        }
                    }
                }
            }
        }


        System.out.println(seismicities.size());
        for (Integer seismicity : seismicities) {
            System.out.print(seismicity+" ");
        }
    }
}
