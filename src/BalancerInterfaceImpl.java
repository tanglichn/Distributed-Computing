import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * achieving the BalancerInterface.
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class BalancerInterfaceImpl extends UnicastRemoteObject implements BalancerInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3326634613710650590L;

	protected BalancerInterfaceImpl() throws RemoteException{
		super();
	}
	

	public int getProductStock(String productname) throws RemoteException{
		
		int productstock = 0;
		if (productname.equals("smartphone")) {
			SmartphoneInt Sma = null;
	          try {
				Sma = (SmartphoneInt) Naming.lookup("rmi://10.245.132.114:6670/Sma");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          productstock = Sma.getSmartphoneStock();	
		}
		
		else if (productname.equals("laptop")) {
			LaptopInt Lap = null;
	          try {
				Lap = (LaptopInt) Naming.lookup("rmi://10.245.132.114:6671/Lap");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          productstock = Lap.getLaptopStock();	
		}
		
		else if(productname.equals("desktop computer")) {
			DesktopcomputerInt Des = null;
	          try {
				Des = (DesktopcomputerInt) Naming.lookup("rmi://10.245.132.114:6672/Des");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          productstock = Des.getDesktopcomputerStock();	
		}
		
		return productstock;
	}
	

}
