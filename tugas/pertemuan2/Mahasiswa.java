package tugas.pertemuan2;

public class Mahasiswa {

    private String nim;
    private String nama;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiAkhir;
    private String grade;
    private String statusKelulusan;

    public Mahasiswa(String nim, String nama, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public String getNim() { 
        return nim; 
    }
    public String getNama() { 
        return nama; 
    }
    public double getNilaiTugas() { 
        return nilaiTugas; 
    }
    public double getNilaiUTS() { 
        return nilaiUTS; 
    }
    public double getNilaiUAS() { 
        return nilaiUAS; 
    }
    public double getNilaiAkhir() { 
        return nilaiAkhir; 
    }
    public String getGrade() { 
        return grade; 
    }
    public String getStatusKelulusan() { 
        return statusKelulusan; 
    }

    public void setNilaiAkhir(double nilaiAkhir) { 
        this.nilaiAkhir = nilaiAkhir; 
    }
    public void setGrade(String grade) { 
        this.grade = grade; 
    }
    public void setStatusKelulusan(String statusKelulusan) { 
        this.statusKelulusan = statusKelulusan; 
    }
}