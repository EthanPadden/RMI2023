import java.rmi.RemoteException;
import java.util.List;

public interface ShareServer {
    public String login(String username, String password) throws RemoteException, InvalidLogin;
    public List<Share> downloadAllShares(String token) throws RemoteException;
}
