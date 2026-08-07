package perpustakaan.model;

public class Majalah extends Pustaka {

    private int edisi;
    private String bulanTerbit;

    public Majalah(String kode, String judul, int tahunTerbit, int stok,
                   int edisi, String bulanTerbit) {
        super(kode, judul, tahunTerbit, stok);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
    }

    public int getEdisi() {
        return this.edisi;
    }

    public void setEdisi(int edisi) {
        if (edisi > 0) {
            this.edisi = edisi;
        }
    }

    public String getBulanTerbit() {
        return this.bulanTerbit;
    }

    public void setBulanTerbit(String bulanTerbit) {
        this.bulanTerbit = bulanTerbit;
    }

    @Override
    public String getJenis() {
        return "Majalah";
    }

    @Override
    public String infoTambahan() {
        return "Edisi ke-" + this.edisi + " | Terbit: " + this.bulanTerbit;
    }

    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | " + this.infoTambahan();
    }

    @Override
    public boolean pinjam() {
        if (this.getStok() > 1) {
            this.setStok(this.getStok() - 1);
            return true;
        }
        return false;
    }
}
