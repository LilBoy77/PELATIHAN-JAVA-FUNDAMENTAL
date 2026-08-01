public class Majalah extends ItemPerpustakaan implements BisaDiPinjam {

    private int edisi;
    private boolean sedangDipinjam;
    private String peminjamSaatIni;

    public Majalah(String judul, String kodeItem, int edisi) {
        super(judul, kodeItem);
        this.edisi = edisi;
        this.sedangDipinjam = false;
    }

    @Override
    public void tampilkanKategori() {
        System.out.println("Kategori  : Majalah (Edisi ke-" + edisi + ")");
    }

    @Override
    public void pinjam(String namaPeminjam) {
        if (!sedangDipinjam) {
            sedangDipinjam = true;
            peminjamSaatIni = namaPeminjam;
            System.out.println(namaPeminjam + " berhasil meminjam majalah \"" + judul + "\" (Edisi " + edisi + ")");
        } else {
            System.out.println("Maaf, majalah \"" + judul + "\" sedang dipinjam oleh " + peminjamSaatIni);
        }
    }

    @Override
    public void kembalikan() {
        if (sedangDipinjam) {
            System.out.println(peminjamSaatIni + " mengembalikan majalah \"" + judul + "\"");
            sedangDipinjam = false;
            peminjamSaatIni = null;
        } else {
            System.out.println("Majalah \"" + judul + "\" tidak sedang dipinjam siapa pun.");
        }
    }
}
