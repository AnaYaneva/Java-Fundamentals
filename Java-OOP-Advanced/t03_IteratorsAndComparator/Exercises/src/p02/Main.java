package p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter comInterpret=new CommandInterpreter();

        while(true){
            String input=reader.readLine();
            if ("END".equalsIgnoreCase(input))break;

            comInterpret.readCommands(input);
        }
    }
}
