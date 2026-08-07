package perpustakaan;

import java.util.ArrayList;
import java.util.Scanner;

import perpustakaan.model.Buku;
import perpustakaan.model.Majalah;
import perpustakaan.model.Pustaka;
import perpustakaan.service.Perpustakaan;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final Perpustakaan perpustakaan =
            new Perpustakaan("Perpustakaan Digital Nusantara");

    public static void main(String[] args) {
        seedData();

        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenu();
            int pilihan = bacaInt("Pilih menu (0-9): ");

            switch (pilihan) {
                case 1:
                    menuTambahData();
                    break;
                case 2:
                    menuTampilkanData();
                    break;
                case 3:
                    menuUbahData();
                    break;
                case 4:
                    menuHapusData();
                    break;
                case 5:
                    menuCariData();
                    break;
                case 6:
                    menuPinjam();
                    break;
                case 7:
                    menuKembalikan();
                    break;
                case 8:
                    perpustakaan.tampilkanPeminjaman();
                    break;
                case 9:
                    perpustakaan.tampilkanStatistik();
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Menu tidak tersedia, silakan pilih 0-9.");
            }
        }
        input.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n==================================================");
        System.out.println("      " + perpustakaan.getNamaPerpustakaan().toUpperCase());
        System.out.println("==================================================");
        System.out.println(" 1. Tambah Koleksi");
        System.out.println(" 2. Tampilkan Koleksi");
        System.out.println(" 3. Ubah Koleksi");
        System.out.println(" 4. Hapus Koleksi");
        System.out.println(" 5. Cari Koleksi");
        System.out.println(" 6. Pinjam Koleksi");
        System.out.println(" 7. Kembalikan Koleksi");
        System.out.println(" 8. Data Peminjaman");
        System.out.println(" 9. Statistik");
        System.out.println(" 0. Keluar");
        System.out.println("--------------------------------------------------");
    }

    private static void menuTambahData() {
        System.out.println("\n--- TAMBAH KOLEKSI ---");
        System.out.println("1. Buku");
        System.out.println("2. Majalah");
        int jenis = bacaInt("Pilih jenis: ");

        if (jenis != 1 && jenis != 2) {
            System.out.println("Jenis tidak valid.");
            return;
        }

        String kode = bacaString("Kode      : ").toUpperCase();
        if (perpustakaan.cariByKode(kode) != null) {
            System.out.println("Kode sudah digunakan!");
            return;
        }
        String judul = bacaString("Judul     : ");
        int tahun = bacaInt("Tahun     : ");
        int stok = bacaInt("Stok      : ");

        Pustaka pustaka;
        if (jenis == 1) {
            String penulis = bacaString("Penulis   : ");
            String penerbit = bacaString("Penerbit  : ");
            int halaman = bacaInt("Halaman   : ");
            pustaka = new Buku(kode, judul, tahun, stok, penulis, penerbit, halaman);
        } else {
            int edisi = bacaInt("Edisi     : ");
            String bulan = bacaString("Bulan     : ");
            pustaka = new Majalah(kode, judul, tahun, stok, edisi, bulan);
        }

        if (perpustakaan.tambah(pustaka)) {
            System.out.println("Berhasil ditambahkan: " + pustaka.tampilkanInfo());
        } else {
            System.out.println("Gagal menambahkan data.");
        }
    }

    private static void menuTampilkanData() {
        System.out.println("\n--- TAMPILKAN KOLEKSI ---");
        System.out.println("1. Semua");
        System.out.println("2. Hanya Buku");
        System.out.println("3. Hanya Majalah");
        System.out.println("4. Hanya yang tersedia");
        int pilihan = bacaInt("Pilih: ");

        if (pilihan == 1) {
            perpustakaan.tampilkanSemua();
        } else if (pilihan == 2) {
            perpustakaan.tampilkanSemua("Buku");
        } else if (pilihan == 3) {
            perpustakaan.tampilkanSemua("Majalah");
        } else if (pilihan == 4) {
            perpustakaan.tampilkanSemua(true);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void menuUbahData() {
        System.out.println("\n--- UBAH KOLEKSI ---");
        perpustakaan.tampilkanSemua();
        String kode = bacaString("Kode yang diubah: ");
        Pustaka p = perpustakaan.cariByKode(kode);
        if (p == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        System.out.println("Data saat ini: " + p.tampilkanInfo());
        System.out.println("1. Ubah judul");
        System.out.println("2. Ubah tahun terbit");
        System.out.println("3. Ubah stok");
        int pilihan = bacaInt("Pilih: ");

        switch (pilihan) {
            case 1:
                perpustakaan.ubahJudul(kode, bacaString("Judul baru: "));
                break;
            case 2:
                perpustakaan.ubahTahun(kode, bacaInt("Tahun baru: "));
                break;
            case 3:
                perpustakaan.ubahStok(kode, bacaInt("Stok baru : "));
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }
        System.out.println("Data setelah diubah: " + p.tampilkanInfo());
    }

    private static void menuHapusData() {
        System.out.println("\n--- HAPUS KOLEKSI ---");
        perpustakaan.tampilkanSemua();
        String kode = bacaString("Kode yang dihapus: ");
        String konfirmasi = bacaString("Yakin hapus " + kode.toUpperCase() + "? (y/n): ");

        if (konfirmasi.equalsIgnoreCase("y") && perpustakaan.hapus(kode)) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Penghapusan dibatalkan atau data tidak ditemukan.");
        }
    }

    private static void menuCariData() {
        System.out.println("\n--- CARI KOLEKSI ---");
        System.out.println("1. Cari judul");
        System.out.println("2. Cari tahun terbit");
        System.out.println("3. Cari judul + tahun");
        int pilihan = bacaInt("Pilih: ");

        ArrayList<Pustaka> hasil;
        if (pilihan == 1) {
            hasil = perpustakaan.cari(bacaString("Kata kunci judul: "));
        } else if (pilihan == 2) {
            hasil = perpustakaan.cari(bacaInt("Tahun: "));
        } else if (pilihan == 3) {
            String judul = bacaString("Kata kunci judul: ");
            hasil = perpustakaan.cari(judul, bacaInt("Tahun: "));
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.println("\nHasil pencarian: " + hasil.size() + " data");
        for (Pustaka p : hasil) {
            System.out.println("- " + p.tampilkanInfo());
        }
    }

    private static void menuPinjam() {
        System.out.println("\n--- PEMINJAMAN ---");
        perpustakaan.tampilkanSemua(true);
        String kode = bacaString("Kode pustaka : ");
        String nama = bacaString("Nama peminjam: ");
        System.out.println(perpustakaan.pinjam(kode, nama));
    }

    private static void menuKembalikan() {
        System.out.println("\n--- PENGEMBALIAN ---");
        perpustakaan.tampilkanPeminjaman();
        String kode = bacaString("Kode pustaka : ");
        String nama = bacaString("Nama peminjam: ");
        System.out.println(perpustakaan.kembalikan(kode, nama));
    }

    private static String bacaString(String pesan) {
        System.out.print(pesan);
        String nilai = input.nextLine().trim();
        while (nilai.isEmpty()) {
            System.out.print("Input tidak boleh kosong. " + pesan);
            nilai = input.nextLine().trim();
        }
        return nilai;
    }

    private static int bacaInt(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nilai = input.nextLine().trim();
            try {
                return Integer.parseInt(nilai);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }

    private static void seedData() {
        perpustakaan.tambah(new Buku("B001", "Laskar Pelangi", 2005, 3,
                "Andrea Hirata", "Bentang Pustaka", 529));
        perpustakaan.tambah(new Buku("B002", "Java Fundamental", 2021, 2,
                "Budi Raharjo", "Informatika", 412));
        perpustakaan.tambah(new Majalah("M001", "National Geographic", 2024, 4,
                12, "Desember"));
        perpustakaan.tambah(new Majalah("M002", "Bobo", 2023, 5,
                45, "November"));
    }
}
