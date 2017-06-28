package CarSalesman;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.valueOf(reader.readLine());

        List<Engine> engines=new ArrayList<>();

        while(n-->0) {
            Engine engine=null;
            String[] tokens = reader.readLine().split("\\s+");
            String engineModel=tokens[0];
            int power=Integer.valueOf(tokens[1]);
            switch (tokens.length){
                case 2:
                    engine=new Engine(engineModel,power);
                    break;
                case 3:
                    try{
                        int displ=Integer.valueOf(tokens[2]);
                        engine=new Engine(engineModel,power,displ);
                    }catch(NumberFormatException ex){
                        String efficiency=tokens[2];
                        engine=new Engine(engineModel,power,efficiency);
                    }
                    break;
                case 4:
                    int displ=Integer.valueOf(tokens[2]);
                    String efficiency=tokens[3];
                    engine=new Engine(engineModel,power,displ,efficiency);
                    break;
            }

            engines.add(engine);
        }

        int m=Integer.valueOf(reader.readLine());

        List<Car> cars=new ArrayList<>();

        while (m-->0){
            Car car=null;
            String[]tokens=reader.readLine().split("\\s+");
            String model=tokens[0];
            String engineModel=tokens[1];
            //Engine engine=engines.stream()
            //        .filter(e->e.getEngineModel().equals(engineModel))
            //        .limit(1)
            //        .map();
            Engine engine=null;
            for (Engine engin : engines) {
                if (engin.getEngineModel().equals(engineModel)){
                    engine=engin;
                }
            }

            switch (tokens.length){
                case 2:
                    car=new Car(model,engine);
                    break;
                case 3:
                    try{
                        int weight=Integer.valueOf(tokens[2]);
                        car=new Car(model,engine,weight);
                    }catch(NumberFormatException ex){
                        String color=tokens[2];
                        car=new Car(model,engine,color);
                    }
                    break;
                case 4:
                    int weight=Integer.valueOf(tokens[2]);
                    String color=tokens[3];
                    car=new Car(model,engine,weight,color);
                    break;
            }

            cars.add(car);
        }

        cars.stream().forEach(c->{
            System.out.println(c.getModel()+":");
            System.out.println(" "+c.getEngine().getEngineModel()+":");
            System.out.println("  Power: "+c.getEngine().getPower());
            if (c.getEngine().getDisplacements()==0) {
                System.out.println("  Displacement: n/a");
            }else{
                System.out.println("  Displacement: "+c.getEngine().getDisplacements());
            }
            System.out.println("  Efficiency: "+c.getEngine().getEfficiency());
            if (c.getWeight()==0) {
                System.out.println(" Weight: n/a");
            }else{
                System.out.println(" Weight: "+c.getWeight());
            }
            System.out.println(" Color: "+c.getColor());
        });
    }
}
