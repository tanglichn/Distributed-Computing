import java.io.Serializable;

/**
 * Create a Customer entity class
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class Customer implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerid;
	private String customername;
	private String purchasehistory;
	
	public int getCustomerid() {
		return customerid;
	}
	
	public void setCustomerid(int customerid) {
		this.customerid=customerid;
	}
	
	public String getCustomername() {
		return customername;
	}
	
	public void setCustomername(String customername) {
		this.customername=customername;
	}
	
	public String getPurchasehistory() {
		return purchasehistory;
	}
	
	public void setPurchasehistory(String purchasehistory) {
		this.purchasehistory=purchasehistory;
	}

}
