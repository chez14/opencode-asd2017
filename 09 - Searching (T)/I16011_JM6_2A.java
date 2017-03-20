//package week6_part2;
 
import java.util.Arrays;
import java.util.Scanner;
 
/**
 * Refrenced from
 * https://www.khanacademy.org/math/geometry/hs-geo-foundations/hs-geo-polygons/v/triangle-inqequality-theorem
 * 
 * @author Hayashi
 *
 */
public class I16011_JM6_2A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            int[] kol = new int[in.nextInt()];
            if(kol.length==0)
                return;
            for(int i=0; i<kol.length; i++)
                kol[i] = in.nextInt();
            Tigasegi ts= new Tigasegi(kol);
            System.out.println(ts.cariSegitiga());
        }
    }
 
    static class Tigasegi {
        private int[] kol;
 
        public Tigasegi(int[] collection) {
            this.kol = collection;
            Arrays.sort(this.kol);
        }
 
        public int cariSegitiga() {
            int seg_count = 0;
            for (int i = kol.length - 1; i >= 2; i--)
                for (int j = i - 1; j >= 1; j--)
                    for (int k = j - 1; k >= 0; k--)
                        if (kol[k] >= kol[i] - kol[j] && kol[k] <= kol[i] + kol[j])
                            seg_count++;
 
            return seg_count;
        }
    }
}