import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_TelorAyam {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ayamz[] kambing = new Ayamz[in.nextInt()];
        for (int i = 0; i < kambing.length; i++) {
            kambing[i] = new Ayamz(in.next(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(kambing);
        for (Ayamz k : kambing) {
            System.out.println(k);
        }
    }
 
    static class Ayamz implements Comparable {
 
        private String nama;
        private int berat;
        private int telor;
 
        public Ayamz(String nama, int berat, int telor) {
            this.nama = nama;
            this.berat = berat;
            this.telor = telor;
        }
 
        public int getBerat() {
            return berat;
        }
 
        public String getNama() {
            return nama;
        }
 
        public int getTelor() {
            return telor;
        }
        
 
        @Override
        public String toString() {
            return String.format("%s %d %d", this.nama, this.berat, this.telor);
        }
 
        @Override
        public int compareTo(Object o) {
            if (o instanceof Ayamz) {
                Ayamz a = (Ayamz) o;
                int gg = a.getBerat() - this.getBerat();
                if(gg!=0)
                    return gg;
                gg = a.getTelor() - this.getTelor();
                if(gg!=0)
                    return gg;
                return nama.compareTo(a.getNama());
            }
            return 0;
        }
    }
}