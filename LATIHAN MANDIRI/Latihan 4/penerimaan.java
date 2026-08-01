import java.util.Scanner;

public class penerimaan {
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        inpeksiBarang inspektur = new inpeksiBarang();

        System.out.println("=== SYSTEM INSPEKSI BARANG ===");

        System.out.println("berapa banyak jumlah inspeksi hari ini? :");
        int jumlah = input.nextInt();

        input.nextLine();

        System.out.println("memulai inspeksi");

        


    }
}
