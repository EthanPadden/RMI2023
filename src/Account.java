import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Account {
    private String username;
    private String password;
    private float balance;
    private Map<Share, Float> ownedStocks;

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

    public void addToOwnedShares(Share share, float numShares) {
        // TODO: check if that value updates or if a new entry is added
        ownedStocks.put(share, numShares);
    }

    public void sellShares(Share share, float numSharesToSell) throws NotFoundException, IllegalArgumentException {
        if(ownedStocks.containsKey(share)) {
            float sharesOwned = ownedStocks.get(share);
            if(sharesOwned > numSharesToSell) {
                // Decrease the number of shares owned for that stock
                float newSharesOwned = sharesOwned - numSharesToSell;
                ownedStocks.put(share, newSharesOwned);

                // Calculate the current value of the shares
                float currentValue = share.getPrice() * numSharesToSell;
                balance += currentValue;
            } else {
                throw new IllegalArgumentException("Not enough shares owned");
            }
        } else {
            throw new NotFoundException("No shares owned for that stock");
        }
    }
}
