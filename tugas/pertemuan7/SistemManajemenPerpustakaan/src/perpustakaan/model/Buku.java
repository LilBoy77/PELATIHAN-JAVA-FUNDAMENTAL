package perpustakaan.model;

public class Buku extends Pustaka {

    private String penulis;
    private String penerbit;
    private int jumlahHalaman;

    public Buku(String kode, String judul, int tahunTerbit, int stok,
                String penulis, String penerbit, int jumlahHalaman) {
        super(kode, judul, tahunTerbit, stok);
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return this.penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getJumlahHalaman() {
        return this.jumlahHalaman;
    }

    public void setJumlahHalaman(int jumlahHalaman) {
        if (jumlahHalaman > 0) {
            this.jumlahHalaman = jumlahHalaman;
        }
    }

    @Override
    public String getJenis() {
        return "Buku";
    }

    @Override
    public String infoTambahan() {
        return "Penulis: " + this.penulis + " | Penerbit: " + this.penerbit
                + " | " + this.jumlahHalaman + " hlm";
    }

    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | " + this.infoTambahan();
    }
}
