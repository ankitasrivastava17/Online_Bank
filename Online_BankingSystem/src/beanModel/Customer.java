package beanModel;

public class Customer {
    private static String username;
    private static String mobile;
    private static String accNo;
    private static String password;

    private static int cid;

    public Customer(String a, String u, String p, String s, String c) {
        super();
        this.username = username;
        this.mobile = mobile;
        this.password = password;
        this.accNo = accNo;
        this.cid = cid;
    }

    public Customer( String u, int m, String p,String a,int c) {
        super();
        this.username = u;
        this.mobile = String.valueOf(m);
        this.password = p;
        this.accNo = a;
        this.cid = cid;
    }



    public static int getCid() {
        return cid;
    }

    public static void setCid(int cid) {
        Customer.cid = cid;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer [username=" + username + ", mobile=" + mobile + ", accNo=" + accNo + ", password=" + password
                + "]";
    }

}
