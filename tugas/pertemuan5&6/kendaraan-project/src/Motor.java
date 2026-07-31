public class Motor extends Kendaraan implements Perawatan {

    private String tipeMotor; 
    private boolean statusServis;
    private String tanggalServisBerikutnya;

    public Motor(String noPolisi, String merk, String model, int tahun, double hargaSewaHarian, String tipeMotor) {
        super(noPolisi, merk, model, tahun, hargaSewaHarian);
        this.tipeMotor = tipeMotor;
        this.statusServis = false;
        this.tanggalServisBerikutnya = "-";
    }

    @Override
    public double hitungBiayaSewa(int jumlahHari) {
        return jumlahHari * hargaSewaHarian;
    }

    @Override
    public String getKategori() {
        return "Motor";
    }

    public double hitungBiayaSewa(int jumlahHari, boolean sewaMingguan) {
        double totalNormal = hitungBiayaSewa(jumlahHari);
        if (sewaMingguan && jumlahHari >= 7) {
            totalNormal -= totalNormal * 0.10;
        }
        return totalNormal;
    }

    @Override
    public void jadwalkanServis(String tanggal) {
        this.statusServis = true;
        this.tanggalServisBerikutnya = tanggal;
        System.out.println("Motor " + noPolisi + " dijadwalkan servis pada " + tanggal);
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi Motor " + noPolisi + ": "
                + (statusServis ? "Sudah dijadwalkan servis (" + tanggalServisBerikutnya + ")"
                                : "Belum dijadwalkan servis, kondisi standar"));
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Motor   : " + tipeMotor);
    }
}
