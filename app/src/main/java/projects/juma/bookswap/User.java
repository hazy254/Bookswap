package projects.juma.bookswap;

/**
 * Created by TOSHIBA on 8/1/2016.
 */
public class User {
    public long userId;
    public String username;
    public String password;

    public User(long userId, String username, String password){
        this.userId=userId;
        this.username=username;
        this.password=password;
    }
}
