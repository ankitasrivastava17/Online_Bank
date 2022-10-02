package beanModel;

public class Transaction {
    //transaction class

    //Declaring private attributes
    private int userId;
    private int transId;
    private String date;
    private String time;
    private String r_account;
    private String r_name;
    private double amount;
    private String type;

    //transaction overloaded constructor
    public Transaction(int userId, int transId, String date, String time, String r_account, String r_name,
                        double amount, String type) {
        super();
        this.userId = userId;
        this.transId = transId;
        this.date = date;
        this.time = time;
        this.r_account = r_account;
        this.r_name = r_name;
        this.amount = amount;
        this.type = type;


    }

    //get details using getters
    public int getUserId() {
        return userId;
    }

    public int getTransId() {
        return transId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getR_account() {
        return r_account;
    }

    public String getR_name() {
        return r_name;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    //set details using setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setR_account(String r_account) {
        this.r_account = r_account;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

//transaction class ends
}
