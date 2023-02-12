import java.io.*;
import java.nio.charset.Charset;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.util.*;

public class ShareServerImpl implements ShareServer {
    private List<Account> accounts;
    private List<ShareHolding> shareHoldings;
    private String serverToken;
    private Account accountLoggedIn;

    public ShareServerImpl() {
        super();
        // For simplicity, assume that each company has 100 shares available
        try {
            Scanner sc = new Scanner(new File("opening prices.csv"));
            sc.useDelimiter(",");   //sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                System.out.print(sc.next());  //find and returns the next complete token from this scanner
            }
            sc.close();  //closes the scanner
        } catch (FileNotFoundException fileNotFoundException) {

        }

        // TODO: allow for multiple tokens/sessions
    }

    @Override
    public String login(String username, String password) throws RemoteException, InvalidLogin {
        // Iterate through the accounts
        System.out.println("Login attempt for username: " + username);
        for (Account account : accounts) {
            // Check if the username is there
            if (username.compareTo(account.getUsername()) == 0) {
                // Check if the password matches
                if (password.compareTo(account.getPassword()) == 0) {
                    System.out.println("Login successful");

                    // Create 64 bit token and return it
                    byte[] array = new byte[8]; // length is bounded by 8 (64 bits = 8 bytes)
                    new Random().nextBytes(array);
                    String token = new String(array, Charset.forName("UTF-8"));
                    serverToken = token;

                    accountLoggedIn = account;
                    return token;
                } else {
                    System.out.println("Login unsuccessful");
                    throw new InvalidLogin("Incorrect password");
                }
            }
        }
        throw new InvalidLogin("Username not found");
    }

    @Override
    public List<ShareHolding> downloadAllShares(String token) throws RemoteException {
        if(token.compareTo(serverToken) == 0) {
            return shareHoldings;
        } else {
            throw new AccessException("Access denied");
        }
    }

    @Override
    public void depositFunds(String token, float amount) throws RemoteException {
        if(token.compareTo(serverToken) == 0) {
            // Deposit that amount
            float newAmount = accountLoggedIn.getBalance() + amount;
            accountLoggedIn.setBalance(newAmount);
        } else {
            throw new AccessException("Access denied");
        }
    }

    @Override
    public void withdrawFunds(String token, float amount) throws RemoteException, IllegalArgumentException {
        if(token.compareTo(serverToken) == 0) {
            // Check if there are enough funds
            if(accountLoggedIn.getBalance() >= amount) {
                // Withdraw that amount
                float newAmount = accountLoggedIn.getBalance() - amount;
                accountLoggedIn.setBalance(newAmount);
            } else {
                throw new IllegalArgumentException("Not enough funds");
            }

        } else {
            throw new AccessException("Access denied");
        }
    }

    @Override
    public void purchaseShares(String token, ShareHolding shareHolding, float numShares) throws RemoteException {
        if(token.compareTo(serverToken) == 0) {
            // Calculate the cost of transaction
            float cost = shareHolding.getPrice() * numShares;

            // Check if there are enough funds
            if(accountLoggedIn.getBalance() >= cost) {
                // Purchase the shares
                accountLoggedIn.addToOwnedShares(shareHolding, numShares);

                // Decrease the balance
                float newAmount = accountLoggedIn.getBalance() - cost;
                accountLoggedIn.setBalance(newAmount);
            } else {
                throw new IllegalArgumentException("Not enough funds");
            }

        } else {
            throw new AccessException("Access denied");
        }
    }

    @Override
    public void sellShares(String token, ShareHolding shareHolding, float numShares) throws RemoteException, NotFoundException {
        if(token.compareTo(serverToken) == 0) {
            accountLoggedIn.sellShares(shareHolding, numShares);
        } else {
            throw new AccessException("Access denied");
        }
    }

    @Override
    public List<ShareHolding> getSharesOwned(String token) throws RemoteException {
        if(token.compareTo(serverToken) == 0) {
            return accountLoggedIn.getSharesOwned();
        } else {
            throw new AccessException("Access denied");
        }
    }
}
