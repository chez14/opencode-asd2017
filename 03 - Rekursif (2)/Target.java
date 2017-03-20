import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class Target {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] korban = new int[in.nextInt()];
        for (int i = 0; i < korban.length; i++) {
            korban[i] = in.nextInt();
        }
        Arrays.sort(korban);
        System.out.println((Solution.isAble2ReachTarget(korban, in.nextInt(), korban.length-1, 0) ? "BISA" : "TIDAK BISA"));
    }
 
    static class Solution {
//        /static String dbgspace = "";
        //cara jalan: dari belakang;
        public static boolean isAble2ReachTarget(int[] num, int target, int currpos, int total) {
            if(total>target)
                return false;
            if (total == target) {
                return true;
            }
            if (currpos < 0) {
                return false;
            }
            for (int i = currpos; i >= 0; i--) {
                if(num[i]>target)
                    continue;
                if(num[i]==target)
                    return true;
                //System.out.println(dbgspace+num[i] + "; " + total);
                //dbgspace+=" ";
                if (isAble2ReachTarget(num, target, i-1, total + num[i])) {
                    return true;
                }
                //dbgspace = dbgspace.substring(0, dbgspace.length()-1);
                
            }
            return false;
        }
    }
}