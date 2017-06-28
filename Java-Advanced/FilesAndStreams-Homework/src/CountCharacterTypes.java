import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Write a program that reads a list of words from the file input.txt and finds the count of vowels, consonants and punctuation marks. Assume that:
•	a, e, i, o, u are vowels
•	All others are consonants
•	Punctuation marks are (!,.?)
•	Do not count whitespace.
Write the results to another file.
*/
public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni\\Java Advanced\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        List<Character> punctuationMarks = new ArrayList<>();
        Collections.addAll(punctuationMarks, '.', ',', '!', '?');

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U');


        List<Character> consonants=new ArrayList<>();
        char[] cons=("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ1234567890".toCharArray());
        for (char con : cons) {
            consonants.add(con);
        }

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out=new PrintWriter(new FileOutputStream(outputPath))){

            int countVowels=0;
            int countConsonants=0;
            int countPunctuation=0;

            String line=in.readLine();

            while(line!=null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        countVowels++;
                    } else if (consonants.contains(c)) {
                        countConsonants++;
                    } else if (punctuationMarks.contains(c)) {
                        countPunctuation++;
                    }
                }
                line = in.readLine();
            }
                out.println("Vowels: "+countVowels);
                out.println("Consonants: "+countConsonants);
                out.println("Punctuation: "+countPunctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
