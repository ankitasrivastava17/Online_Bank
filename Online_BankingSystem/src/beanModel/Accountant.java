package beanModel;

public class Accountant {

    private int aid;
    private String username;
    private String password;

    public Accountant(String aid, String username, String password) {
        this.aid = Integer.parseInt(aid);
        this.username = username;
        this.password = password;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
