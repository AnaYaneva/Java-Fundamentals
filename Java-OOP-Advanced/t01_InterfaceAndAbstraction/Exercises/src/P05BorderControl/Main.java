package P05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Checkable> unitsForCheck=new ArrayList<>();

        while(true) {
            String input = reader.readLine();

            if ("End".equalsIgnoreCase(input)){
                break;
            }

            String[] tokens=input.trim().split("\\s+");
            Checkable unit;
            switch (tokens.length){
                case 2:
                    unit=new Robot(tokens[0],tokens[1]);
                    unitsForCheck.add(unit);
                    break;
                case 3:
                    unit=new Citizen(tokens[0],
                            Integer.valueOf(tokens[1]), tokens[2]);
                    unitsForCheck.add(unit);
                    break;
            }
        }

        String unvalid=reader.readLine();

        for (Checkable checkable : unitsForCheck) {
            if (checkable.getID().endsWith(unvalid)){
                System.out.println(checkable);
            }
        }
    }
}
