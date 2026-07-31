public class Kendaraan {
    private String kodeKendaraan;
    private String merk;
    private String warna;
    private double harga;

    public Kendaraan() {
    }

    public Kendaraan(String kodeKendaraan, String merk, String warna, double harga) {
        this.kodeKendaraan = kodeKendaraan;
        this.merk = merk;
        this.warna = warna;
        this.harga = harga;
    }

    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tampilInfo() {
        System.out.println("Kode Kendaraan : " + kodeKendaraan);
        System.out.println("Merk           : " + merk);
        System.out.println("Warna          : " + warna);
        System.out.println("Harga          : Rp " + String.format("%,.0f", harga));
    }

    public String getJenis() {
        return "Kendaraan";
    }
}
