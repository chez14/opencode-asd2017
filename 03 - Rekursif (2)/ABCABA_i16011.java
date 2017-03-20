import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class ABCABA_i16011 {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int jum = in.nextInt();
        while (jum-- > 0) {
            System.out.println(Solution.bengBeng(in.next(), 0));
        }
    }
 
    static class Solution {
 
        public static int bengBeng(String teks, int pos) {
            if (pos + 2 >= teks.length()) {
                return 0;
            }
            String temp = teks.substring(pos, pos + 3);
            return ((temp.equals("abc") || temp.equals("aba")) ? 1 : 0) + bengBeng(teks, pos + 1);
        }
    }
}