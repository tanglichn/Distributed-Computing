import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * creating a remote interface SmartphoneInterface
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public interface SmartphoneInt extends Remote{
	public int getSmartphoneStock() throws RemoteException;
}
