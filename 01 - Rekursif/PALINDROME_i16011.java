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
public class PALINDROME_i16011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jum = in.nextInt();
        while(jum-->0){
            System.out.println(isPalindrome(in.next(),0)?"YA":"TIDAK");
        }
    }
    
    public static boolean isPalindrome(String s1, int pos){
        s1 = s1.toLowerCase();
        if(pos == Math.ceil(s1.length()/2))
            return true;
        return s1.charAt(pos) == s1.charAt(s1.length()-pos-1) && 
                isPalindrome(s1, pos+1);
    }
}