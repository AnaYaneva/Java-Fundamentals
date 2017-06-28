package ExercisesSetsAndMaps;

import java.util.HashMap;
import java.util.Scanner;

/*Write a program that receives some info from the console about people and
their phone numbers.
You are free to choose the manner in which the data is entered;
each entry should have just one name and one number (both of them strings).
 If you receive a name that already exists in the phonebook,
 simply update its number.
 After filling this simple phonebook, upon receiving the command "search",
  your program sh.ould be able to perform a search of a contact by name and
  print her details in format "{name} -> {number}".
  In case the contact isn't found, print "Contact {name} does not exist."*/

public class  Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();


        HashMap<String, String> phonebook=new HashMap<>();

        while(!"search".equals(input)) {
            String[] entry = input.split("-");

            phonebook.put(entry[0], entry[1]);

            input = scan.nextLine();
        }
        input = scan.nextLine();

        while(!"stop".equals(input)) {
            if (!phonebook.containsKey(input)){
                System.out.printf("Contact %s does not exist.%n",input);
            }else{
                System.out.printf("%s -> %s%n",input,phonebook.get(input));
            }
            input = scan.nextLine();
        }
    }
}
