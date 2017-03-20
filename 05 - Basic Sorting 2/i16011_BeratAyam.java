import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_BeratAyam {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ayamz[] kambing = new Ayamz[in.nextInt()];
        for (int i = 0; i < kambing.length; i++) {
            kambing[i] = new Ayamz(in.next(), in.nextInt());
        }
        Arrays.sort(kambing);
        for (Ayamz k : kambing) {
            System.out.println(k);
        }
    }
 
    static class Ayamz implements Comparable {
 
        private String nama;
        private int berat;
 
        public Ayamz(String nama, int berat) {
            this.nama = nama;
            this.berat = berat;
        }
 
        public int getBerat() {
            return berat;
        }
 
        public String getNama() {
            return nama;
        }
 
        @Override
        public String toString() {
            return String.format("%s %d", this.nama, this.berat);
        }
 
        @Override
        public int compareTo(Object o) {
            if (o instanceof Ayamz) {
                Ayamz a = (Ayamz) o;
                return a.getBerat() - this.getBerat();
            }
            return -1;
        }
    }
}