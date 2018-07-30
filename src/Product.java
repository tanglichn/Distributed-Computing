import java.io.Serializable;

/**
 * Create a Product entity class
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String productname;
	private int stocklevel;
	private int productsales;
	
	public Product (){	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getStocklevel() {
		return stocklevel;
	}
	
	public void setStocklevel(int stocklevel) {
		this.stocklevel =stocklevel;
	}
    
	public String getProductname() {
		return productname;
	}
	
	public void setProductname(String productname) {
		this.productname=productname;
	}
	
	public int getProductsales() {
		return productsales;
	}
	
	public void setProductsales(int productsales) {
		this.productsales=productsales;
	}
	
	
}