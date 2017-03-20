import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
/**
 *
 * @author ADMIN7
 */
public class i16011_LengthComparator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] listnya = new String[in.nextInt()];
        for(int i=0; i<listnya.length; i++){
            listnya[i]=in.next();
        }
        Arrays.sort(listnya, new LengthComparator());
        for (String listnya1 : listnya) {
            System.out.println(listnya1);
        }
    }
    
    static class LengthComparator implements Comparator<String> {
 
        @Override
        public int compare(String o1, String o2) {
           return o1.length() - o2.length();
        }
    }
}