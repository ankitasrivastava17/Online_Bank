package dao;

import beanModel.Customer;

public interface CustomerDao {

    public Customer loginCustomer(String username, String password);

    public String transfer(int amount,String accno,String accno2);

    public String transactionHistory(int cid);
}
