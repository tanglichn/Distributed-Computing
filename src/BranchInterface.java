import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * creating a remote interface BranchInterface
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public interface BranchInterface extends Remote{
	public List<Product> getProductList() throws RemoteException;
	public List<Customer> getCustomerList() throws RemoteException;
	public int requestStock(String productname, int num)throws RemoteException;
}
