package usecases;

import beanModel.Accountant;
import beanModel.Customer;
import dao.AccountantDaoImpl;
import dao.CustomerDaoImpl;

import java.util.Scanner;

public class LoginAccountant {
    public static void LoginAccountant() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username...");
        String username = sc.nextLine();

        System.out.println("Enter password...");
        String password = sc.nextLine();

        AccountantDaoImpl cdao = new AccountantDaoImpl();
        try {
            Accountant acc = cdao.AccountantLogin(username,password);
            if(acc.getUsername()== null){
                System.out.println("Wrong username or password entered");
            }
            System.out.println("Login successful");

        } catch (Exception ce) {
            System.out.println(ce.getMessage());
        }
        String accNo=Customer.getAccNo();
        String uname = Customer.getUsername();
        String pass = Customer.getPassword();
        String mobile = Customer.getMobile();


    }
}
