package perpustakaan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import perpustakaan.model.Pustaka;

public class Perpustakaan {

    private String namaPerpustakaan;
    private ArrayList<Pustaka> daftarPustaka;
    private HashMap<String, ArrayList<String>> dataPeminjaman;

    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.daftarPustaka = new ArrayList<>();
        this.dataPeminjaman = new HashMap<>();
    }

    public String getNamaPerpustakaan() {
        return this.namaPerpustakaan;
    }

    public void setNamaPerpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
    }

    public ArrayList<Pustaka> getDaftarPustaka() {
        return this.daftarPustaka;
    }

    public boolean tambah(Pustaka pustaka) {
        if (pustaka == null || this.cariByKode(pustaka.getKode()) != null) {
            return false;
        }
        this.daftarPustaka.add(pustaka);
        return true;
    }

    public Pustaka cariByKode(String kode) {
        for (Pustaka p : this.daftarPustaka) {
            if (p.getKode().equalsIgnoreCase(kode)) {
                return p;
            }
        }
        return null;
    }

    public void tampilkanSemua() {
        this.cetakTabel(this.daftarPustaka, "SELURUH KOLEKSI");
    }

    public void tampilkanSemua(String jenis) {
        ArrayList<Pustaka> hasil = new ArrayList<>();
        for (Pustaka p : this.daftarPustaka) {
            if (p.getJenis().equalsIgnoreCase(jenis)) {
                hasil.add(p);
            }
        }
        this.cetakTabel(hasil, "KOLEKSI JENIS: " + jenis.toUpperCase());
    }

    public void tampilkanSemua(boolean hanyaTersedia) {
        ArrayList<Pustaka> hasil = new ArrayList<>();
        for (Pustaka p : this.daftarPustaka) {
            if (!hanyaTersedia || p.isTersedia()) {
                hasil.add(p);
            }
        }
        this.cetakTabel(hasil, hanyaTersedia ? "KOLEKSI TERSEDIA" : "SELURUH KOLEKSI");
    }

    public ArrayList<Pustaka> cari(String judul) {
        ArrayList<Pustaka> hasil = new ArrayList<>();
        for (Pustaka p : this.daftarPustaka) {
            if (p.getJudul().toLowerCase().contains(judul.toLowerCase())) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Pustaka> cari(int tahunTerbit) {
        ArrayList<Pustaka> hasil = new ArrayList<>();
        for (Pustaka p : this.daftarPustaka) {
            if (p.getTahunTerbit() == tahunTerbit) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public ArrayList<Pustaka> cari(String judul, int tahunTerbit) {
        ArrayList<Pustaka> hasil = new ArrayList<>();
        for (Pustaka p : this.cari(judul)) {
            if (p.getTahunTerbit() == tahunTerbit) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    public boolean ubahJudul(String kode, String judulBaru) {
        Pustaka p = this.cariByKode(kode);
        if (p == null) {
            return false;
        }
        p.setJudul(judulBaru);
        return true;
    }

    public boolean ubahTahun(String kode, int tahunBaru) {
        Pustaka p = this.cariByKode(kode);
        if (p == null) {
            return false;
        }
        p.setTahunTerbit(tahunBaru);
        return true;
    }

    public boolean ubahStok(String kode, int stokBaru) {
        Pustaka p = this.cariByKode(kode);
        if (p == null || stokBaru < 0) {
            return false;
        }
        p.setStok(stokBaru);
        return true;
    }

    public boolean hapus(String kode) {
        Pustaka p = this.cariByKode(kode);
        if (p == null) {
            return false;
        }
        this.daftarPustaka.remove(p);
        this.dataPeminjaman.remove(p.getKode().toUpperCase());
        return true;
    }

    public String pinjam(String kode, String namaPeminjam) {
        Pustaka p = this.cariByKode(kode);
        if (p == null) {
            return "Kode " + kode + " tidak ditemukan.";
        }
        if (!p.pinjam()) {
            return "Maaf, \"" + p.getJudul() + "\" sedang tidak tersedia.";
        }
        String key = p.getKode().toUpperCase();
        ArrayList<String> peminjam = this.dataPeminjaman.get(key);
        if (peminjam == null) {
            peminjam = new ArrayList<>();
            this.dataPeminjaman.put(key, peminjam);
        }
        peminjam.add(namaPeminjam);
        return namaPeminjam + " berhasil meminjam \"" + p.getJudul()
                + "\". Sisa stok: " + p.getStok();
    }

    public String kembalikan(String kode, String namaPeminjam) {
        Pustaka p = this.cariByKode(kode);
        if (p == null) {
            return "Kode " + kode + " tidak ditemukan.";
        }
        String key = p.getKode().toUpperCase();
        ArrayList<String> peminjam = this.dataPeminjaman.get(key);
        if (peminjam == null || !peminjam.remove(namaPeminjam)) {
            return "Tidak ada catatan peminjaman atas nama " + namaPeminjam + ".";
        }
        p.kembalikan();
        if (peminjam.isEmpty()) {
            this.dataPeminjaman.remove(key);
        }
        return "Terima kasih " + namaPeminjam + ", \"" + p.getJudul()
                + "\" telah dikembalikan. Stok: " + p.getStok();
    }

    public void tampilkanPeminjaman() {
        System.out.println("\n=== DATA PEMINJAMAN AKTIF ===");
        if (this.dataPeminjaman.isEmpty()) {
            System.out.println("(belum ada peminjaman)");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : this.dataPeminjaman.entrySet()) {
            Pustaka p = this.cariByKode(entry.getKey());
            String judul = (p == null) ? "-" : p.getJudul();
            System.out.println(entry.getKey() + " | " + judul + " -> " + entry.getValue());
        }
    }

    public void tampilkanStatistik() {
        HashMap<String, Integer> statistik = new HashMap<>();
        int totalStok = 0;
        for (Pustaka p : this.daftarPustaka) {
            String jenis = p.getJenis();
            int jumlah = statistik.containsKey(jenis) ? statistik.get(jenis) : 0;
            statistik.put(jenis, jumlah + 1);
            totalStok += p.getStok();
        }
        System.out.println("\n=== STATISTIK " + this.namaPerpustakaan.toUpperCase() + " ===");
        System.out.println("Total judul : " + this.daftarPustaka.size());
        System.out.println("Total stok  : " + totalStok);
        for (Map.Entry<String, Integer> entry : statistik.entrySet()) {
            System.out.println("Jenis " + entry.getKey() + " : " + entry.getValue() + " judul");
        }
    }

    private void cetakTabel(ArrayList<Pustaka> data, String judulTabel) {
        System.out.println("\n=== " + judulTabel + " ===");
        if (data.isEmpty()) {
            System.out.println("(data kosong)");
            return;
        }
        int nomor = 1;
        for (Pustaka p : data) {
            System.out.println(nomor + ". " + p.tampilkanInfo());
            nomor++;
        }
        System.out.println("Total: " + data.size() + " item");
    }
}
