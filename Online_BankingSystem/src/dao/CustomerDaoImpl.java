package dao;

import Utility.DBUtil;
import beanModel.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    public String registerCustomer(String accno, String username, String password, int mobile, String cid) {

        String message = "Not inserted..";

        try (Connection conn = DBUtil.setConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?)");
            ps.setString(1, accno);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, String.valueOf(mobile));
            ps.setString(5, cid);

            int x = ps.executeUpdate();

            if (x > 0) {
                message = "Customer registered successfully";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;


    }


    @Override
    public Customer loginCustomer(String username, String password) {
        Customer customer = null;
        try (Connection conn = DBUtil.setConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from customer where username = ? AND password = ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String a = rs.getString("accno");
                String u = rs.getString("username");
                String p = rs.getString("password");
                String m = rs.getString("mobile");
                String c = rs.getString("cid");

                customer = new Customer(u, m, p, a, c);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }


    @Override
    public String transfer(int amount, String accno1, String accno2) {
        String message = "Transfer failed..";

        try (Connection conn = DBUtil.setConnection()) {
            PreparedStatement ps1 = conn.prepareStatement("update customer set amount=amount-? where accNo = ?");
            ps1.setString(1, String.valueOf(amount));
            ps1.setString(2, accno1);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("update customer set amount=amount+? where accNo = ?");
            ps2.setString(1, String.valueOf(amount));
            ps2.setString(2, accno2);
            ps2.executeUpdate();

        }catch(SQLException e) {
            message = e.getMessage();
        }

        return message;
    }




    @Override
    public String transactionHistory(int cid) {
        String msg = "Retrieving Transaction history failed..";
        try (Connection conn = DBUtil.setConnection()) {

            PreparedStatement st1 = conn.prepareStatement("select * from customer where cid=?");
            ResultSet rs = st1.executeQuery();
            System.out.println("I am rs" + rs);
            while (rs.next()) {
                String accNo = rs.getString("accNo");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int mobile = rs.getInt("mobile");
                int id = rs.getInt("CID");
                int amt = rs.getInt("amount");
                System.out.println(accNo + ", " + username + ", " + password +
                        ", " + id + ", " + amt);
            }


        } catch (SQLException e) {
            msg = e.getMessage();
        }
        return msg;
    }
}