public class Peminjaman {
    private String idTransaksi;
    private Anggota anggota;
    private ItemPerpustakaan item;
    private int lamaPinjamHari;
    private boolean dikembalikan;

    public Peminjaman(String idTransaksi, Anggota anggota, ItemPerpustakaan item, int lamaPinjamHari) {
        this.idTransaksi = idTransaksi;
        this.anggota = anggota;
        this.item = item;
        this.lamaPinjamHari = lamaPinjamHari;
        this.dikembalikan = false;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public ItemPerpustakaan getItem() {
        return item;
    }

    public int getLamaPinjamHari() {
        return lamaPinjamHari;
    }

    public boolean isDikembalikan() {
        return dikembalikan;
    }

    public void setDikembalikan(boolean dikembalikan) {
        this.dikembalikan = dikembalikan;
    }
}
