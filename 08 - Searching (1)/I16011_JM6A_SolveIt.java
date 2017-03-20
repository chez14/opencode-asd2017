//package week6;
import java.util.Scanner;
 
public class I16011_JM6A_SolveIt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while(tc-->0){
            Solver s = new Solver(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
            double hasil = s.binsearch();
            if(hasil==-1)
                System.out.println("tidak ada solusi");
            else
                System.out.printf("%.4f%n", hasil);
        }
        in.close();
    }
    
    
    static class Solver {
        protected int p, q, r, s, t, u;
        
        public Solver(int p, int q, int r, int s, int t, int u){
            this.p=p;
            this.q=q;
            this.r=r;
            this.s=s;
            this.t=t;
            this.u=u;
        }
        
        public double fungsi (double x){
            return p*Math.exp(-x) + q*Math.sin(x) + r*Math.cos(x) + s * Math.tan(x) + t*x*x + u;
        }
        
        public double binsearch(){
            double atas=1, bawah=0, tengah=0.5;
            if(fungsi(atas)*fungsi(bawah)>0)
                return -1;
            while(bawah + 1e-9 < atas){
                tengah = (atas+bawah)/2;
                if(fungsi(tengah) * fungsi(bawah) <= 0)
                    atas=tengah;
                else
                    bawah=tengah;
            }
            return (atas+bawah)/2;
        }
    }
}