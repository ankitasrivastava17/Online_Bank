package usecases;

import beanModel.Customer;
//import dao.BankDao;
import dao.AccountantDaoImpl;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

import java.util.Scanner;

public class LoginUsecase1 {
    public static void LoginCustomer() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter username...");
        String username = sc.nextLine();

        System.out.println("Enter password...");
        String password = sc.nextLine();

        CustomerDaoImpl cdao = new CustomerDaoImpl();
        try {
            Customer customer = cdao.loginCustomer(username,password);
           if(customer.getUsername()== null){
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
