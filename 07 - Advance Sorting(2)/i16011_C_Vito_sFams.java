//package week5;
 
import java.util.Scanner;
 
public class i16011_C_Vito_sFams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc=in.nextInt();
        while(tc-->0){
            int[] rums=new int[in.nextInt()];
            for(int i=0; i<rums.length; i++)
                rums[i]=in.nextInt();
            Solver s = new Solver(rums);
            System.out.println(s.getSurveyResult());
            
        }
    }
    
    static class Sorter {
        public static void radixify(int[] korban) {
            //rescan the biggest number
            int max=korban[0];
            for(int k:korban)
                max=Math.max(max,k);
            //System.out.println("MAX: " + max);
            //getting the length
            for(int i=1, target=(int)Math.pow(10, Bilangan.getLength(max));
                    i<target; i*=10){
                //stage 1: mapify
                int[] maps = new int[10];
                for(int j=0; j<korban.length; j++)
                    maps[(korban[j]/i)%10]++;
                
                //stage 2: sumify
                for(int j=1; j<maps.length; j++)
                    maps[j]+=maps[j-1];
                
                //stage 3: replacify
                int[] klon = korban.clone();
                for(int j=klon.length-1; j>=0; j--){
                    korban[maps[(klon[j]/i)%10]-1]=klon[j];
                    maps[(klon[j]/i)%10]--;
                }
            }
        }
        
        
    }
    
    static class Bilangan {
        public static int getLength(int bilangan){
            int temp=1;
            while((bilangan/=10)>0)
                temp++;
            return temp;
        }
    }
    
    static class Solver {
        protected int[] korbans;
        public Solver(int[] korbans){
            this.korbans=korbans;
        }
        private int recountAll(int pos){
            int temp=0;
            //System.out.printf("korban[%d]: %d%n",pos, korbans[pos]);
            for(int i=0; i<korbans.length; i++){
                temp += Math.abs(korbans[i]-korbans[pos]);
            }
            return temp;
        }
        
        public int getSurveyResult(){
            Sorter.radixify(korbans);
            return recountAll(korbans.length/2);
        }
    }
}