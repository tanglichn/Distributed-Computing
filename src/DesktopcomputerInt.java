import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * creating a remote interface DesktopcomputerInterface
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public interface DesktopcomputerInt extends Remote{
	public int getDesktopcomputerStock()  throws RemoteException;
}