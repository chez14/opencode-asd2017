import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author ADMIN7
 */
public class Target2 {
 
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
        System.out.println((Solution.isAble2ReachTarget(korban, in.nextInt()) ? "BISA" : "TIDAK BISA"));
    }
 
    static class Solution {
 
        /*
        Changelog v1.2.0
         - transform some loops into recursive.
         - transform some reduntdant inelegant code into more elegant-feel and look.
         */
        public static boolean isAble2ReachTarget(int[] num, int target) {
            return isAble2ReachTarget(num, target, num.length - 1, 0, false);
        }
 
        public static boolean isAble2ReachTarget(int[] num, int target, int currpos, int total, boolean fiveScanComplete) {
            if (!fiveScanComplete) {
                if (num[currpos] % 5 == 0) {
                    total += num[currpos];
                    num[currpos] = 0;
                }
                return isAble2ReachTarget(num, target, (currpos<=0?num.length-1:currpos-1) , total, currpos <= 0);
            }
 
            if (total >= target || currpos<0) {
                return total == target;
            }
            for (int i = currpos; i >= 0; i--) {
                if (num[i] > target) {
                    continue;
                }
                if (num[i] == target || isAble2ReachTarget(num, target, i - 1, total + num[i], true)) {
                    return true;
                }
            }
            return false;
        }
    }
}