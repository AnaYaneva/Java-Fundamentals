package FilesAndDirsLab;

import java.io.*;

//Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3. Line numbers start from one.

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){
            int counter=1;
            String line=in.readLine();

            while(line!=null){
                if (counter%3==0){
                    out.println(line);
                }
                counter++;
                line=in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
