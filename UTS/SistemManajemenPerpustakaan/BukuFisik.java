public class BukuFisik extends ItemPerpustakaan {
    private String lokasiRak;

    public BukuFisik(String kode, String judul, String kategori, String lokasiRak) {
        super(kode, judul, kategori);
        this.lokasiRak = lokasiRak;
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }

    @Override
    public double hitungDenda(int hariTerlambat) {
        if (hariTerlambat <= 0) {
            return 0.0;
        }
        return hariTerlambat * 2000.0;
    }

    @Override
    public void tampilkanDetail() {
        String status = isDipinjam() ? "Dipinjam" : "Tersedia";
        System.out.println("[Buku Fisik] Kode: " + getKode() + 
                " | Judul: " + getJudul() + 
                " | Kategori: " + getKategori() + 
                " | Rak: " + lokasiRak + 
                " | Status: " + status);
    }
}
