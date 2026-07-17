package tugas.pertemuan2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        NilaiService service = new NilaiService();

        int pilihan;

        do {
            System.out.println("\n=========================================");
            System.out.println("     SISTEM PENDATAAN NILAI MAHASISWA");
            System.out.println("=========================================");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    inputData(scanner, daftarMahasiswa, service);
                    break;
                case 2:
                    tampilkanData(daftarMahasiswa);
                    break;
                case 3:
                    System.out.println("\nTerima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("\nMenu tidak valid! Silakan pilih 1-3.");
                    break;
            }
        } while (pilihan != 3);

        scanner.close();
    }

    public static void inputData(Scanner scanner, ArrayList<Mahasiswa> daftar, NilaiService service) {
        System.out.print("\nMasukkan jumlah mahasiswa: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= jumlah; i++) {
            System.out.println("\n--- Data Mahasiswa ke-" + i + " ---");
            System.out.print("NIM         : ");
            String nim = scanner.nextLine();
            System.out.print("Nama        : ");
            String nama = scanner.nextLine();
            System.out.print("Nilai Tugas : ");
            double tugas = scanner.nextDouble();
            System.out.print("Nilai UTS   : ");
            double uts = scanner.nextDouble();
            System.out.print("Nilai UAS   : ");
            double uas = scanner.nextDouble();
            scanner.nextLine();

            Mahasiswa mhs = new Mahasiswa(nim, nama, tugas, uts, uas);

            double nilaiAkhir = service.hitungNilaiAkhir(tugas, uts, uas);
            mhs.setNilaiAkhir(nilaiAkhir);

            mhs.setGrade(NilaiService.tentukanGrade(nilaiAkhir));

            mhs.setStatusKelulusan(service.tentukanStatus(nilaiAkhir));

            daftar.add(mhs);
            System.out.println(">> Data " + nama + " berhasil disimpan!");
        }
    }

    public static void tampilkanData(ArrayList<Mahasiswa> daftar) {
        if (daftar.isEmpty()) {
            System.out.println("\nBelum ada data. Silakan input data terlebih dahulu.");
            return;
        }

        System.out.println("\n==========================================================================================");
        System.out.printf("%-12s %-18s %-13s %-7s %-14s %-14s%n",
                "NIM", "NAMA", "NILAI AKHIR", "GRADE", "PREDIKAT", "STATUS");
        System.out.println("==========================================================================================");

        int i = 0;
        while (i < daftar.size()) {
            Mahasiswa m = daftar.get(i);
            String predikat = NilaiService.tentukanPredikat(m.getGrade());
            System.out.printf("%-12s %-18s %-13.2f %-7s %-14s %-14s%n",
                    m.getNim(),
                    m.getNama(),
                    m.getNilaiAkhir(),  
                    m.getGrade(),
                    predikat,
                    m.getStatusKelulusan());
            i++;
        }
        System.out.println("==========================================================================================");
        System.out.println("Total mahasiswa: " + daftar.size());
    }
}