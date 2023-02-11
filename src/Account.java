import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private float balance;

    public Account(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
