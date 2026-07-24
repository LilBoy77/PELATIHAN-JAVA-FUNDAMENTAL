public class Motor extends Kendaraan {
    private String tipe;

    public Motor() {
    }

    public Motor(String kode, String merk, String warna, double harga, String tipe) {
        super(kode, merk, warna, harga);
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public void tampilInfo() {
        System.out.println("=== Data MOTOR ===");
        super.tampilInfo();
        System.out.println("Tipe           : " + tipe);
    }

    @Override
    public String getJenis() {
        return "Motor";
    }
}