import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Write a program that reads a text file and prints on the console the sum of the ASCII symbols of all characters inside of the file. Use BufferedReader in combination with FileReader.
public class SumBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        //String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath))/*;
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))*/){

            String line=in.readLine();
            long sum=0;
            while(line!=null){
                for (Character ch : line.toCharArray()) {
                    sum+=ch;
                }

                //out.println(sum);
                line=in.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
