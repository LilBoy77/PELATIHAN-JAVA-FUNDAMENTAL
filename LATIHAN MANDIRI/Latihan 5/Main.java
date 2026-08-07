import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Nama saya adalah lilboy");
        System.out.print("- Teknik Elektro");

        int umur = 20;
        String nama = "lilboy";
        double tinggi = 1.75;
        boolean mahasiswa = true;

        System.out.printf("Umur   : %d", umur);
        System.out.printf("Nama   : %s", nama);
        System.out.printf("Tinggi : %.2f", tinggi);
        System.out.printf("aktif  : %b", mahasiswa);

        Scanner input = new Scanner(System.in);
        System.out.println("Masukan nama anda :");
        String namaInput = input.nextLine();

        System.out.println("Masukan umur anda :");
        int umurInput = input.nextInt();

        System.out.println("Masukan nilai UTS anda :");
        double nilaiUts = input.nextDouble();

        System.out.printf("nama saya adalah : %s", namaInput);
        System.out.printf("umur saya adalah : %d", umurInput);
        System.out.printf("nilai UTS saya adalah : %.2f", nilaiUts);
        input.close();
    }
}