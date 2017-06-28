package P06BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthdayable> unitsForCheck=new ArrayList<>();

        while(true) {
            String input = reader.readLine();

            if ("End".equalsIgnoreCase(input)){
                break;
            }

            String[] tokens=input.trim().split("\\s+");
            Birthdayable unit;
            switch (tokens[0]){
                case "Citizen":
                    unit=new Citizen(tokens[1],
                            Integer.valueOf(tokens[2]), tokens[3], tokens[4]);
                    unitsForCheck.add(unit);
                    break;
                case "Pet":
                    unit=new Pet(tokens[1], tokens[2]);
                    unitsForCheck.add(unit);
                    break;
            }
        }

        String date=reader.readLine();

        for (Birthdayable birthable : unitsForCheck) {
            if (birthable.getBday().endsWith(date)){
                System.out.println(birthable);
            }
        }
    }
}
