public abstract class ItemPerpustakaan {

    protected String judul;
    protected String kodeItem;

    public ItemPerpustakaan(String judul, String kodeItem) {
        this.judul = judul;
        this.kodeItem = kodeItem;
    }

    public abstract void tampilkanKategori();

    public void tampilkanInfoUmum() {
        System.out.println("Kode Item : " + kodeItem);
        System.out.println("Judul     : " + judul);
    }

    public double hitungDenda(int hariTerlambat) {
        return hariTerlambat * 1000;
    }

    public double hitungDenda(int hariTerlambat, double tarifPerHari) {
        return hariTerlambat * tarifPerHari;
    }
}
