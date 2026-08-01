import java.util.Scanner;

public class Gudang{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Jumlah Truk yang masuk hari ini :");
        int jumlah = input.nextInt();

        for(int i = 1; i <= jumlah; i++){
            System.out.println("Meproses jumlah truk" + i);
        }

        System.out.println("Masukan kategori barang (elektronik/pakaian/pangan) :");
        String kategori = input.nextLine();

        
        switch(kategori){
            case "elekronik":
                System.out.println("kembali  zona A (kering)");
                break;
            case "pakaian":
                System.out.println("kembali ke zona B (standar)");
                break;
            case "pangan":
                System.out.println("kembali ke zona C (pendingin)");
                break;
            default :
                System.out.println("inputan error");
        }



    }
}