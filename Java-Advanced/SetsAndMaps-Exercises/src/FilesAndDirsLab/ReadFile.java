package FilesAndDirsLab;

import java.io.FileInputStream;
import java.io.IOException;

//You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes (the binary representation of the ASCII code for each character) separated by a single comma.

public class ReadFile {
    public static void main(String[] args) {
        String path = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";

        try (FileInputStream in = new FileInputStream(path)) {
            int oneByte=in.read();
            while(oneByte>=0){
                System.out.printf("%s ",Integer.toBinaryString((oneByte)));
                oneByte=in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
