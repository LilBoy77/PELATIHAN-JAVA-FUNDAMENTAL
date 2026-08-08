import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PengelolaPerpustakaan {
    private HashMap<String, ItemPerpustakaan> daftarBuku;
    private ArrayList<Anggota> daftarAnggota;
    private ArrayList<Peminjaman> daftarTransaksi;
    private HashMap<String, Integer> jumlahBukuPerKategori;
    private int counterTransaksi;

    public PengelolaPerpustakaan() {
        this.daftarBuku = new HashMap<String, ItemPerpustakaan>();
        this.daftarAnggota = new ArrayList<Anggota>();
        this.daftarTransaksi = new ArrayList<Peminjaman>();
        this.jumlahBukuPerKategori = new HashMap<String, Integer>();
        this.counterTransaksi = 1;
    }

    private void tambahKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            return;
        }
        String key = kategori.trim();
        if (jumlahBukuPerKategori.containsKey(key)) {
            int count = jumlahBukuPerKategori.get(key);
            jumlahBukuPerKategori.put(key, count + 1);
        } else {
            jumlahBukuPerKategori.put(key, 1);
        }
    }

    private void kurangKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            return;
        }
        String key = kategori.trim();
        if (jumlahBukuPerKategori.containsKey(key)) {
            int count = jumlahBukuPerKategori.get(key);
            if (count <= 1) {
                jumlahBukuPerKategori.remove(key);
            } else {
                jumlahBukuPerKategori.put(key, count - 1);
            }
        }
    }

    public boolean tambahBuku(ItemPerpustakaan buku) {
        if (daftarBuku.containsKey(buku.getKode())) {
            System.out.println("Gagal: Kode buku '" + buku.getKode() + "' sudah terdaftar!");
            return false;
        }
        daftarBuku.put(buku.getKode(), buku);
        tambahKategori(buku.getKategori());
        return true;
    }

    public void tampilkanSemuaBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }
        System.out.println("\n=== DAFTAR BUKU PERPUSTAKAAN ===");
        for (ItemPerpustakaan buku : daftarBuku.values()) {
            buku.tampilkanDetail();
        }
    }

    public boolean updateBuku(String kode, String judulBaru, String kategoriBaru) {
        ItemPerpustakaan buku = daftarBuku.get(kode);
        if (buku == null) {
            System.out.println("Gagal: Buku dengan kode '" + kode + "' tidak ditemukan!");
            return false;
        }

        String kategoriLama = buku.getKategori();
        buku.setJudul(judulBaru);
        buku.setKategori(kategoriBaru);

        if (!kategoriLama.equalsIgnoreCase(kategoriBaru)) {
            kurangKategori(kategoriLama);
            tambahKategori(kategoriBaru);
        }

        System.out.println("Berhasil memperbarui data buku '" + kode + "'.");
        return true;
    }

    public boolean hapusBuku(String kode) {
        ItemPerpustakaan buku = daftarBuku.get(kode);
        if (buku == null) {
            System.out.println("Gagal: Buku dengan kode '" + kode + "' tidak ditemukan!");
            return false;
        }

        if (buku.isDipinjam()) {
            System.out.println("Gagal: Buku '" + buku.getJudul() + "' sedang dipinjam dan tidak dapat dihapus!");
            return false;
        }

        daftarBuku.remove(kode);
        kurangKategori(buku.getKategori());
        System.out.println("Berhasil menghapus buku dengan kode '" + kode + "'.");
        return true;
    }

    public ItemPerpustakaan cariBuku(String kode) {
        return daftarBuku.get(kode);
    }

    public ArrayList<ItemPerpustakaan> cariBuku(String keyword, boolean cariBerdasarJudul) {
        ArrayList<ItemPerpustakaan> hasil = new ArrayList<ItemPerpustakaan>();
        String kwLower = keyword.toLowerCase();

        for (ItemPerpustakaan buku : daftarBuku.values()) {
            if (cariBerdasarJudul) {
                if (buku.getJudul().toLowerCase().contains(kwLower)) {
                    hasil.add(buku);
                }
            } else {
                if (buku.getKategori().toLowerCase().contains(kwLower)) {
                    hasil.add(buku);
                }
            }
        }
        return hasil;
    }

    public boolean tambahAnggota(Anggota anggota) {
        if (cariAnggota(anggota.getIdAnggota()) != null) {
            System.out.println("Gagal: ID Anggota '" + anggota.getIdAnggota() + "' sudah terdaftar!");
            return false;
        }
        daftarAnggota.add(anggota);
        return true;
    }

    public Anggota cariAnggota(String idAnggota) {
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota a = daftarAnggota.get(i);
            if (a.getIdAnggota().equalsIgnoreCase(idAnggota)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Anggota> cariAnggotaBerdasarNama(String keyword) {
        ArrayList<Anggota> hasil = new ArrayList<Anggota>();
        String kwLower = keyword.toLowerCase();
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota a = daftarAnggota.get(i);
            if (a.getNama().toLowerCase().contains(kwLower)) {
                hasil.add(a);
            }
        }
        return hasil;
    }

    public void tampilkanSemuaAnggota() {
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }
        System.out.println("\n=== DAFTAR ANGGOTA PERPUSTAKAAN ===");
        for (int i = 0; i < daftarAnggota.size(); i++) {
            daftarAnggota.get(i).tampilkanDetail();
        }
    }

    public boolean updateAnggota(String id, String namaBaru, String emailBaru) {
        Anggota anggota = cariAnggota(id);
        if (anggota == null) {
            System.out.println("Gagal: Anggota dengan ID '" + id + "' tidak ditemukan!");
            return false;
        }
        anggota.setNama(namaBaru);
        anggota.setEmail(emailBaru);
        System.out.println("Berhasil memperbarui data anggota '" + id + "'.");
        return true;
    }

    public boolean hapusAnggota(String id) {
        Anggota anggota = cariAnggota(id);
        if (anggota == null) {
            System.out.println("Gagal: Anggota dengan ID '" + id + "' tidak ditemukan!");
            return false;
        }

        for (int i = 0; i < daftarTransaksi.size(); i++) {
            Peminjaman p = daftarTransaksi.get(i);
            if (p.getAnggota().getIdAnggota().equalsIgnoreCase(id) && !p.isDikembalikan()) {
                System.out.println("Gagal: Anggota '" + anggota.getNama() + "' masih memiliki peminjaman aktif (ID Transaksi: " + p.getIdTransaksi() + ")!");
                return false;
            }
        }

        daftarAnggota.remove(anggota);
        System.out.println("Berhasil menghapus anggota dengan ID '" + id + "'.");
        return true;
    }

    public boolean pinjamBuku(String idAnggota, String kodeBuku, int lamaPinjamHari) {
        Anggota anggota = cariAnggota(idAnggota);
        if (anggota == null) {
            System.out.println("Gagal: Anggota dengan ID '" + idAnggota + "' tidak terdaftar!");
            return false;
        }

        ItemPerpustakaan buku = cariBuku(kodeBuku);
        if (buku == null) {
            System.out.println("Gagal: Buku dengan kode '" + kodeBuku + "' tidak ditemukan!");
            return false;
        }

        if (buku.isDipinjam()) {
            System.out.println("Gagal: Buku '" + buku.getJudul() + "' sedang dipinjam oleh anggota lain!");
            return false;
        }

        if (lamaPinjamHari <= 0) {
            System.out.println("Gagal: Lama peminjaman harus lebih dari 0 hari!");
            return false;
        }

        String idTransaksi = "TRX" + counterTransaksi;
        counterTransaksi++;

        buku.setDipinjam(true);
        Peminjaman transaksi = new Peminjaman(idTransaksi, anggota, buku, lamaPinjamHari);
        daftarTransaksi.add(transaksi);

        System.out.println("\n=== PEMINJAMAN BERHASIL ===");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Nama Anggota : " + anggota.getNama());
        System.out.println("Judul Buku   : " + buku.getJudul());
        System.out.println("Lama Pinjam  : " + lamaPinjamHari + " hari");
        return true;
    }

    public boolean kembalikanBuku(String idTransaksi, int realisasiHari) {
        Peminjaman transaksi = null;
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            Peminjaman p = daftarTransaksi.get(i);
            if (p.getIdTransaksi().equalsIgnoreCase(idTransaksi) && !p.isDikembalikan()) {
                transaksi = p;
                break;
            }
        }

        if (transaksi == null) {
            System.out.println("Gagal: Transaksi peminjaman aktif dengan ID '" + idTransaksi + "' tidak ditemukan!");
            return false;
        }

        if (realisasiHari <= 0) {
            System.out.println("Gagal: Lama pemakaian riil harus lebih dari 0 hari!");
            return false;
        }

        ItemPerpustakaan buku = transaksi.getItem();
        buku.setDipinjam(false);
        transaksi.setDikembalikan(true);

        int terlambat = realisasiHari - transaksi.getLamaPinjamHari();
        double denda = 0.0;
        if (terlambat > 0) {
            denda = buku.hitungDenda(terlambat);
        }

        System.out.println("\n=== PENGEMBALIAN BUKU BERHASIL ===");
        System.out.println("ID Transaksi  : " + transaksi.getIdTransaksi());
        System.out.println("Anggota       : " + transaksi.getAnggota().getNama());
        System.out.println("Buku          : " + buku.getJudul());
        System.out.println("Batas Pinjam  : " + transaksi.getLamaPinjamHari() + " hari");
        System.out.println("Realisasi     : " + realisasiHari + " hari");
        System.out.println("Keterlambatan : " + (terlambat > 0 ? terlambat : 0) + " hari");
        System.out.printf("Total Denda   : Rp %.0f\n", denda);
        return true;
    }

    public void tampilkanTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada catatan transaksi.");
            return;
        }
        System.out.println("\n=== DAFTAR TRANSAKSI PEMINJAMAN ===");
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            Peminjaman t = daftarTransaksi.get(i);
            String status = t.isDikembalikan() ? "Sudah Dikembalikan" : "Sedang Dipinjam";
            System.out.println("ID: " + t.getIdTransaksi() +
                    " | Anggota: " + t.getAnggota().getNama() +
                    " | Buku: " + t.getItem().getJudul() +
                    " | Target: " + t.getLamaPinjamHari() + " hari" +
                    " | Status: " + status);
        }
    }

    public void tampilkanStatistikKategori() {
        if (jumlahBukuPerKategori.isEmpty()) {
            System.out.println("Belum ada data kategori buku.");
            return;
        }
        System.out.println("\n=== STATISTIK BUKU PER KATEGORI ===");
        for (Map.Entry<String, Integer> entry : jumlahBukuPerKategori.entrySet()) {
            System.out.println("- Kategori '" + entry.getKey() + "' : " + entry.getValue() + " buku");
        }
    }
}
