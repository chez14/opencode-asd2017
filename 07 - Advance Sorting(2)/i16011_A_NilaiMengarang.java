import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_A_NilaiMengarang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc=in.nextInt();
        for(int j=1; j<=tc; j++){
            int[] nilai = new int[in.nextInt()];
            for(int i=0; i<nilai.length; i++)
                nilai[i]=in.nextInt();
            Sorter.sort(nilai);
            System.out.println("Kasus ke-" + j + " :");
            int minta=in.nextInt();
            do {
                System.out.println(nilai[nilai.length-minta]);
                minta = in.nextInt();
            } while (minta!=0);
        }
    }
    
    static class Sorter {
        public static void sort(int[] korban){
            //stage 1: map em all
            int[] maps = new int[101];
            for(int k:korban){
                maps[k]++;
            }
            
            //stage 2: sum em all
            for(int i=1; i<maps.length; i++){
                maps[i] += maps[i-1];
            }
            
            //stage 3: rewrite am all
            int[] klon = korban.clone();
            for(int i=0; i<korban.length; i++){
                korban[maps[klon[i]]-1]=klon[i];
                maps[klon[i]]--;
            }
            
            //stage 4: party.
        }
    }
}