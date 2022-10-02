package App;
import beanModel.Customer;
import dao.AccountantDaoImpl;
import dao.CustomerDaoImpl;
import usecases.LoginAccountant;
import usecases.LoginUsecase1;
import usecases.RegisterCustomerUseCase1;

import java.util.Scanner;

import static usecases.RegisterCustomerUseCase1.registerCustomer;

public class Main {
//    Scanner sc = new Scanner(System.in);
    static LoginUsecase1 rc1 = new LoginUsecase1();
    static LoginAccountant rc2 = new LoginAccountant();
    static AccountantDaoImpl rc3 = new AccountantDaoImpl();
    static CustomerDaoImpl rc4 = new CustomerDaoImpl();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Online Banking System:");
        System.out.println("Choose the following Option:");
        System.out.println("1.Log in as a Accountant");
        System.out.println("2.Log in as a Customer");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Welcome,login as Accountant");
                System.out.println("********** INSIDE ACCOUNTANT **********");
                System.out.println("Choose action from below options ..");
                System.out.println("A. Login using his/her username and password");
                System.out.println("B. Adding new account for customer");
                System.out.println("C. Editing already available account");
                System.out.println("D. Removing the account by using the account number");
                System.out.println("E. Viewing particular account details by giving the account number");
                System.out.println("F. Viewing all the account details");
                System.out.println("G. Taking care of deposit operations");
                System.out.println("H. Taking care of withdrawal operations");
                String c = sc.nextLine();
            switch (c) {
                case "A":
                    System.out.println("Login as accountant");
                    rc2.LoginAccountant();
                    break;

                case "B":
                    System.out.println("Add new account for customer");
                    rc3.registerCustomer();
                    break;

                case "C":
                    System.out.println("Editing already available account");
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Enter cid..");
                    int cid = sc.nextInt();
                    System.out.println("Enter username..");
                    String username = sc1.nextLine();
                    rc3.updateAccount(cid, username);
                    break;
                case "D":
                    System.out.println("Removing the account by using the account number");
                    System.out.println("Enter account number here..");
                    Scanner sc2 = new Scanner(System.in);
                    String accno = sc2.nextLine();
                    rc3.removeAccount(accno);
                    break;
                case "E":
                    System.out.println("Viewing particular account details by giving the account number");
                    System.out.println("Enter account number here..");
                    Scanner sc3 = new Scanner(System.in);
                    String acc = sc3.nextLine();
                    rc3.showAccount(acc);
                    break;
                case "F":
                    System.out.println("Viewing all the account details");
                    rc3.viewAllAccounts();
                    break;
                case "G":
                    System.out.println("Taking care of deposit operations");
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Enter deposit amount");
//                    int amt = sc4.nextInt();
                    int amt = Integer.parseInt(sc4.nextLine());
                    System.out.println("Enter account number here..");
                    String ac1 = sc4.nextLine();
                    rc3.deposit(amt, ac1);
                    break;
                case "H":
                    System.out.println("Taking care of withdraw operations");
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println("Enter Withdraw amount");
//                    int amt_w = sc5.nextInt();
                    int amt_w = Integer.parseInt(sc5.nextLine());
                    System.out.println("Enter account number here..");
                    String ac2 = sc5.nextLine();
                    rc3.withdraw(amt_w, ac2);
                    break;
                default:
                    System.out.println("Choose any valid option..");
                    break;
//                    break;
            }
            break;
            case 2:
                System.out.println("Welcome,login as customer");
                rc1.LoginCustomer();
                System.out.println("1. Login as Customer");
                System.out.println("2. Transfer amount from one account to another");
                System.out.println("3. View Transaction History");
                int x = sc.nextInt();
            switch (x){
                case 1 :
                    System.out.println("Login as Customer");
                    rc1.LoginCustomer();
                    break;
                case 2:
                    System.out.println("Transfer money");
                    Scanner q1 = new Scanner(System.in);

                    System.out.println("Enter amount here...");
                    int a1 = Integer.parseInt(q1.nextLine());

                    System.out.println("Enter sender account number...");
                    String acc1=q1.nextLine();

                    System.out.println("Enter receiver account number...");
                    String acc2=q1.nextLine();
                    rc4.transfer(a1,acc1,acc2);

            }
                break;

            default:
                System.out.println("Invalid Entry...Please Press valid option 1or 2");
        }

    }
}