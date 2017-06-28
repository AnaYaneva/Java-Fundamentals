package FilesAndDirsLab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Read the file named "input.txt" and write to another file every character's ASCII representation.

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte==10||oneByte==32) {
                    out.write(oneByte);
                }else{
                    String digits=String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
