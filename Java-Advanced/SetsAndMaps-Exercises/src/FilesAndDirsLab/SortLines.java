package FilesAndDirsLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3. Line numbers start from one.

public class SortLines {
    public static void main(String[] args) {
        Path path= Paths.get("D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt");
        Path output=Paths.get("D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt");

        try{
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);

            Files.write(output,lines);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
