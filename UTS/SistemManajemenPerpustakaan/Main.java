import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PengelolaPerpustakaan pengelola = new PengelolaPerpustakaan();

    public static void main(String[] args) {
        inisiayasiDataAwal();

        int pilihan = -1;
        do {
            tampilkanMenuUtama();
            pilihan = bacaAngkaInt("Pilih menu (0-7): ");

            switch (pilihan) {
                case 1:
                    menuKelolaBuku();
                    break;
                case 2:
                    menuKelolaAnggota();
                    break;
                case 3:
                    menuPencarian();
                    break;
                case 4:
                    menuPeminjaman();
                    break;
                case 5:
                    menuPengembalian();
                    break;
                case 6:
                    pengelola.tampilkanTransaksi();
                    break;
                case 7:
                    pengelola.tampilkanStatistikKategori();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Perpustakaan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan masukkan angka 0-7.");
                    break;
            }
        } while (pilihan != 0);
    }

    private static void inisiayasiDataAwal() {
        pengelola.tambahBuku(new BukuFisik("B01", "Pemrograman Java Dasar", "Teknologi", "Rak A1"));
        pengelola.tambahBuku(new BukuFisik("B02", "Struktur Data dan Algoritma", "Teknologi", "Rak A2"));
        pengelola.tambahBuku(new BukuDigital("BD01", "Desain Sistem Terdistribusi", "Teknologi", 14.5));

        pengelola.tambahAnggota(new Anggota("A01", "Budi Santoso", "budi@email.com"));
        pengelola.tambahAnggota(new Anggota("A02", "Siti Rahma", "siti@email.com"));
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n==========================================");
        System.out.println("     SISTEM MANAJEMEN PERPUSTAKAAN        ");
        System.out.println("==========================================");
        System.out.println("1. Kelola Buku (CRUD)");
        System.out.println("2. Kelola Anggota (CRUD)");
        System.out.println("3. Cari Buku / Anggota");
        System.out.println("4. Peminjaman Buku");
        System.out.println("5. Pengembalian Buku");
        System.out.println("6. Lihat Daftar Transaksi");
        System.out.println("7. Statistik Jumlah Buku per Kategori");
        System.out.println("0. Keluar");
    }

    private static String bacaTeks(String label) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(label);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong atau spasi saja!");
            }
        }
        return input.trim();
    }

    private static int bacaAngkaInt(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat yang valid!");
            }
        }
    }

    private static double bacaAngkaDouble(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(input);
                if (val <= 0) {
                    System.out.println("Nilai harus lebih dari 0!");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka desimal yang valid!");
            }
        }
    }

    private static void menuKelolaBuku() {
        System.out.println("\n--- MENU KELOLA BUKU ---");
        System.out.println("1. Tambah Buku Fisik");
        System.out.println("2. Tambah Buku Digital");
        System.out.println("3. Tampilkan Semua Buku");
        System.out.println("4. Ubah Data Buku");
        System.out.println("5. Hapus Buku");
        System.out.println("0. Kembali ke Menu Utama");

        int sub = bacaAngkaInt("Pilih menu buku: ");
        switch (sub) {
            case 1:
                String kodeF = bacaTeks("Kode Buku: ");
                String judulF = bacaTeks("Judul Buku: ");
                String katF = bacaTeks("Kategori Buku: ");
                String rak = bacaTeks("Lokasi Rak: ");
                if (pengelola.tambahBuku(new BukuFisik(kodeF, judulF, katF, rak))) {
                    System.out.println("Berhasil menambahkan buku: " + judulF);
                }
                break;
            case 2:
                String kodeD = bacaTeks("Kode Buku: ");
                String judulD = bacaTeks("Judul Buku: ");
                String katD = bacaTeks("Kategori Buku: ");
                double mb = bacaAngkaDouble("Ukuran Berkas (MB): ");
                if (pengelola.tambahBuku(new BukuDigital(kodeD, judulD, katD, mb))) {
                    System.out.println("Berhasil menambahkan buku: " + judulD);
                }
                break;
            case 3:
                pengelola.tampilkanSemuaBuku();
                break;
            case 4:
                String kodeU = bacaTeks("Kode Buku yang akan diubah: ");
                ItemPerpustakaan bU = pengelola.cariBuku(kodeU);
                if (bU == null) {
                    System.out.println("Buku tidak ditemukan!");
                    break;
                }
                String jBaru = bacaTeks("Judul Baru: ");
                String kBaru = bacaTeks("Kategori Baru: ");
                pengelola.updateBuku(kodeU, jBaru, kBaru);
                break;
            case 5:
                String kodeH = bacaTeks("Kode Buku yang akan dihapus: ");
                pengelola.hapusBuku(kodeH);
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan sub-menu tidak valid!");
                break;
        }
    }

    private static void menuKelolaAnggota() {
        System.out.println("\n--- MENU KELOLA ANGGOTA ---");
        System.out.println("1. Tambah Anggota");
        System.out.println("2. Tampilkan Semua Anggota");
        System.out.println("3. Ubah Data Anggota");
        System.out.println("4. Hapus Anggota");
        System.out.println("0. Kembali ke Menu Utama");

        int sub = bacaAngkaInt("Pilih menu anggota: ");
        switch (sub) {
            case 1:
                String idA = bacaTeks("ID Anggota: ");
                String namaA = bacaTeks("Nama Anggota: ");
                String emailA = bacaTeks("Email Anggota: ");
                if (pengelola.tambahAnggota(new Anggota(idA, namaA, emailA))) {
                    System.out.println("Berhasil menambahkan anggota: " + namaA);
                }
                break;
            case 2:
                pengelola.tampilkanSemuaAnggota();
                break;
            case 3:
                String idU = bacaTeks("ID Anggota yang akan diubah: ");
                Anggota aU = pengelola.cariAnggota(idU);
                if (aU == null) {
                    System.out.println("Anggota tidak ditemukan!");
                    break;
                }
                String nBaru = bacaTeks("Nama Baru: ");
                String eBaru = bacaTeks("Email Baru: ");
                pengelola.updateAnggota(idU, nBaru, eBaru);
                break;
            case 4:
                String idH = bacaTeks("ID Anggota yang akan dihapus: ");
                pengelola.hapusAnggota(idH);
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan sub-menu tidak valid!");
                break;
        }
    }

    private static void menuPencarian() {
        System.out.println("\n--- MENU PENCARIAN DATA ---");
        System.out.println("1. Cari Buku Berdasarkan Kode");
        System.out.println("2. Cari Buku Berdasarkan Judul");
        System.out.println("3. Cari Buku Berdasarkan Kategori");
        System.out.println("4. Cari Anggota Berdasarkan Nama");
        System.out.println("0. Kembali ke Menu Utama");

        int sub = bacaAngkaInt("Pilih menu pencarian: ");
        switch (sub) {
            case 1:
                String kode = bacaTeks("Masukkan Kode Buku: ");
                ItemPerpustakaan b = pengelola.cariBuku(kode);
                if (b != null) {
                    System.out.println("\nHasil Pencarian Kode:");
                    b.tampilkanDetail();
                } else {
                    System.out.println("Buku dengan kode '" + kode + "' tidak ditemukan.");
                }
                break;
            case 2:
                String kwJudul = bacaTeks("Masukkan Kata Kunci Judul Buku: ");
                ArrayList<ItemPerpustakaan> hasilJudul = pengelola.cariBuku(kwJudul, true);
                if (hasilJudul.isEmpty()) {
                    System.out.println("Tidak ada buku yang cocok dengan judul '" + kwJudul + "'.");
                } else {
                    System.out.println("\nHasil Pencarian Judul:");
                    for (int i = 0; i < hasilJudul.size(); i++) {
                        hasilJudul.get(i).tampilkanDetail();
                    }
                }
                break;
            case 3:
                String kwKat = bacaTeks("Masukkan Kata Kunci Kategori Buku: ");
                ArrayList<ItemPerpustakaan> hasilKat = pengelola.cariBuku(kwKat, false);
                if (hasilKat.isEmpty()) {
                    System.out.println("Tidak ada buku yang cocok dengan kategori '" + kwKat + "'.");
                } else {
                    System.out.println("\nHasil Pencarian Kategori:");
                    for (int i = 0; i < hasilKat.size(); i++) {
                        hasilKat.get(i).tampilkanDetail();
                    }
                }
                break;
            case 4:
                String kwNama = bacaTeks("Masukkan Kata Kunci Nama Anggota: ");
                ArrayList<Anggota> hasilAnggota = pengelola.cariAnggotaBerdasarNama(kwNama);
                if (hasilAnggota.isEmpty()) {
                    System.out.println("Tidak ada anggota yang cocok dengan nama '" + kwNama + "'.");
                } else {
                    System.out.println("\nHasil Pencarian Anggota:");
                    for (int i = 0; i < hasilAnggota.size(); i++) {
                        hasilAnggota.get(i).tampilkanDetail();
                    }
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan sub-menu tidak valid!");
                break;
        }
    }

    private static void menuPeminjaman() {
        System.out.println("\n--- PEMINJAMAN BUKU ---");
        String idA = bacaTeks("ID Anggota Peminjam: ");
        String kodeB = bacaTeks("Kode Buku: ");
        int lama = bacaAngkaInt("Lama Pinjam (Hari): ");

        pengelola.pinjamBuku(idA, kodeB, lama);
    }

    private static void menuPengembalian() {
        System.out.println("\n--- PENGEMBALIAN BUKU ---");
        String idTrx = bacaTeks("ID Transaksi Peminjaman (misal TRX1): ");
        int riil = bacaAngkaInt("Lama Pemakaian Riil (Hari): ");

        pengelola.kembalikanBuku(idTrx, riil);
    }
}
