public class Main {
    public static void main(String[] args) {

        System.out.println("SISTEM PERPUSTAKAAN");

        Buku buku = new Buku("Laskar Pelangi", "BK-001", "Andrea Hirata");
        Majalah majalah = new Majalah("National Geographic", "MJ-001", 245);

        System.out.println("--- Data Buku ---");
        buku.tampilkanInfoUmum();
        buku.tampilkanKategori();
        System.out.println();

        System.out.println("--- Data Majalah ---");
        majalah.tampilkanInfoUmum();
        majalah.tampilkanKategori();
        System.out.println();

        System.out.println("--- Simulasi Peminjaman ---");
        buku.pinjam("Andi");
        buku.pinjam("Budi");
        majalah.pinjam("Citra");
        buku.kembalikan();
        majalah.kembalikan();
        System.out.println();

        System.out.println("--- Simulasi Denda Keterlambatan ---");
        int hariTerlambat = 5;

        double denda1 = buku.hitungDenda(hariTerlambat);
        System.out.println("Denda buku (tarif default)      : Rp" + denda1);

        double denda2 = majalah.hitungDenda(hariTerlambat, 2000);
        System.out.println("Denda majalah (tarif Rp2000/hari): Rp" + denda2);

        System.out.println("\n--- Semua Item (Polimorfisme) ---");
        ItemPerpustakaan[] semuaItem = { buku, majalah };
        for (ItemPerpustakaan item : semuaItem) {
            item.tampilkanKategori();
        }
    }
}
