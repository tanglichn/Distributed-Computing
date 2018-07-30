import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Create server to start RMI registry, create all the objects and register them.
 * 
 * @author Li Tang
 * @version 2017.11.22
 */
public class Server {
	public static void main(String[] argv) {
		try {
			LocateRegistry.createRegistry(6668);
			LocateRegistry.createRegistry(6669);
			LocateRegistry.createRegistry(6670);
			LocateRegistry.createRegistry(6671);
			LocateRegistry.createRegistry(6672);
			
			BranchInterface Bra = new BranchInterfaceImpl();
			BalancerInterface Bal = new BalancerInterfaceImpl();
			SmartphoneInt Sma = new SmartphoneIntImpl();
			LaptopInt Lap = new LaptopIntImpl();
			DesktopcomputerInt Des = new DesktopcomputerIntImpl();
			
			Naming.rebind("rmi://10.245.132.114:6668/Bra", Bra);
			Naming.rebind("rmi://10.245.132.114:6669/Bal", Bal);
			Naming.rebind("rmi://10.245.132.114:6670/Sma", Sma);
			Naming.rebind("rmi://10.245.132.114:6671/Lap", Lap);
			Naming.rebind("rmi://10.245.132.114:6672/Des", Des);
			
			System.out.println("Server is ready");	
		}catch (Exception e) {
			System.out.println("Server failed:" + e);
		}
	}

}
