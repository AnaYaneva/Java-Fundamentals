package p03;

import p01.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter comInt=new CommandInterpreter();

        while(true){
            String input=reader.readLine();

            if ("END".equalsIgnoreCase(input)){
                comInt.getStack().forEach(System.out::println);
                comInt.getStack().forEach(System.out::println);
                break;
            }

            comInt.commandReader(input);

        }
    }
}
