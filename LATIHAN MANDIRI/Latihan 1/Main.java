import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Hello, World!");
        
//        String Nama = "Buahlil";
//        System.out.printf("Nama saya : %s", Nama);

//        char huruf = 'A';
//        System.out.printf("Huruf saya : %c", huruf);

//     //    int[] array = {1, 2, 3, 4, 5}

//        int[] angka = new int[5];
//        angka[0] = 10;
//        angka[1] = 20;
//        angka[2] = 30;
//        System.out.println(angka[1]);

//        ArrayList<String> listName = new ArrayList<>();
//        listName.remove("kocak");
//        listName.add("bahlil");
//        System.out.println(listName.get(0));
//        System.out.println(listName.get(1));

//     }

//     public static void printHello(String[] args) throws IOException {
//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         System.out.print("Masukan nama :");
//         String nama = reader.readLine();
//         System.out.printf("Nama saya : %s", nama);
        
//     }

// }

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan nama : ");
        String nama = scanner.nextLine();
        System.out.printf("Nama saya : %s", nama);
    }
}

