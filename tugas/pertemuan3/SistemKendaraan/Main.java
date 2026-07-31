import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    static HashMap<String, Integer> kategori = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        kategori.put("Mobil", 0);
        kategori.put("Motor", 0);

        tambahKeList(new Mobil("M001", "Toyota Avanza", "Hitam", 250000000, 4));
        tambahKeList(new Motor("K001", "Honda Beat", "Merah", 18000000, "Matic"));

        int pilihan;
        do {
            tampilMenu();
            pilihan = bacaInt("Pilih menu (0-7): ");
            System.out.println();
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    ubahData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    cariData();
                    break;
                case 6:
                    tampilStatistik();
                    break;
                case 7:
                    lihatDetail();
                    break;
                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
            System.out.println();
        } while (pilihan != 0);
    }

    static void tampilMenu() {
        System.out.println("========================================");
        System.out.println("     SISTEM MANAJEMEN DATA KENDARAAN");
        System.out.println("========================================");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Lihat Seluruh Data");
        System.out.println("3. Ubah Data Kendaraan");
        System.out.println("4. Hapus Data Kendaraan");
        System.out.println("5. Cari Kendaraan (kode/merk)");
        System.out.println("6. Statistik Kendaraan");
        System.out.println("7. Lihat Detail (per nomor)");
        System.out.println("0. Keluar");
        System.out.println("========================================");
    }

    static void tambahKeList(Kendaraan k) {
        daftarKendaraan.add(k);
        kategori.put(k.getJenis(), kategori.getOrDefault(k.getJenis(), 0) + 1);
    }

    static void tambahData() {
        System.out.println("--- Tambah Data Kendaraan ---");
        System.out.println("Pilih jenis: 1. Mobil  2. Motor");
        int jenis = bacaInt("Jenis: ");
        if (jenis != 1 && jenis != 2) {
            System.out.println("Jenis tidak valid!");
            return;
        }
        String kode = bacaKodeUnik("Kode Kendaraan: ");
        String merk = bacaString("Merk: ");
        String warna = bacaString("Warna: ");
        double harga = bacaDouble("Harga: ");

        if (jenis == 1) {
            int pintu = bacaInt("Jumlah Pintu: ");
            tambahKeList(new Mobil(kode, merk, warna, harga, pintu));
        } else {
            String tipe = bacaString("Tipe (Matic/Manual): ");
            tambahKeList(new Motor(kode, merk, warna, harga, tipe));
        }
        System.out.println("Data berhasil ditambahkan!");
    }

    static void lihatData() {
        System.out.println("--- Daftar Seluruh Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("(Belum ada data)");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println("\nData ke-" + (i + 1));
            daftarKendaraan.get(i).tampilInfo();
        }
    }

    static int cariIndexByKode(String kode) {
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            if (daftarKendaraan.get(i).getKodeKendaraan().equalsIgnoreCase(kode)) {
                return i;
            }
        }
        return -1;
    }

    static void ubahData() {
        System.out.println("--- Ubah Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("(Belum ada data)");
            return;
        }
        String kode = bacaString("Masukkan kode kendaraan yang akan diubah: ");
        int idx = cariIndexByKode(kode);
        if (idx == -1) {
            System.out.println("Data tidak ditemukan!");
            return;
        }
        Kendaraan k = daftarKendaraan.get(idx);
        System.out.println("Data saat ini:");
        k.tampilInfo();
        System.out.println("\nMasukkan data baru:");
        k.setMerk(bacaString("Merk baru: "));
        k.setWarna(bacaString("Warna baru: "));
        k.setHarga(bacaDouble("Harga baru: "));
        if (k instanceof Mobil) {
            ((Mobil) k).setJumlahPintu(bacaInt("Jumlah Pintu baru: "));
        } else if (k instanceof Motor) {
            ((Motor) k).setTipe(bacaString("Tipe baru: "));
        }
        System.out.println("Data berhasil diubah!");
    }

    static void hapusData() {
        System.out.println("--- Hapus Data Kendaraan ---");
        if (daftarKendaraan.isEmpty()){
            System.out.println("(Belum ada data)");
            return;
        }
        String kode = bacaString("Masukkan kode kendaraan yang akan dihapus: ");
        int idx = cariIndexByKode(kode);
        if (idx == -1) {
            System.out.println("Data tidak ditemukan!");
            return;
        }
        Kendaraan k = daftarKendaraan.remove(idx);
        kategori.put(k.getJenis(), kategori.get(k.getJenis()) - 1);
        System.out.println("Data dengan kode " + kode + " berhasil dihapus!");
    }

    static void cariData() {
        System.out.println("--- Cari Kendaraan ---");
        String kata = bacaString("Masukkan kode / merk: ").toLowerCase();
        boolean ketemu = false;
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            Kendaraan k = daftarKendaraan.get(i);
            if (k.getKodeKendaraan().toLowerCase().contains(kata)
                    || k.getMerk().toLowerCase().contains(kata)) {
                System.out.println("\nData ke-" + (i + 1));
                k.tampilInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Tidak ada kendaraan yang cocok.");
        }
    }

    static void tampilStatistik() {
        System.out.println("--- Statistik Kendaraan ---");
        System.out.println("Total kendaraan : " + daftarKendaraan.size());
        for (Map.Entry<String, Integer> e : kategori.entrySet()) {
            System.out.println("Jumlah " + e.getKey() + " : " + e.getValue());
        }
        if (!daftarKendaraan.isEmpty()) {
            double total = 0;
            for (Kendaraan k : daftarKendaraan) {
                total += k.getHarga();
            }
            System.out.println("Total harga     : Rp " + String.format("%,.0f", total));
            System.out.println("Rata-rata harga : Rp "
                    + String.format("%,.0f", total / daftarKendaraan.size()));
        }
    }

    static void lihatDetail() {
        System.out.println("--- Lihat Detail Kendaraan ---");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("(Belum ada data)");
            return;
        }
        int no = bacaInt("Masukkan nomor data (1-" + daftarKendaraan.size() + "): ");
        if (no < 1 || no > daftarKendaraan.size()) {
            System.out.println("Nomor tidak valid!");
            return;
        }
        daftarKendaraan.get(no - 1).tampilInfo();
    }

    static String bacaString(String pesan) {
        String input;
        do {
            System.out.print(pesan);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
            }
        } while (input.isEmpty());
        return input;
    }

    static String bacaKodeUnik(String pesan) {
        while (true) {
            String kode = bacaString(pesan);
            if (cariIndexByKode(kode) != -1) {
                System.out.println("Kode sudah dipakai, gunakan kode lain!");
            } else {
                return kode;
            }
        }
    }

    static int bacaInt(String pesan) {
        while (true) {
            System.out.print(pesan);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }

    static double bacaDouble(String pesan) {
        while (true) {
            System.out.print(pesan);
            String s = scanner.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v < 0) {
                    System.out.println("Nilai tidak boleh negatif!");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
}