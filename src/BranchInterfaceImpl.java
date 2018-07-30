import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * achieving the BranchInterface.
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class BranchInterfaceImpl extends UnicastRemoteObject implements BranchInterface{
	private static final long serialVersionUID = 1L;
	
	protected BranchInterfaceImpl() throws RemoteException{
		super();
	}
	
	public List<Product> getProductList() throws RemoteException{
		List<Product> productList = new ArrayList<Product>();
		
		Connection con = GetConnection.getConnection();
		
		StringBuilder sb = new StringBuilder();
	    sb.append("SELECT * FROM `product`");
	    
	    PreparedStatement ptmt = null;
		try {
			ptmt = con.prepareStatement(sb.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    ResultSet rs = null;
		try {
			rs = ptmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    Product product = null;
	    
	    try {
			while (rs.next())
			{
			  product = new Product();
			  product.setId(rs.getInt("id"));
			  product.setProductname(rs.getString("productname"));
			  product.setStocklevel(rs.getInt("stocklevel"));
			  product.setProductsales(rs.getInt("productsales"));
 
			  productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   finally {
	    	GetConnection.closeDB();
	    }
	    return productList;
	  }
	
	
	public List<Customer> getCustomerList() throws RemoteException{
		List<Customer> customerList = new ArrayList<Customer>();
		
		PreparedStatement ptmt = null;
        ResultSet rs = null;
        
		Connection con = GetConnection.getConnection();
		
		StringBuilder sb = new StringBuilder();
	    sb.append("SELECT * FROM `customer`");
 try { 
	    ptmt = con.prepareStatement(sb.toString());
	    
	    rs = ptmt.executeQuery();
	 
	    Customer customer = null;
	    
	    while (rs.next())
	    {
	     customer = new Customer();
	     customer.setCustomerid(rs.getInt("customerid"));
	     customer.setCustomername(rs.getString("customername"));
	     customer.setPurchasehistory(rs.getString("purchasehistory"));
	     customerList.add(customer);
	    }
 }
	 catch (SQLException e) {
		 
        e.printStackTrace();
    } finally {
    	GetConnection.closeDB();
    }
	    return customerList;
	  }
	
	
	public int requestStock(String productname, int num) throws RemoteException{
		int stocklevel = 0;
		int shop = 0;
		
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = this.getProductList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Product pro:productList) {
			if(pro.getProductname().equals(productname)){
				 stocklevel = pro.getStocklevel();
			}
		}
		if (stocklevel>=num) {
			System.out.println("the numnber of product is enough in shop");
			shop = -1;	 
		}
		else if (stocklevel<num) {
			System.out.println("the numnber of product is not enough in shop");
			BalancerInterface bal = null;
	          try {
				bal = (BalancerInterface) Naming.lookup("rmi://10.245.132.114:6669/Bal");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          int productstock = 0;
			try {
				productstock = bal.getProductStock(productname);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          if (productstock >= num- stocklevel) {
	        	  System.out.println("the numnber of product is enough in Banana HQ");
	        	  shop = 0;
	          }
	          else if (productstock < num- stocklevel) {
	        	  System.out.println("the numnber of product is not enough in Banana HQ");
	        	  shop = 1;
	          }	
		}
		return shop;
	}
}

