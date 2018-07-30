import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * achieving the SmartphoneInterface.
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class SmartphoneIntImpl extends UnicastRemoteObject implements SmartphoneInt{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2547924751401464785L;

	protected SmartphoneIntImpl() throws RemoteException{
		super();
	}
	
	public int getSmartphoneStock() throws RemoteException{
		List<Product> productList = new ArrayList<Product>();
		 
	    Connection con = GetConnection.getConnection();
	 
	    StringBuilder sb = new StringBuilder();
	    sb.append("SELECT * FROM `Banana HQ`");
	 
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
				product.setId(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setStocklevel(rs.getInt("stocklevel"));
 
			  productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int smartphoneStock = 0;
		for(Product p : productList) {
			if(p.getProductname().equals("smartphone")) {
	    	    smartphoneStock = p.getStocklevel();
	  }	
	}
		return smartphoneStock;
  }
}

