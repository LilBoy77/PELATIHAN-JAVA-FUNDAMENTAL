package perpustakaan.model;

import perpustakaan.service.Dipinjamkan;

public abstract class Pustaka implements Dipinjamkan {

    private String kode;
    private String judul;
    private int tahunTerbit;
    private int stok;

    public Pustaka(String kode, String judul, int tahunTerbit, int stok) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
    }

    public String getKode() {
        return this.kode;
    }

    public void setKode(String kode) {
        if (kode != null && !kode.trim().isEmpty()) {
            this.kode = kode.toUpperCase();
        }
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            this.judul = judul;
        }
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit > 1000) {
            this.tahunTerbit = tahunTerbit;
        }
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public abstract String getJenis();

    public abstract String infoTambahan();

    public String tampilkanInfo() {
        return String.format("[%s] %-28s | %-8s | Tahun: %d | Stok: %d",
                this.kode, this.judul, this.getJenis(), this.tahunTerbit, this.stok);
    }

    @Override
    public boolean pinjam() {
        if (this.stok > 0) {
            this.stok--;
            return true;
        }
        return false;
    }

    @Override
    public boolean kembalikan() {
        this.stok++;
        return true;
    }

    @Override
    public boolean isTersedia() {
        return this.stok > 0;
    }
}
