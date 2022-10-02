package dao;

import Utility.DBUtil;
import beanModel.Accountant;
import beanModel.Customer;

import java.sql.*;

public class AccountantDaoImpl implements AccountantDao{

    @Override
    public Accountant AccountantLogin(String username,String password) {
        Accountant acc = null;
        try (Connection conn = DBUtil.setConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from accountant where username = ? AND password = ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String a = rs.getString("AID");
                String u = rs.getString("username");
                String p = rs.getString("password");

                Accountant acc1 = new Accountant(a, u, p);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    @Override
    public String registerCustomer() {
        String message = "Not inserted..";


        try(Connection conn = DBUtil.setConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?)");
            ps.setString(1, Customer.getAccNo());
            ps.setString(2,Customer.getUsername());
            ps.setString(3,Customer.getPassword());
            ps.setString(4,Customer.getMobile());


            int x = ps.executeUpdate();

            if(x>0){
                message = "Customer registered successfully";
            }
        }catch(SQLException e){
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String updateAccount(int cid,String username) {
        String message = "Not updated..";
        try(Connection conn = DBUtil.setConnection()){
            PreparedStatement ps = conn.prepareStatement("UPDATE customer set mobile=? where cid=? AND username=?");
            ps.setString(1, String.valueOf(cid));
            ps.setString(2,username);
            ps.executeUpdate();
        }catch (SQLException e){

        }

        return message;
    }

    @Override
    public String removeAccount(String accNo) {
        String message = "Remove failed..";
        try(Connection conn = DBUtil.setConnection()){
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customer WHERE accNo=?");
            ps.setString(1,accNo);
            ps.executeUpdate();
            message="Succesfully removed...";

        }catch (SQLException e){
        }
        return message;
    }

    @Override
    public String showAccount(String accNo) {
        String message = "View account failed";
//        System.out.println(acc);
//        Connection conn = null;
        try(Connection conn = DBUtil.setConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from customers where accno = ?");
            ps.setString(1, accNo);

            ResultSet rs1 = ps.executeQuery();

            if (rs1.next()) {
                String accno = rs1.getString("accno");
                String username = rs1.getString("username");
                String password = rs1.getString("password");
                int mobile = rs1.getInt("mobile");
                int cid = rs1.getInt("cid");
                int amount = rs1.getInt("amount");

//                new Customer();
                Customer x = new Customer(username,mobile,password,accno,cid);
                x.toString();


            }



//            st1.close();
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String viewAllAccounts() {
        String message = "View all account failed";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_bankingsystem","root","root");
            String query = "SELECT * FROM CUSTOMER";
            Statement st = conn.createStatement();
            //result handling
            ResultSet rs = st.executeQuery(query);
            //display the result
            while (rs.next()){
                String accNo = rs.getNString(1);
                String username = rs.getNString(2);
                String password = rs.getString(3);
                int mobile = rs.getInt(4);
                int cid = rs.getInt(5);
                int amount = rs.getInt(6);
                message="viewing data succeeded";
                System.out.format("%s,%s,%s,%d,%d,%d,\n",accNo,username,password,mobile,cid,amount);
            }
            st.close();
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String deposit(int amount,String accNo) {
        String message = "Deposit failed..";
        try(Connection conn = DBUtil.setConnection()){
            PreparedStatement ps = conn.prepareStatement("UPDATE customer set amount=amount+? where accNo=?");
            ps.setString(1, String.valueOf(amount));
            ps.setString(2,accNo);
            ps.executeUpdate();
            message="Succesfully updated...";


        }catch (SQLException e){
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String withdraw(int amt,String accNo) {
        String message = "Deposit failed..";
        try(Connection conn = DBUtil.setConnection()){
            PreparedStatement ps = conn.prepareStatement("UPDATE customer set amount=amount-? where accNo=?");
            ps.setString(1, String.valueOf(amt));
            ps.setString(2,accNo);
            ps.executeUpdate();
            message="Succesfully updated...";


        }catch (SQLException e){
            message = e.getMessage();
        }
        return message;
    }
}
