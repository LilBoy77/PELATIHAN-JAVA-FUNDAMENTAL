import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static DataKendaraanManager manager = new DataKendaraanManager();

    public static void main(String[] args) {
        manager.tambahKendaraan(new Mobil("B 1234 ABC", "Toyota", "Avanza", 2022, 300000, 7));
        manager.tambahKendaraan(new Motor("B 5678 XYZ", "Honda", "PCX", 2023, 100000, "Matic"));
        manager.tambahKendaraan(new Truk("B 9999 TRK", "Hino", "Dutro", 2021, 800000, 5.0));

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");
            switch (pilihan) {
                case 1:
                    tambahKendaraan();
                    break;
                case 2:
                    manager.tampilkanSemuaKendaraan();
                    break;
                case 3:
                    hitungBiayaSewaMenu();
                    break;
                case 4:
                    hapusKendaraan();
                    break;
                case 5:
                    jadwalkanServisMenu();
                    break;
                case 6:
                    manager.cekKondisiSemua();
                    break;
                case 0:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);

        sc.close();
    }

    static void tampilkanMenu() {
        System.out.println("\n===== SISTEM MANAJEMEN DATA KENDARAAN =====");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Tampilkan Semua Kendaraan");
        System.out.println("3. Hitung Biaya Sewa");
        System.out.println("4. Hapus Data Kendaraan");
        System.out.println("5. Jadwalkan Servis Semua Kendaraan");
        System.out.println("6. Cek Kondisi Semua Kendaraan");
        System.out.println("0. Keluar");
    }

    static void tambahKendaraan() {
        System.out.println("Pilih jenis kendaraan: 1) Mobil  2) Motor  3) Truk");
        int jenis = bacaInt("Jenis: ");

        System.out.print("No. Polisi: ");
        String noPolisi = sc.nextLine();
        System.out.print("Merk: ");
        String merk = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        int tahun = bacaInt("Tahun: ");
        double harga = bacaDouble("Harga Sewa Harian: ");

        switch (jenis) {
            case 1: {
                int kursi = bacaInt("Jumlah Kursi: ");
                manager.tambahKendaraan(new Mobil(noPolisi, merk, model, tahun, harga, kursi));
                break;
            }
            case 2: {
                System.out.print("Tipe Motor (matic/manual): ");
                String tipe = sc.nextLine();
                manager.tambahKendaraan(new Motor(noPolisi, merk, model, tahun, harga, tipe));
                break;
            }
            case 3: {
                double kapasitas = bacaDouble("Kapasitas Muatan (ton): ");
                manager.tambahKendaraan(new Truk(noPolisi, merk, model, tahun, harga, kapasitas));
                break;
            }
            default:
                System.out.println("Jenis kendaraan tidak valid.");
                break;
        }
    }

    static void hitungBiayaSewaMenu() {
        System.out.print("Masukkan No. Polisi: ");
        String noPolisi = sc.nextLine();
        Kendaraan k = manager.cariKendaraan(noPolisi);
        if (k == null) {
            System.out.println("Kendaraan tidak ditemukan.");
            return;
        }
        int hari = bacaInt("Jumlah hari sewa: ");

        if (k instanceof Mobil) {
            Mobil mobil = (Mobil) k;
            System.out.println("Biaya normal      : Rp" + String.format("%,.0f", mobil.hitungBiayaSewa(hari)));
            System.out.println("Biaya diskon 10%  : Rp" + String.format("%,.0f", mobil.hitungBiayaSewa(hari, 10.0)));
            System.out.println("Biaya + supir     : Rp" + String.format("%,.0f", mobil.hitungBiayaSewa(hari, true)));
        } else if (k instanceof Motor) {
            Motor motor = (Motor) k;
            System.out.println("Biaya normal        : Rp" + String.format("%,.0f", motor.hitungBiayaSewa(hari)));
            System.out.println("Biaya sewa mingguan : Rp" + String.format("%,.0f", motor.hitungBiayaSewa(hari, true)));
        } else if (k instanceof Truk) {
            Truk truk = (Truk) k;
            System.out.println("Biaya normal        : Rp" + String.format("%,.0f", truk.hitungBiayaSewa(hari)));
            System.out.println("Biaya + bahan bakar : Rp" + String.format("%,.0f", truk.hitungBiayaSewa(hari, 50000.0)));
        }
    }

    static void hapusKendaraan() {
        System.out.print("Masukkan No. Polisi yang akan dihapus: ");
        String noPolisi = sc.nextLine();
        manager.hapusKendaraan(noPolisi);
    }

    static void jadwalkanServisMenu() {
        System.out.print("Masukkan tanggal servis (contoh: 10-08-2026): ");
        String tanggal = sc.nextLine();
        manager.jadwalkanServisSemua(tanggal);
    }

    static int bacaInt(String label) {
        System.out.print(label);
        while (!sc.hasNextInt()) {
            if (!sc.hasNext()) {
                System.out.println("\nInput tidak tersedia (EOF).");
                System.exit(0);
            }
            System.out.print("Input harus berupa angka. " + label);
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    static double bacaDouble(String label) {
        System.out.print(label);
        while (!sc.hasNextDouble()) {
            if (!sc.hasNext()) {
                System.out.println("\nInput tidak tersedia (EOF).");
                System.exit(0);
            }
            System.out.print("Input harus berupa angka. " + label);
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }
}
