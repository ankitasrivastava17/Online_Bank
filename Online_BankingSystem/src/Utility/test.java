package Utility;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = DBUtil.setConnection();
        System.out.println(conn);
    }
}
