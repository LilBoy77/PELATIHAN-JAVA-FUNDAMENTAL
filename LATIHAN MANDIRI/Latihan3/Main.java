import java.util.Scanner;

 public class Main{

   public static void main(String[] args){
    User user = new User();
    Scanner input = new Scanner(System.in);

    System.out.print("input nama :");
    String nama = input.nextLine();
    user.setNama(nama);
    
    System.out.print("input password :");
    String password = input.nextLine();
    user.setPassword(password);

    if(user.getNama().equals("admin") && user.getPassword().equals("admin123")){
        System.out.println("login berhasil");
    }else{
        System.out.println("login gagal");
   }
   input.close();

    }
 }