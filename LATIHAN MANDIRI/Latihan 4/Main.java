import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        // Scanner ketikanP etugas = new Scanner(System.in);

        // System.out.print("Masukan nama barang :");
        // String namaBarang = ketikanPetugas.nextLine();

        // System.out.print("Masukan jumlah barang :");
        // int totalBarang = ketikanPetugas.nextInt();

        // System.out.println("=== BENTUK RESI ===");
        // System.out.println("Nama Barang :" + namaBarang);
        // System.out.println("Total Barang :" + totalBarang + "\sBuah");
        // ketikanPetugas.close();

        // Scanner jenisAlat = new Scanner(System.in);

        // System.out.println("=== SISTEM SORTING GUDANG ===");
        
        // System.out.println("Masukan Jenis (PADAT/CAIR) :");
        // String jenis = jenisAlat.nextLine();

        // if(jenis.equalsIgnoreCase("cair")){
        //     System.out.println("Masukan Kedalam alat anti bocor");
        // }else if(jenis.equalsIgnoreCase("padat")){
        //     System.out.println("Masukan kedalam kardus");
        // }else{
        //     System.out.println("jenis tidak dikenal atau error");
        // }

        // System.out.println("Masukan kedalam Zona Penempatan");
        // String zona = jenisAlat.nextLine();

        // switch (zona.toUpperCase()) {
        //     case "A":
        //         System.out.println("letak di rak tinggi");
        //         break;
        //     case "B":
                // System.out.println("letakan di bawah");
        //         break;
        //     default:
        //         System.out.println("letakan diarea karantina sementara");
        //         break;
        // }jenisAlat.close();




        // System.out.println("=== SISTEM PENCETAKAN PRINTER");

        // for(int i=1; i<=5; i++){
        //     System.out.printf("cetak printer ke " + i + "\n");
        // }
        //     System.out.println("cetak berhenti");



        // Scanner input = new Scanner(System.in);

        // boolean lanjut = true;
        // int totalScan = 0;

        // System.out.println("--- SISTEM SCAN BARANG MASUK ---");


        // // PERBAIKAN: Hapus titik koma (;) setelah while(lanjut) agar tidak terjadi infinite loop
        // while(lanjut) {
        // System.out.println("Masukan nama Barang :");
        // String namaBarang = input.nextLine();
        // totalScan++;

        // System.out.println("scan barang lagi ? (y/t) :");
        // String jawaban =input.nextLine();

        // if(jawaban.equalsIgnoreCase("t")){
        //     lanjut = false;
        //  }
        // }
        // System.out.println("total barang di scan :" + totalScan);
        // input.close();

        int i = 0;
        do{
            i++;
            System.out.println("masuk ke perulangan ke" + i++);
        }
        while(i<10);

    }
}


