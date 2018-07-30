import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * creating a remote interface LaptopInterface
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public interface LaptopInt extends Remote{
	public int getLaptopStock() throws RemoteException;
}
