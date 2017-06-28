package Judge;//Lab: Files and Directories I.1

import IO.OutputWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {
   public static void compareContent(String actualOutput,String expectedOutput){
       OutputWriter.writeMessageOnNewLine("Reading files...");
       String mismatchPath=getMismatchPath(expectedOutput);
       //Lab: Files and Directories I.2
       List<String> actualOutputString=readTextFile(actualOutput);
       List<String> expectedOutputString=readTextFile(expectedOutput);

       //Lab: Files and Directories I.3
       boolean mismatch=compareStrings(actualOutputString,expectedOutputString,mismatchPath);

       if (mismatch){
           List<String> mismatchString=readTextFile(mismatchPath);
           mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
       }else{
           OutputWriter.writeMessageOnNewLine("Files are identical.There are no mismatches.");
       }
   }

    private static boolean compareStrings(
                                            List<String> actualOutputString,
                                            List<String> expectedOutputString,
                                            String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output="";
        boolean isMismatch=false;

        try{
            FileWriter fileWriter=new FileWriter(mismatchPath);
            BufferedWriter writer=new BufferedWriter(fileWriter);

            //TODO:
            for (int i = 0; i <expectedOutputString.size() ; i++) {
                if (!expectedOutputString.get(i).equals(actualOutputString.get(i))) {
                    isMismatch = true;
                    output=String.format("mismatch -> expected{%s}, actual{%s}%n",
                            expectedOutputString.get(i),
                            actualOutputString.get(i));
                }else{
                    output=String.format("line match -> %s%n",
                            actualOutputString.get(i));
                }
            }//

            //TODO:
            writer.append(output);
            //

            writer.close();
        }catch(Exception e){
            OutputWriter.displayException("Error.");
        }

        return isMismatch;
    }

    //Lab: Files and Directories I.2
    private static List<String> readTextFile(String filePath) {
        List<String> text=new ArrayList<>();
        try {
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            //TODO:
            while(!line.equals("")){
                text.add(line);
                line=reader.readLine();
            }
            reader.close();
            //
        }catch(Exception e){
            OutputWriter.writeMessageOnNewLine("File not found.");
        }
        return text;
    }

    //Lab: Files and Directories I.1
   public static String getMismatchPath(String expectedOutput){
       int index=expectedOutput.lastIndexOf('\\');
       String directoryPath=expectedOutput.substring(0,index);
       return directoryPath+"\\mismatch.txt";
   }
}
