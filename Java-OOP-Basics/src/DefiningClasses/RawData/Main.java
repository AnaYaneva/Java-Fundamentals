package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.valueOf(reader.readLine());

        List<Car> cars=new ArrayList<>();

        while(n-->0) {
            Car car=null;

            String[] tokens = reader.readLine().split("\\s+");
            String model=tokens[0];
            int speed=Integer.valueOf(tokens[1]);
            int power=Integer.valueOf(tokens[2]);
            Engine engin=new Engine(speed,power);

            int weight=Integer.valueOf(tokens[3]);
            String cargoType=tokens[4];
            Cargo cargo=new Cargo(weight,cargoType);

            List<Tire> tires=new ArrayList<>();
            for (int i = 5; i <tokens.length-1 ; i+=2) {
                Double pressure=Double.valueOf(tokens[i]);
                int age=Integer.valueOf(tokens[i+1]);
                Tire tire=new Tire(pressure,age);
                tires.add(tire);
            }
            car=new Car(model,engin,cargo,tires);
            cars.add(car);
        }

        String command = reader.readLine();
        switch (command){
            case "fragile":
                cars.stream()
                        .filter(c->c.getTires().stream()
                                .filter(t->t.getPressure()<1)
                        .collect(Collectors.toList()).size()>0)
                        .filter(c->c.getCargo().getType().equals("fragile"))
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(c->c.getEngine().getPower()>250)
                        .filter(c->c.getCargo().getType().equals("flamable"))
                        .forEach(System.out::println);
                break;
        }

    }
}
