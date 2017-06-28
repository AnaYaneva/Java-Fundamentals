package p09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String [] lights=reader.readLine().split("\\s+");
        TrafficLight[] trafficLights=new TrafficLight[lights.length];

        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i]=new TrafficLight(Signals.valueOf(lights[i]));
        }

        int lines=Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                trafficLights[j].update();
                System.out.print(trafficLights[j]+" ");
            }
            System.out.println();
        }
    }
}
