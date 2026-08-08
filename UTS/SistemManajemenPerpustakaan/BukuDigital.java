public class BukuDigital extends ItemPerpustakaan {
    private double ukuranBerkas;

    public BukuDigital(String kode, String judul, String kategori, double ukuranBerkas) {
        super(kode, judul, kategori);
        this.ukuranBerkas = ukuranBerkas;
    }

    public double getUkuranBerkas() {
        return ukuranBerkas;
    }

    public void setUkuranBerkas(double ukuranBerkas) {
        this.ukuranBerkas = ukuranBerkas;
    }

    @Override
    public double hitungDenda(int hariTerlambat) {
        if (hariTerlambat <= 0) {
            return 0.0;
        }
        return hariTerlambat * 1000.0;
    }

    @Override
    public void tampilkanDetail() {
        String status = isDipinjam() ? "Dipinjam" : "Tersedia";
        System.out.printf("[Buku Digital] Kode: %s | Judul: %s | Kategori: %s | Ukuran: %.2f MB | Status: %s\n",
                getKode(), getJudul(), getKategori(), ukuranBerkas, status);
    }
}
