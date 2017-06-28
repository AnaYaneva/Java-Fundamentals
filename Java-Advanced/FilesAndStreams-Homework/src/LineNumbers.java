import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

//Write a program that reads a text file and inserts line numbers in front of each of its lines. The result should be written to another text file.
public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){

            String line=in.readLine();
            int count=1;

            while(line!=null){

                out.println(count+". "+line);
                count++;
                line=in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
