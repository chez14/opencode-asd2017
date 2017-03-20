import java.util.Scanner;
 
/**
 *
 * @author i16011
 */
public class i16011_B_BurrowsWheel {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(String res:
                (new Solver(
                        in.next()
                )).hajar()){
            System.out.println(res);
        }
    }
 
    static class Solver {
        
        private String mangsa;
        
        public Solver(String mangsa){
            this.mangsa = mangsa;
        }
 
        private String[] buildWheel(String kata) {
            String[] temp = new String[kata.length()];
            for (int i = 0; i < kata.length(); i++) {
                temp[i] = displace(kata, i);
            }
            return temp;
        }
 
        private String displace(String kata, int distance) {
            distance = distance % kata.length();
            return kata.substring(distance, kata.length()) + kata.substring(0, distance);
        }
 
        private void doRadix(String[] korban) {
            for (int i = korban[0].length()-1; i >=0; i--) {
                //stage 1: map em all
                int[] maps = new int['Z' - 'A' + 1];
                for (int j = 0; j < korban.length; j++) {
                    maps[korban[j].charAt(i) - 'A']++;
                }
 
                //stage 2: sum em all
                for (int j = 1; j < maps.length; j++) {
                    maps[j] += maps[j - 1];
                }
 
                //stage 3: rewite em all
                String[] klon = new String[korban.length];
                for (int j = korban.length-1; j >= 0; j--) {
                    klon[maps[korban[j].charAt(i)-'A'] - 1] = korban[j];
                    maps[korban[j].charAt(i)-'A']--;
                }
                for(int j=0; j<korban.length; j++){
                    korban[j]=klon[j];
                }
                
                //stage 4: cry alot, you have to do it until the end the of string.
            }
            //stage 5: sleep. alot.
        }
        
        public String[] hajar(){
            String[] hasil = buildWheel(mangsa);
            String s2 = hasil[1];
            doRadix(hasil);
            String temp="";
            int lokasiS2=1;
            //System.out.println("-------------");
            for(int i=0; i<hasil.length; i++){
            //    System.out.println(hasil[i]);
                if(hasil[i]==s2)
                    lokasiS2=i;
                temp+= hasil[i].charAt(hasil[i].length()-1);
            }
            //System.out.println("-------------");
 
            return new String[] {temp, String.valueOf(lokasiS2)};
        }
    }
}