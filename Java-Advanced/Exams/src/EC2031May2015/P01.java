package EC2031May2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.Scanner;

public class P01 {
    private static List<String> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scan = new Scanner(System.in);

        list= Arrays.asList(reader.readLine().trim().split("\\s+"));

        String input = reader.readLine();
        while (!"end".equals(input)){
            String[] commandLine=input.trim().split("\\s+");

            switch (commandLine[0]){
                case "reverse":
                    if (!commandLine[1].equals("from")&&
                        !commandLine[3].equals("count")&&
                         commandLine.length!=5){
                        printError();
                    }else{
                        int start=Integer.valueOf(commandLine[2]);
                        int count=Integer.valueOf(commandLine[4]);
                        if (start<0||start>list.size()-1||
                            start+count>list.size()-1||count<0){
                            printError();
                        }else {
                            reverseArr(start, count);
                        }
                    }
                    break;
                case "sort":
                    if (!commandLine[1].equals("from")&&
                            !commandLine[3].equals("count")&&
                            commandLine.length!=5){
                        printError();
                    }else{
                        int start=Integer.valueOf(commandLine[2]);
                        int count=Integer.valueOf(commandLine[4]);
                        if (start<0||start>list.size()-1||
                            start+count>list.size()-1||count<0){
                            printError();
                        }else {
                            sortArr(start, count);
                        }
                    }
                    break;
                case "rollLeft":
                    if (!commandLine[2].equals("times")&&
                        commandLine.length!=3){
                        printError();
                    }else{
                        int count=Integer.valueOf(commandLine[1]);
                        if (count<0){
                            printError();
                        }else {
                            rollLeft(count);
                        }
                    }
                    break;
                case "rollRight":
                    if (!commandLine[2].equals("times")&&
                        commandLine.length!=3){
                        printError();
                    }else{
                        int count=Integer.valueOf(commandLine[1]);
                        if (count<0){
                            printError();
                        }else {
                            rollright(count);
                        }
                    }
                    break;
                default:
                    printError();
                    break;
            }

            input = reader.readLine();
        }

        printArr();

    }

    private static void rollright(int count) {
        count%=list.size();

        for (int i = 0; i < count; i++) {
            String rem=list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,rem);
        }
    }

    private static void rollLeft(int count) {
        count%=list.size();

        for (int i = 0; i < count; i++) {
            String rem=list.get(0);
            list.remove(0);
            list.add(rem);
        }
    }

    private static void sortArr(int start, int count) {
        try {
            List<String> temp = new ArrayList<>(list.subList(start, start + count));

            Collections.sort(temp,String.CASE_INSENSITIVE_ORDER);
            for (int i = start; i < start + count; i++) {
                list.set(i, temp.get(i - start));
            }
        }catch (IndexOutOfBoundsException e){
            printError();
        }
    }

    private static void reverseArr(int start, int count) {
        try {
            List<String> temp = new ArrayList<>(list.subList(start, start + count));

            Collections.reverse(temp);
            for (int i = start; i < start + count; i++) {
                list.set(i, temp.get(i - start));
            }
        }catch (IndexOutOfBoundsException e){
            printError();
        }
    }

    private static void printArr() {
        System.out.print("["+String.join(", ",list)+"]");
    }

    private static void printError() {
        System.out.println("Invalid input parameters.");
    }
}
