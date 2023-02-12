import java.util.List;
import java.util.Map;

public class Account {
    private String username;
    private String password;
    private float balance;
    private List<ShareHolding> sharesOwned;

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

    public void addToOwnedShares(ShareHolding shareHolding, float numShares) {
        // Check do we own shares for that shareholding
        for (ShareHolding ownedShareHolding : sharesOwned) {
            if (ownedShareHolding.getTicker().compareTo(shareHolding.getTicker()) == 0) {
                // Append the number of shares bought
                float newSharesOwnedForThisShareHolding = ownedShareHolding.getNumSharesOwned() + numShares;
                ownedShareHolding.setNumSharesOwned(newSharesOwnedForThisShareHolding);
            }
         }

        // At this point, we dont own shares for this shareholding - so create the object
        shareHolding.setNumSharesOwned(numShares);
        sharesOwned.add(shareHolding);
    }

    public void sellShares(ShareHolding shareHolding, float numSharesToSell) throws NotFoundException, IllegalArgumentException {
        // Check do we own shares for that shareholding
        for (ShareHolding ownedShareHolding : sharesOwned) {
            if (ownedShareHolding.getTicker().compareTo(shareHolding.getTicker()) == 0) {
                // Check do we have enough shares to sell
                float sharesOwnedForThisShareHolding = ownedShareHolding.getNumSharesOwned();
                if(sharesOwnedForThisShareHolding >= numSharesToSell) {
                    // Decrease the number of shares owned for that stock
                    float newSharesOwned = sharesOwnedForThisShareHolding - numSharesToSell;
                    ownedShareHolding.setNumSharesOwned(newSharesOwned);

                    // Calculate the current value of the shares
                    float currentValue = shareHolding.getPrice() * numSharesToSell;
                    balance += currentValue;
                    return;
                } else {
                    throw new IllegalArgumentException("Not enough shares owned");
                }
            } else {
                throw new NotFoundException("No shares owned for that stock");
            }
        }
    }
}
