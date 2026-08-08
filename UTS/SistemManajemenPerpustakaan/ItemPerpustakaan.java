public abstract class ItemPerpustakaan implements Identitas {
    private String kode;
    private String judul;
    private String kategori;
    private boolean isDipinjam;

    public ItemPerpustakaan(String kode, String judul, String kategori) {
        this.kode = kode;
        this.judul = judul;
        this.kategori = kategori;
        this.isDipinjam = false;
    }

    @Override
    public String getId() {
        return this.kode;
    }

    public abstract double hitungDenda(int hariTerlambat);

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public boolean isDipinjam() {
        return isDipinjam;
    }

    public void setDipinjam(boolean status) {
        this.isDipinjam = status;
    }
}
