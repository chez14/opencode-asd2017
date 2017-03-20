import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_Kayu {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] korban = new int[in.nextInt()];
        int selisih = in.nextInt();
        for (int i = 0; i < korban.length; i++) {
            korban[i] = in.nextInt();
            korban[i] *= korban[i];
        }
        Arrays.sort(korban);
        int counta = 0, curr = 0;
       // System.out.println("----------");
        for (int i = 0; i < korban.length; i++) {
            if (korban[i]-curr >= selisih || i==0) {
                counta++;
                //System.out.println(Math.sqrt(korban[i]));
                curr=korban[i];
            }
        }
        //System.out.println("----------");
        System.out.println(counta);
    }
 
}