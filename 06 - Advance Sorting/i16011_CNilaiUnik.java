import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
/**
 *
 * @author ADMIN7
 */
public class i16011_CNilaiUnik {
 
    static class Urut {
        public static void urut(int[] korban){
            sort(korban, 0, korban.length-1);
        }
        private static void sort(int[] korban, int awal, int akhir) {
            if (awal < akhir) {
                int tengah = (awal + akhir) / 2;
                sort(korban, awal, tengah);
                sort(korban, tengah + 1, akhir);
                gabung(korban, awal, tengah, akhir);
            }
        }
 
        private static void gabung(int[] korban, int awal, int tengah, int akhir) {
            int lsize = tengah - awal + 1;
            int rsize = akhir - tengah;
            int[] kKiri = new int[lsize+1],
                    kKanan = new int[rsize+1];
            for (int i = 0; i < lsize; i++) {
                kKiri[i] = korban[awal + i];
            }
            for (int i = 0; i < rsize; i++) {
                kKanan[i] = korban[tengah + 1 + i];
            }
            kKiri[lsize] = Integer.MAX_VALUE;
            kKanan[rsize] = Integer.MAX_VALUE;
            int kamKir = 0, kamKan = 0;
            for(int i=awal; i<=akhir; i++){
                if(kKiri[kamKir] <= kKanan[kamKan]){
                    korban[i] = kKiri[kamKir];
                    kamKir++;
                } else {
                    korban[i] = kKanan[kamKan];
                    kamKan++;
                } 
            }
 
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] korban = new int[in.nextInt()];
        for(int i=0; i<korban.length; i++){
            korban[i] = in.nextInt();
        }
        Urut.urut(korban);
        List<Integer> hasil = new ArrayList<Integer>();
        for(int i=korban.length-1; i>=0; i--){
            if(i==0 || korban[i-1] != korban[i]){
                System.out.print(korban[i] + " ");
            }
        }
        
    }
}