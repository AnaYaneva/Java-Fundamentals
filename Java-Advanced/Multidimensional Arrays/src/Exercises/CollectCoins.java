package Exercises;

import java.util.Scanner;

public class CollectCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][]board=new char[4][];

        for (int row = 0; row < 4; row++) {
            String input = scan.nextLine();
            board[row] = input.toCharArray();
        }

        char[] commands = scan.nextLine().toCharArray();

        int coinsCounter=0;
        int wallsHit=0;
        char currentPos=board[0][0];
        int currentRow=0;
        int currentCol=0;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]){
                case 'V':
                    try{
                    currentRow+=1;
                    currentPos=board[currentRow][currentCol];
                        if (currentPos=='$'){
                            coinsCounter++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException ex){
                    wallsHit+=1;
                    }
                    break;
                case '>':
                    try{
                        currentCol+=1;
                        currentPos=board[currentRow][currentCol];
                        if (currentPos=='$'){
                            coinsCounter++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException ex){
                    wallsHit+=1;
                    }
                    break;
                case '<':
                    try{
                        currentCol-=1;
                        currentPos=board[currentRow][currentCol];
                        if (currentPos=='$'){
                            coinsCounter++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException ex){
                        wallsHit+=1;
                    }
                    break;
                case '^':
                    try{
                        currentRow-=1;
                        currentPos=board[currentRow][currentCol];
                        if (currentPos=='$'){
                            coinsCounter++;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException ex){
                        wallsHit+=1;
                    }
                    break;
            }
        }
        System.out.println("Coins collected: "+coinsCounter);
        System.out.println("Walls hit: "+wallsHit);
    }
}
