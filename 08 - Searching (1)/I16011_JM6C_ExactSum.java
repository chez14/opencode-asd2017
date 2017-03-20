//package week6;
 
import java.util.Arrays;
import java.util.Scanner;
 
public class I16011_JM6C_ExactSum {
    public static boolean UVA_MODE;
 
    public static void main(String[] args) {
        // UVA_MODE = args.length > 0 && args[0].equals("-v");
        Scanner in = new Scanner(System.in);
 
        int tc = in.nextInt();
        while (tc-- > 0) {
            int[] koleksi = new int[in.nextInt()];
            for (int i = 0; i < koleksi.length; i++)
                koleksi[i] = in.nextInt();
            SolverTingkatSatu sts = new SolverTingkatSatu(koleksi);
            System.out.println(sts.cariCouple(in.nextInt()));
        }
        //in.close();
    }
 
    static class SolverTingkatSatu {
        int[] koleksi;
 
        public SolverTingkatSatu(int[] koleksi) {
            this.koleksi = koleksi;
            Arrays.sort(this.koleksi);
        }
 
        public String cariCouple(int total) {
            // System.err.println("STARTED FINDING " + total + " on array size
            // of "+ koleksi.length);
            // System.err.println("Elements: " + Arrays.toString(koleksi));
            if (total < koleksi[0])
                return "tidak dapat membeli";
            int[] temp = { 0, 0, Integer.MAX_VALUE };
            // {harga_1, harga_2, delta}
            for (int i = 0; i < koleksi.length; i++) {
                if (total - koleksi[i] < 0)
                    break;
                if (Math.abs(total - 2 * koleksi[i]) > temp[2])
                    continue;
                int complematory = (total - koleksi[i]);
                // System.err.println("Trying "+koleksi[i] + " - [" +
                // complematory + "] = " + total + " with delta: " +
                // Math.abs(total-2*koleksi[i]));
                if (binarySearch(complematory, i) && Math.abs(koleksi[i] - complematory) < temp[2]) {
                    // System.err.println("We got " + complematory);
                    // System.err.println("Since it's smaller than " +
                    // Arrays.toString(temp));
                    temp[0] = koleksi[i];
                    temp[1] = complematory;
                    temp[2] = Math.abs(koleksi[i] - complematory);
                    // System.err.println("Now: >>>>>> " +
                    // Arrays.toString(temp));
                }
            }
            if (temp[1] == 0 || temp[2] == 0)
                return "tidak dapat membeli";
            if (temp[0] > temp[1]) {
                int t = temp[0];
                temp[0] = temp[1];
                temp[1] = t;
            }
            // Outputnya kenapa mesti begini :( :(
            if (temp[0] == temp[1]) {
                return "Peter harus membeli buku dengan harga " + temp[0] + " dan " + temp[1] + ".";
            } else {
                return "Peter harus membeli buku dengan harga " + temp[0] + " dan " + temp[1];
            }
            //return "Peter harus membeli buku dengan harga " + temp[0] + " dan " + temp[1];
        }
 
        public boolean binarySearch(int target, int kecuali) {
            int atas = koleksi.length - 1, bawah = 0, tengah;
            while (atas > bawah) {
                tengah = (atas + bawah) / 2;
                if (koleksi[tengah] == target && tengah != kecuali)
                    return true;
                if (koleksi[tengah] >= target)
                    atas = tengah - 1;
                else
                    bawah = tengah + 1;
            }
            return (koleksi[(atas + bawah) / 2] == target) && (((atas + bawah) / 2) != kecuali);
        }
    }
}