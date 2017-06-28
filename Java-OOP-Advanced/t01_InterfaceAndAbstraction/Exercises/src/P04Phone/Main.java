import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);
        String[] numbers = reader.readLine().trim().split("\\s+");
        String[] urls = reader.readLine().trim().split("\\s+");

        Smartphone phone=new Smartphone();

        for (String num : numbers) {
            if (num.matches("\\d+")){
                phone.Call(num);
            }else{
                System.out.println("Invalid number!");
            }
        }

        for (String url : urls) {
            if (url.matches("\\D+")){
                phone.Browse(url);
            }else{
                System.out.println("Invalid URL!");
            }
        }
    }
}
