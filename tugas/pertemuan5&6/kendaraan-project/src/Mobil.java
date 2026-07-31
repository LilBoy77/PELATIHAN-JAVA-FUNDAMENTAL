public class Mobil extends Kendaraan implements Perawatan {

    private int jumlahKursi;
    private boolean statusServis; 
    private String tanggalServisBerikutnya;

    public Mobil(String noPolisi, String merk, String model, int tahun, double hargaSewaHarian, int jumlahKursi) {
        super(noPolisi, merk, model, tahun, hargaSewaHarian);
        this.jumlahKursi = jumlahKursi;
        this.statusServis = false;
        this.tanggalServisBerikutnya = "-";
    }

    @Override
    public double hitungBiayaSewa(int jumlahHari) {
        return jumlahHari * hargaSewaHarian;
    }

    @Override
    public String getKategori() {
        return "Mobil";
    }

    public double hitungBiayaSewa(int jumlahHari, double diskonPersen) {
        double totalNormal = hitungBiayaSewa(jumlahHari);
        return totalNormal - (totalNormal * diskonPersen / 100);
    }

    public double hitungBiayaSewa(int jumlahHari, boolean pakaiSupir) {
        double totalNormal = hitungBiayaSewa(jumlahHari);
        if (pakaiSupir) {
            double biayaSupirPerHari = 150000;
            totalNormal += jumlahHari * biayaSupirPerHari;
        }
        return totalNormal;
    }

    @Override
    public void jadwalkanServis(String tanggal) {
        this.statusServis = true;
        this.tanggalServisBerikutnya = tanggal;
        System.out.println("Mobil " + noPolisi + " dijadwalkan servis pada " + tanggal);
    }

    @Override
    public void cekKondisi() {
        System.out.println("Kondisi Mobil " + noPolisi + ": "
                + (statusServis ? "Sudah dijadwalkan servis (" + tanggalServisBerikutnya + ")"
                                : "Belum dijadwalkan servis, kondisi standar"));
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jumlah Kursi : " + jumlahKursi);
    }
}
