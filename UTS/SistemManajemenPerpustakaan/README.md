# Sistem Manajemen Perpustakaan (Java Console)

Aplikasi Sistem Manajemen Perpustakaan adalah program berbasis konsol (Java Console) yang dirancang untuk mengelola data buku (buku fisik & digital), anggota perpustakaan, serta alur transaksi peminjaman dan pengembalian buku dengan perhitungan denda otomatis.

---

## Fitur Utama Program
1. **Kelola Buku (CRUD)**
   - Tambah Buku Fisik (dengan atribut lokasi rak).
   - Tambah Buku Digital (dengan atribut ukuran berkas MB).
   - Tampilkan seluruh daftar buku.
   - Ubah judul dan kategori buku.
   - Hapus buku (dengan validasi buku tidak sedang dipinjam).

2. **Kelola Anggota (CRUD)**
   - Tambah Anggota baru. m
   - Tampilkan seluruh daftar anggota.
   - Ubah nama dan email anggota.
   - Hapus anggota (dengan validasi tidak sedang memiliki peminjaman aktif).

3. **Pencarian Data (Method Overloading)**
   - Pencarian buku berdasarkan Kode Buku.
   - Pencarian buku berdasarkan Judul Buku.
   - Pencarian buku berdasarkan Kategori Buku.
   - Pencarian anggota berdasarkan nama.

4. **Sistem Peminjaman Buku**
   - Validasi ID anggota terdaftar & kode buku tersedia.
   - Pencatatan transaksi peminjaman otomatis (`TRX1`, `TRX2`, dst.).
   - Perubahan status ketersediaan buku menjadi "Dipinjam".

5. **Sistem Pengembalian Buku & Perhitungan Denda**
   - Perhitungan masa peminjaman riil vs target hari.
   - Perhitungan denda otomatis:
     - Buku Fisik: Rp 2.000 / hari keterlambatan.
     - Buku Digital: Rp 1.000 / hari keterlambatan.
   - Perubahan status ketersediaan buku kembali menjadi "Tersedia".

6. **Daftar Transaksi Peminjaman**
   - Menampilkan riwayat transaksi peminjaman beserta statusnya.

7. **Statistik Kategori Buku (HashMap)**
   - Menampilkan ringkasan jumlah buku per kategori secara real-time.

---

## Aturan Peminjaman & Denda
- **Denda Keterlambatan**:
  - Denda hanya dihitung jika lama pemakaian riil melebihi batas hari pinjam yang disepakati.
  - Formula Denda = `(Hari Riil - Batas Hari) * Tarif Denda`.
  - Tarif Denda Buku Fisik: Rp 2.000 / hari.
  - Tarif Denda Buku Digital: Rp 1.000 / hari.
- **Validasi Keamanan**:
  - Kode buku dan ID Anggota harus unik.
  - Input teks tidak boleh kosong.
  - Input angka tervalidasi tanpa risiko crash.
  - Buku yang sedang dipinjam tidak dapat dipinjam kembali maupun dihapus.
  - Anggota yang memiliki transaksi aktif tidak dapat dihapus.

---

## Struktur Class & File Program

| Nama File | Jenis | Deskripsi |
| :--- | :--- | :--- |
| `Identitas.java` | Interface | Kontrak metode `getId()` dan `tampilkanDetail()`. |
| `ItemPerpustakaan.java` | Abstract Class | Induk class barang perpustakaan (`implements Identitas`). |
| `BukuFisik.java` | Class Turunan | Class turunan dari `ItemPerpustakaan` dengan atribut `lokasiRak` dan denda Rp 2.000/hari. |
| `BukuDigital.java` | Class Turunan | Class turunan dari `ItemPerpustakaan` dengan atribut `ukuranBerkas` dan denda Rp 1.000/hari. |
| `Anggota.java` | Class Entity | Class entitas anggota perpustakaan (`implements Identitas`). |
| `Peminjaman.java` | Class Entity | Class relasi transaksi peminjaman antara `Anggota` dan `ItemPerpustakaan`. |
| `PengelolaPerpustakaan.java` | Logic Manager | Class tempat seluruh bisnis logika. |
| `Main.java` | Main Class | Class utama dengan `main()` yang mengontrol jalannya loop menu console dan input scanner. |

---

## Cara Menjalankan Program

1. Buka terminal / command prompt di direktori `SistemManajemenPerpustakaan`.
2. Kompilasi seluruh file Java:
   ```bash
   javac *.java
   ```
3. Jalankan program utama:
   ```bash
   java Main
   ```
