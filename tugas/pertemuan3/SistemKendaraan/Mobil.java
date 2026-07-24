public class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil() {
    }

    public Mobil(String kode, String merk, String warna, double harga, int jumlahPintu) {
        super(kode, merk, warna, harga);
        this.jumlahPintu = jumlahPintu;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public void tampilInfo() {
        System.out.println("=== Data MOBIL ===");
        super.tampilInfo();
        System.out.println("Jumlah Pintu   : " + jumlahPintu);
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }
}