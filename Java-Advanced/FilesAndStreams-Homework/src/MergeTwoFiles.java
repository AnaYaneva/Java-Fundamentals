import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

//Write a program that reads the contents of two text files and merges them together into a third one.
public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String textPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\text.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\results.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));
             BufferedReader txt = Files.newBufferedReader(Paths.get(textPath));
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){

            String line=in.readLine();

            while(line!=null){
                out.println(line);
                line=in.readLine();
            }

            line=txt.readLine();

            while(line!=null){
                out.println(line);
                line=txt.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
