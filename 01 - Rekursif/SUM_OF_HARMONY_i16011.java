import java.util.Scanner;
 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author i16011
 */
public class SUM_OF_HARMONY_i16011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jum = in.nextInt();
        while(jum-->0){
            System.out.printf("%.4f%n",sumOfHarmony(in.nextInt(),0));
        }
    }
    
    
    public static double sumOfHarmony(int i, double sum){
        if(i==1)
           return sum + 1;
        return sumOfHarmony(i-1, sum + 1.0/i);
    }
}