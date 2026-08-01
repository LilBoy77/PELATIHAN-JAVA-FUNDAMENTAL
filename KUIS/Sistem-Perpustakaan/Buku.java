public class Buku extends ItemPerpustakaan implements BisaDiPinjam {

    private String penulis;
    private boolean sedangDipinjam;
    private String peminjamSaatIni;

    public Buku(String judul, String kodeItem, String penulis) {
        super(judul, kodeItem);
        this.penulis = penulis;
        this.sedangDipinjam = false;
    }

    @Override
    public void tampilkanKategori() {
        System.out.println("Kategori  : Buku (Penulis: " + penulis + ")");
    }

    @Override
    public void pinjam(String namaPeminjam) {
        if (!sedangDipinjam) {
            sedangDipinjam = true;
            peminjamSaatIni = namaPeminjam;
            System.out.println(namaPeminjam + " berhasil meminjam buku \"" + judul + "\"");
        } else {
            System.out.println("Maaf, buku \"" + judul + "\" sedang dipinjam oleh " + peminjamSaatIni);
        }
    }

    @Override
    public void kembalikan() {
        if (sedangDipinjam) {
            System.out.println(peminjamSaatIni + " mengembalikan buku \"" + judul + "\"");
            sedangDipinjam = false;
            peminjamSaatIni = null;
        } else {
            System.out.println("Buku \"" + judul + "\" tidak sedang dipinjam siapa pun.");
        }
    }
}
