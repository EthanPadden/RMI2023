import java.nio.charset.Charset;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

public class ShareServerImpl implements ShareServer {
    private List<Account> accounts;
    private List<Share> shares;
    private String serverToken;
    private Account accountLoggedIn;

    public ShareServerImpl() {
        super();

        // TODO: import shares from CSV here
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
    public List<Share> downloadAllShares(String token) throws RemoteException {
        if(token.compareTo(serverToken) == 0) {
            return shares;
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
}
