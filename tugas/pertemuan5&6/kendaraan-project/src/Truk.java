public class Truk extends Kendaraan implements Perawatan {

    private double kapasitasMuatanTon;
    private boolean statusServis;
    private String tanggalServisBerikutnya;

    public Truk(String noPolisi, String merk, String model, int tahun, double hargaSewaHarian, double kapasitasMuatanTon) {
        super(noPolisi, merk, model, tahun, hargaSewaHarian);
        this.kapasitasMuatanTon = kapasitasMuatanTon;
        this.statusServis = false;
        this.tanggalServisBerikutnya = "-";
    }

    @Override
    public double hitungBiayaSewa(int jumlahHari) {
        return jumlahHari * hargaSewaHarian;
    }

    @Override
    public String getKategori() {
        return "Truk";
    }

    public double hitungBiayaSewa(int jumlahHari, double biayaBahanBakarPerHari) {
        double totalNormal = hitungBiayaSewa(jumlahHari);
        return totalNormal + (jumlahHari * biayaBahanBakarPerHari);
    }

    @Override
    public void jadwalkanServis(String tanggal) {
        this.statusServis = true;
        this.tanggalServisBerikutnya = tanggal;
        System.out.println("Truk " + noPolisi + " dijadwalkan servis pada " + tanggal);
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi Truk " + noPolisi + ": "
                + (statusServis ? "Sudah dijadwalkan servis (" + tanggalServisBerikutnya + ")"
                                : "Belum dijadwalkan servis, kondisi standar"));
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kapasitas Muatan : " + kapasitasMuatanTon + " ton");
    }
}
