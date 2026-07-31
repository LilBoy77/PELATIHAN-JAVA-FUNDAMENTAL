# Sistem Manajemen Data Kendaraan (Pertemuan 5 & 6)

Program Java yang mengembangkan tugas Pertemuan 3 & 4 dengan menambahkan konsep:
**Abstract Class**, **Interface**, dan **Method Overloading**.

## Struktur Project

```
kendaraan-project/
├── src/
│   ├── Kendaraan.java             (Abstract Class - class induk)
│   ├── Perawatan.java             (Interface - 2 method)
│   ├── Mobil.java                 (turunan Kendaraan + implements Perawatan)
│   ├── Motor.java                 (turunan Kendaraan + implements Perawatan)
│   ├── Truk.java                  (turunan Kendaraan + implements Perawatan)
│   ├── DataKendaraanManager.java  (mengelola ArrayList<Kendaraan>)
│   └── Main.java                  (menu program / entry point)
└── README.md
```

## Pemetaan ke Ketentuan Tugas

| Ketentuan | Implementasi |
|---|---|
| Abstract Class | `Kendaraan` dengan 2 abstract method: `hitungBiayaSewa(int)` dan `getKategori()` |
| Interface | `Perawatan` dengan 2 method: `jadwalkanServis(String)` dan `cekKondisi()` |
| Class turunan | `Mobil`, `Motor`, `Truk` — masing-masing extends `Kendaraan` dan implements `Perawatan` |
| Method Overloading | `hitungBiayaSewa()` di-overload di setiap class turunan, contoh di `Mobil`: <br>• `hitungBiayaSewa(int jumlahHari)` <br>• `hitungBiayaSewa(int jumlahHari, double diskonPersen)` <br>• `hitungBiayaSewa(int jumlahHari, boolean pakaiSupir)` |

## Cara Menjalankan (lokal)

```bash
cd kendaraan-project
javac -d bin src/*.java
java -cp bin Main
```

Program sudah diisi 3 data contoh (1 mobil, 1 motor, 1 truk) agar bisa langsung dicoba,
lalu bisa ditambah/dihapus/dihitung lewat menu.

## Panduan Push ke GitHub

Jalankan perintah berikut di dalam folder `kendaraan-project`:

```bash
git init
git add .
git commit -m "Tugas Pertemuan 5 & 6 - Sistem Manajemen Data Kendaraan"
git branch -M main
git remote add origin https://github.com/USERNAME/NAMA-REPO.git
git push -u origin main
```

Ganti `USERNAME` dan `NAMA-REPO` sesuai repository GitHub kamu. Kalau repo sudah pernah
dibuat sebelumnya untuk tugas Pertemuan 3 & 4, cukup salin file-file di `src/` ke folder
repo yang sudah ada, lalu:

```bash
git add .
git commit -m "Tambah Abstract Class, Interface, dan Method Overloading"
git push
```

Setelah berhasil push, jangan lupa infokan di grup WhatsApp:
`Tugas [Nama Kamu] - Done ✅`
