import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//Write a program that reads a text file and prints on the console the sum of the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader.

public class SumLines {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        //String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath))/*;
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))*/){

            String line=in.readLine();

            while(line!=null){
                int sum=0;
                for (Character ch : line.toCharArray()) {
                    sum+=ch;
                }

                //out.println(sum);
                System.out.println(sum);

                line=in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
