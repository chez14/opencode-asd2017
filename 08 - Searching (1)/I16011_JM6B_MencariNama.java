//package week6;
 
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class I16011_JM6B_MencariNama {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        SadUser[] sadu = new SadUser[in.nextInt()];
        for (int i = 0; i < sadu.length; i++)
            sadu[i] = (new SadUser(in.next(), in.next(), in.next()));
        AccountCollection a = new AccountCollection(sadu);
        int tc = in.nextInt();
        while (tc-- > 0) {
            System.out.println(a.find(in.next()));
        }
        in.close();
        if (args.length > 0 && args[0].equals("-v"))
            System.err.println(System.currentTimeMillis() - start);
    }
 
    static class SadUser {
        public String username, uSERNAME, nama, password;
 
        public SadUser(String username, String nama, String password) {
            this.username = username;
            this.nama = nama;
            this.password = password;
        }
 
        public String toString() {
            return username + " " + nama + " " + password;
        }
    }
 
    static class ColletionSortHelper implements Comparator<SadUser> {
        @Override
        public int compare(SadUser o1, SadUser o2) {
            return o1.username.compareToIgnoreCase(o2.username);
        }
    }
 
    static class AccountCollection {
        public final String TYDAC_ADA = "Tidak ada ", KETEMU = "Ada ";
        protected SadUser[] su;
 
        public AccountCollection(SadUser[] su) {
            this.su = su;
            Arrays.sort(this.su, new ColletionSortHelper());
        }
 
        public String find(String username) {
            int atas = su.length - 1, bawah = 0, tengah;
            while (atas > bawah) {
                tengah = (atas + bawah) / 2;
                int cmp_tenga = username.compareToIgnoreCase(su[tengah].username);
                if (cmp_tenga == 0)
                    return KETEMU + su[tengah];
                if (cmp_tenga < 0)
                    atas = tengah - 1;
                else
                    bawah = tengah + 1;
            }
            if (username.compareToIgnoreCase(su[(atas + bawah) / 2].username) == 0)
                return KETEMU + su[(atas + bawah) / 2].toString();
            return TYDAC_ADA + username;
        }
    }
}