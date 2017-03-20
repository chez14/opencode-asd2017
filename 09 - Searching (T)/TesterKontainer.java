import java.util.Scanner;
 
public class TesterKontainer {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Banyak kasus
        int t = sc.nextInt();
        Wadah[] wadahSusu;
        PabrikSusu ps;
        for (int i = 0; i < t; i++) {
            //banyaknya wadah susu
            int n = sc.nextInt();
 
            //banyaknya kontainer
            int m = sc.nextInt();
            wadahSusu = new Wadah[n];
            for (int j = 0; j < n; j++) {
                //kapasitas wadah susu
                wadahSusu[j] = new Wadah(sc.nextInt());
            }
            ps = new PabrikSusu(wadahSusu, m);
            //Tampilkan hasil
            System.out.println(ps.solve());
        }
    }
}
 
class PabrikSusu {
 
    //SILAHKAN TAMBAHKAN ATRIBUT DAN METHOD LAIN YANG DIBUTUHKAN
    //wadah-wadah susu yang akan dipindahkan ke kontainer
    private Wadah[] wadahSusu;
 
    //banyaknya kontainer
    private int banyakKontainer;
 
    private int stokSusuTotal;
 
    /**
     * Constructor
     *
     * @param wadahSusu: wadah-wadah susu yang akan dipindahkan ke kontainer
     * @param banyakKontainer: banyaknya kontainer
     */
    public PabrikSusu(Wadah[] wadahSusu, int banyakKontainer) {
        this.wadahSusu = wadahSusu;
        this.banyakKontainer = banyakKontainer;
        for (int i = 0; i < wadahSusu.length; i++) {
            stokSusuTotal += wadahSusu[i].getKapasitas();
        }
    }
 
    private int recSolve(int bawah, int atas) {
        if (bawah > atas) {
            return -1;
        } else {
            int mid = (bawah + atas) / 2;
 
            if (bawah == atas) {
                return bawah;
            } else if (this.simulate(mid)) {
                return recSolve(bawah, mid);
            } else {
                return recSolve(mid + 1, atas);
            }
        }
    }
 
    //Method untuk mencari kemungkinan terkecil dari kapasitas maksimum dari kontainer yang mungkin
    public int solve() {
        return this.recSolve(1, stokSusuTotal);
    }   
 
    private boolean simulate(int mid) {
        int temp = 0, total = 0;
        for (int i = 0; i < wadahSusu.length && total < banyakKontainer; i++) {
            if(wadahSusu[i].getKapasitas() > mid)
                return false;
            temp += wadahSusu[i].getKapasitas();
            if (temp > mid) {
                temp = wadahSusu[i].getKapasitas();
                total++;
            } 
            if (temp == mid) {
                temp = 0;
                total++;
            }
        }
        return total < banyakKontainer ;
    }
 
}
//Kelas ini merepresentasikan wadah susu
class Wadah{
  //atribut untuk menyimpan kapasitas wadah susu
  private int kapasitas;  
  /**
    * Constructor
    * @param kapasitas wadah susu
    */
  public Wadah(int kapasitas){this.kapasitas = kapasitas;} 
 
  /**
    * Getter kapasitas wadah
    */  
  public int getKapasitas(){return this.kapasitas;}
}