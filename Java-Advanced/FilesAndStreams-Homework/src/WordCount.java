import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//Write a program that reads a list of words from the file words.txt and finds how many times each of the words is contained in another file text.txt. Matching should be case-insensitive.
// Write the results in file results.txt. Sort the words by frequency in descending order.

public class WordCount {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String textPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\text.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\results.txt";

        try (Scanner in = new Scanner(new FileInputStream(inputPath));
             Scanner txt =  new Scanner(new FileInputStream(textPath));
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){

            List<String> words=new ArrayList<>();
            List<String> wordsText=new ArrayList<>();

            HashMap<String,Integer> repeating=new HashMap<>();

            while(in.hasNext()){
                String word=in.next("\\w+");
                words.add(word.toLowerCase());
            }

            while(txt.hasNext()){
                String word=txt.next("\\w+");
                wordsText.add(word.toLowerCase());
            }
            for (int i = 0; i < wordsText.size(); i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (wordsText.get(i).equals(words.get(j))) {
                        if (!repeating.containsKey(wordsText.get(i))) {
                            repeating.put(wordsText.get(i),1);
                        }else{
                            repeating.put(wordsText.get(i),repeating.get(wordsText.get(i)+1));
                        }
                    }
                }
            }
            //LinkedHashMap<String,Integer> outp=new LinkedHashMap<>();
            for (String s : repeating.keySet()) {
                out.println(s+" - "+repeating.get(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
