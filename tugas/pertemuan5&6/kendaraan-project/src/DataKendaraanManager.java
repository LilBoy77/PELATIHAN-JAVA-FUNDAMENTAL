import java.util.ArrayList;

public class DataKendaraanManager {

    private ArrayList<Kendaraan> daftarKendaraan;

    public DataKendaraanManager() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
        System.out.println("Data kendaraan " + k.getNoPolisi() + " berhasil ditambahkan.");
    }

    public boolean hapusKendaraan(String noPolisi) {
        Kendaraan target = cariKendaraan(noPolisi);
        if (target != null) {
            daftarKendaraan.remove(target);
            System.out.println("Data kendaraan " + noPolisi + " berhasil dihapus.");
            return true;
        }
        System.out.println("Data kendaraan dengan No. Polisi " + noPolisi + " tidak ditemukan.");
        return false;
    }

    public Kendaraan cariKendaraan(String noPolisi) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getNoPolisi().equalsIgnoreCase(noPolisi)) {
                return k;
            }
        }
        return null;
    }

    public void tampilkanSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }
        for (Kendaraan k : daftarKendaraan) {
            k.tampilkanInfo(); 
        }
        System.out.println("-------------------------------------------");
    }

    public void jadwalkanServisSemua(String tanggal) {
        for (Kendaraan k : daftarKendaraan) {
            if (k instanceof Perawatan) {
                ((Perawatan) k).jadwalkanServis(tanggal);
            }
        }
    }

    public void cekKondisiSemua() {
        for (Kendaraan k : daftarKendaraan) {
            if (k instanceof Perawatan) {
                ((Perawatan) k).cekKondisi();
            }
        }
    }

    public int getJumlahKendaraan() {
        return daftarKendaraan.size();
    }
}
