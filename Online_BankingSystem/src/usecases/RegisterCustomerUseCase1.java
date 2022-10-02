package usecases;

//import dao.CustomerDao;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import java.util.Scanner;

public class RegisterCustomerUseCase1 {
    public static void registerCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 12-digit account Number...");
        String accNo = sc.nextLine();

        System.out.println("Enter username...");
        String username = sc.nextLine();

        System.out.println("Enter Password...");
        String password = sc.nextLine();

        System.out.println("Enter Mobile Number...");
        Integer mobile = sc.nextInt();

        System.out.println("Enter CustomerId...");
        Integer cid = sc.nextInt();



        CustomerDaoImpl cdao = new CustomerDaoImpl();
        String message = cdao.registerCustomer(accNo,username,password,mobile, String.valueOf(cid));

        System.out.println(message);
    }
}
