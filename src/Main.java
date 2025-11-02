
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("enter the master password: ");
            String masterPassword = sc.nextLine();

            PasswordManager manager = new PasswordManager(masterPassword);

            while (true) {
                System.out.println("\npassword manager");
                System.out.println("1. add credential");
                System.out.println("2. view all");
                System.out.println("3. delete credential");
                System.out.println("4. save & exit");
                System.out.print("option: ");
                int ch = sc.nextInt();
                sc.nextLine();


                if (ch == 1) {
                    System.out.print("site: "); String site = sc.nextLine();
                    System.out.print("username: "); String user = sc.nextLine();
                    System.out.print("password: "); String pass = sc.nextLine();
                    manager.addCredential(site, user, pass);

                } else if (ch == 2) {
                    manager.viewAll();

                } else if (ch == 3) {
                    System.out.print("enter site name to delete: ");
                    String site = sc.nextLine();
                    manager.deleteCredential(site);

                } else if (ch == 4) {
                    manager.save();
                    System.out.println("data saved securely. exiting...");
                    break;

                } else {
                    System.out.println("invalid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("[error]: " + e.getMessage());
        }
    }
    
}
