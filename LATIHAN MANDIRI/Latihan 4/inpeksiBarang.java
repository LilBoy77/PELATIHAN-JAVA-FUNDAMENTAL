public class inpeksiBarang {
    public String tentukanTindakan(String kondisiFisik){
        String hasilKondisi = "";

        switch (kondisiFisik.toUpperCase()) {
            case "Utuh":
                hasilKondisi = "Simpan ke rak Utama";
                break;
            case "Penyok":
                hasilKondisi = "Pisahkan Ke area retur";
            case "Basah":
                hasilKondisi = "Lapor ke Survivor";
            default:
                System.out.println("kembali ke karantina barang");
                break;
        }
        return hasilKondisi;

    }
}
