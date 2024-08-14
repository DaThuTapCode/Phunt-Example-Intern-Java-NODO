package week2.day1example.model;

/**
 * Created by Trong Phu on 12/08/2024 15:58:04
 *
 * @author Trong Phu
 */
public class User {
    private String id;

    private String userName;

    private String password;

    public User(){

    }

    public User(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}