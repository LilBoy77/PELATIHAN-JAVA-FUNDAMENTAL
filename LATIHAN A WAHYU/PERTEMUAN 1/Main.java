import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        System.out.print("Hello, World!");
        System.out.print("Hi bahlil!");

        // int age = 25;
        // System.out.printf("umur saya: %d", age);  

        String nama = "bahlil";
        System.out.printf("nama saya: %s", nama);
        
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama Anda: ");
        String inputNama = input.nextLine();
        System.out.printf("Halo, %s!", inputNama);

}
}