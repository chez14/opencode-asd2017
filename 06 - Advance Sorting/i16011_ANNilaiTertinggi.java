import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author ADMIN7
 */
public class i16011_ANNilaiTertinggi {
 
    static class Urut {
 
        // we'll use the lomuto partition
        private static int partition(int[] korban, int start, int end) {
            int temp = korban[end];
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (korban[j] <= temp) {
                    i ++;
                    swap(korban, i, j);
                }
            }
            swap(korban, i + 1, end);
            return i + 1;
        }
 
        private static void swap(int[] korban, int t1, int t2) {
            int temp = korban[t1];
            korban[t1] = korban[t2];
            korban[t2] = temp;
            //itterate_array(korban);
            //System.out.printf("Changed %d, %d%n", t1,t2);
        }
        
        public static void itterate_array(int[] korban){
            String i="";
            for(int k:korban)
                i+=k + " ";
            System.out.println(i);
        }
 
        private static void quicksort(int[] korban, int start, int end) {
            if (start < end) {
                int q = partition(korban, start, end);
                quicksort(korban, start, q -1);
                quicksort(korban, q + 1, end);
            }
        }
 
        public static void urut(int[] korban) {
            quicksort(korban, 0, korban.length -1);
        }
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] korban = new int[in.nextInt()];
        for(int i=0; i<korban.length; i++){
            korban[i]=in.nextInt();
        }
        Urut.urut(korban);
        int jum = in.nextInt();
        for(int i=0; i<jum; i++)
            System.out.println(korban[korban.length-1-i]);
    }
}