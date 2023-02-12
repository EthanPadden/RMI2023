import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ShareServer extends Remote {
    public String login(String username, String password) throws RemoteException, InvalidLogin;
    public List<ShareHolding> downloadAllShares(String token) throws RemoteException;
    public void depositFunds(String token, float amount) throws RemoteException;
    public void withdrawFunds(String token, float amount) throws RemoteException;
    public void purchaseShares(String token, ShareHolding shareHolding, float numShares) throws RemoteException;
    public void sellShares(String token, ShareHolding shareHolding, float numShares) throws RemoteException, NotFoundException;
    public List<ShareHolding> getSharesOwned(String token) throws RemoteException;
}
