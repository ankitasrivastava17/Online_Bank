package dao;

import beanModel.Accountant;

public interface AccountantDao {
//• Login using his/her username and password
//• Adding new account for customer
//• Editing already available account
//• Removing the account by using the account number
//• Viewing particular account details by giving the account number
//• Viewing all the account details
//• Taking care of deposit and withdrawal operations

    public Accountant AccountantLogin(String username,String password);//done
    public String registerCustomer();//done
    public String updateAccount(int cid,String username);
    public String removeAccount(String accNo);
    public String showAccount(String accNo);
    public String viewAllAccounts();
    public String deposit(int amount,String accNo);
    public String withdraw(int amount,String accNo);

}
