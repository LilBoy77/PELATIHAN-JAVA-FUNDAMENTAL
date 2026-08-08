public class Anggota implements Identitas {
    private String idAnggota;
    private String nama;
    private String email;

    public Anggota(String idAnggota, String nama, String email) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.email = email;
    }

    @Override
    public String getId() {
        return this.idAnggota;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(String idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("[Anggota] ID: " + idAnggota + " | Nama: " + nama + " | Email: " + email);
    }
}
