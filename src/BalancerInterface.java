import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * creating a remote interface BalancerInterface
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public interface BalancerInterface extends Remote{
	public int getProductStock(String productname) throws RemoteException;

}
