import java.util.Scanner;
 
/**
 *
 * @author ADMIN7
 */
public class i16011_BJumlahNilai {
 
    static class Urut {
 
        // we'll use the hoare partition
        private static int partition(int[] korban, int start, int end) {
            int pivot = korban[start];
            int i = start - 1;
            int j = end + 1;
            while (true) {
                do {
                    j--;
                } while (korban[j] > pivot);
                do {
                    i++;
                } while (korban[i] < pivot);
                if (i < j) {
                    swap(korban, i, j);
                } else {
                    return j;
                }
            }
        }
 
        private static void swap(int[] korban, int t1, int t2) {
            int temp = korban[t1];
            korban[t1] = korban[t2];
            korban[t2] = temp;
            //itterate_array(korban);
            //System.out.printf("Changed %d, %d%n", t1,t2);
        }
 
        public static void itterate_array(int[] korban) {
            String i = "";
            for (int k : korban) {
                i += k + " ";
            }
            System.out.println(i);
        }
 
        private static void quicksort(int[] korban, int start, int end) {
            if (start < end) {
                int q = partition(korban, start, end);
                quicksort(korban, start, q);
                quicksort(korban, q + 1, end);
            }
        }
 
        public static void urut(int[] korban) {
            quicksort(korban, 0, korban.length - 1);
        }
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] korban1 = new int[in.nextInt()];
        int[] korban2 = new int[korban1.length];
        for (int i = 0; i < korban1.length; i++) {
            korban1[i] = in.nextInt();
        }
        for (int i = 0; i < korban2.length; i++) {
            korban2[i] = in.nextInt();
        }
        if (korban1.length != korban2.length) {
            System.out.println("BEDA");
            return;
        }
        Urut.urut(korban1);
        Urut.urut(korban2);
 
        for (int i = 0; i < korban1.length; i++) {
            if (korban1[i] != korban2[i]) {
                System.out.println("BEDA");
                return;
            }
        }
        System.out.println("SAMA");
 
    }
}