import java.rmi.RemoteException;
import java.util.List;

public interface ShareServer {
    public String login(String username, String password) throws RemoteException, InvalidLogin;
    public List<Share> downloadAllShares(String token) throws RemoteException;
    public void depositFunds(String token, float amount) throws RemoteException;
    public void withdrawFunds(String token, float amount) throws RemoteException;
    public void purchaseShares(String token, Share share, float numShares) throws RemoteException;
    public void sellShares(String token, Share share, float numShares) throws RemoteException, NotFoundException;
}
