package FilesAndDirsLab;

import java.io.*;
import java.util.Scanner;

//Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file. A valid integer is surrounded with white spaces.

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (Scanner scan = new Scanner(new FileInputStream(inputPath));
            PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){
                while(scan.hasNext()){
                    if (scan.hasNextInt()){
                        out.println(scan.nextInt());
                    }
                    scan.next();
                }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
