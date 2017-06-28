package Exercises;

import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a=scan.nextDouble();
        double b=scan.nextDouble();
        double c=scan.nextDouble();

        double res1=f1(a,b,c);
        double res2=f2(a,b,c);

        double res3=Math.abs(((a+b+c)/3)-(res1+res2)/2);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",res1,res2,res3);

    }
     static double f1(double a,double b, double c){
        double ex1=a*a+b*b;
        double ex2=ex1/(a*a-b*b);
        double sqrtC=Math.sqrt(c);
        double pow=(a+b+c)/sqrtC;
        double ex3=Math.pow(ex2,pow);

        return ex3;
    }

     static double f2(double a,double b, double c){
        double ex1=a*a+b*b-c*c*c;
        double pow=a-b;
        double ex2=Math.pow(ex1,pow);

        return ex2;
    }

}
