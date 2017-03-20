import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_SortingOfTheWorld {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] angka = new long[in.nextInt()];
        for (int i = 0; i < angka.length; i++) {
            angka[i] = in.nextInt();
        }
        Solution sl = new Solution(angka);
        for(long a: sl.urut()){
            System.out.println(a);
        }
    }
 
    /**
     * As a solution, i choose heapsort to solve the problem.
     * since all what i did is messing up with the lime limit.
     * thankyou =@=
     */
    static class Solution {
 
        private long[] korban;
 
        public Solution(long[] korban) {
            this.korban = korban;
        }
 
        private int N;
 
        /**
         * sort the number
         *
         * @return sorted number in ascending
         */
        public long[] urut() {
            starter(korban);
            for (int i = N; i > 0; i--) {
                korban = swap(korban, 0, i);
                N = N - 1;
                maxheap(korban, 0);
            }
            return korban;
        }
 
        private void starter(long[] arr) {
            N = arr.length - 1;
            for (int i = N / 2; i >= 0; i--) {
                maxheap(arr, i);
            }
        }
 
        private void maxheap(long[] korban, int i) {
            int kanan = 2 * i,
                    kiri = 2 * i + 1,
                    max = i;
            if (kanan <= N && korban[kanan] > korban[i]) {
                max = kanan;
            }
            if (kiri <= N && korban[kiri] > korban[max]) {
                max = kiri;
            }
 
            if (max != i) {
                maxheap(swap(korban, i, max), max);
            }
        }
 
        private long[] swap(long[] listing, int i, int j) {
            long tmp = listing[i];
            listing[i] = listing[j];
            listing[j] = tmp;
            return listing;
        }
    }
}
//10 1 2 3 7 5 6 4 8 9 10