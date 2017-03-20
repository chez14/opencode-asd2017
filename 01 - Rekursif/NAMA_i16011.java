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
public class NAMA_i16011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jum = in.nextInt();
        while(jum-->0)
            System.out.println(isSame(in.next(), in.next())?"SAMA":"BEDA");
    }
    
    
    public static boolean isSame(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        if(s1.length()==0)
            return true;
        return s1.charAt(0) == s2.charAt(0) && isSame(s1.substring(1), s2.substring(1));
    }
}