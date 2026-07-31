public abstract class Kendaraan {

    protected String noPolisi;
    protected String merk;
    protected String model;
    protected int tahun;
    protected double hargaSewaHarian;

    public Kendaraan(String noPolisi, String merk, String model, int tahun, double hargaSewaHarian) {
        this.noPolisi = noPolisi;
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.hargaSewaHarian = hargaSewaHarian;
    }

    public abstract double hitungBiayaSewa(int jumlahHari);

    public abstract String getKategori();

    public void tampilkanInfo() {
        System.out.println("-------------------------------------------");
        System.out.println("No. Polisi   : " + noPolisi);
        System.out.println("Merk/Model   : " + merk + " " + model);
        System.out.println("Tahun        : " + tahun);
        System.out.println("Kategori     : " + getKategori());
        System.out.println("Harga Sewa/Hari : Rp" + String.format("%,.0f", hargaSewaHarian));
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public String getMerk() {
        return merk;
    }

    public String getModel() {
        return model;
    }
}
