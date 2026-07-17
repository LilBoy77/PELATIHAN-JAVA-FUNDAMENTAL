package tugas.pertemuan2;

public class NilaiService {

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        double nilaiAkhir = (tugas * 0.30) + (uts * 0.30) + (uas * 0.40);
        return nilaiAkhir;
    }

    public static String tentukanGrade(double nilaiAkhir) {
        String grade;
        int kategori = (int) (nilaiAkhir / 10); // 0 - 10

        switch (kategori) {
            case 10:
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }
        return grade;
    }

    public String tentukanStatus(double nilaiAkhir) {
        String status = (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";
        return status;
    }
    public static String tentukanPredikat(String grade) {
        String predikat;
        if (grade.equals("A")) {
            predikat = "Sangat Baik";
        } else if (grade.equals("B")) {
            predikat = "Baik";
        } else if (grade.equals("C")) {
            predikat = "Cukup";
        } else if (grade.equals("D")) {
            predikat = "Kurang";
        } else {
            predikat = "Sangat Kurang";
        }
        return predikat;
    }
    
}
