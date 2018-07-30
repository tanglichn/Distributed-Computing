import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

/**
 * Create a client to find remote objects and invoke methods.
 * 
 * @author Li Tang
 * @version 2018.02.15
 */
public class BranchClient {
	
	public static void main(String args[]) throws Exception
	{
		BranchInterface Bra = (BranchInterface) Naming.lookup("rmi://10.245.132.114:6668/Bra");
		
	    System.out.println("1: Access product information;");
	    System.out.println("2: Access customer information;");
	    System.out.println("3: buy smartphones;");
	    System.out.println("4: buy laptops;");
	    System.out.println("5: buy desktopcomputers;");
	    System.out.println("0: Exit;");
	   
	    @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    int input = in.nextInt();
	    switch (input) {
	      case 0:
	        System.out.println("Thank you for your coming");
	        break;
	      case 1:
	    	  List<Product> productList = Bra.getProductList();
	    	  for (Product p:productList) {
	    		  
	    			 System.out.println("id: "+p.getId()+", productname: "+p.getProductname()+", stocklevel: "+p.getStocklevel()+", productsales: "+p.getProductsales()); 	  
	    	  }
	    	  break;
	      case 2:
	    	  List<Customer> customerList = Bra.getCustomerList();
	    	  for (Customer c:customerList) {
	    		  System.out.println("customerid: "+c.getCustomerid()+", customername: "+c.getCustomername()+", purchasehistory: "+c.getPurchasehistory()); 
	    	  }
	    	  break;
	      case 3:
	    	  int smartnum=in.nextInt();
	    	  int smartphonestock = Bra.requestStock("smartphone", smartnum);
	    	  if (smartphonestock==-1) {
	    		  System.out.println("you can purchase in shop");
	    	  }
	    	  else if(smartphonestock==0) {
	    		  System.out.println("you can request enough stock in Banana HQ");
	    	  }
	    	  else if (smartphonestock==1) {
	    		  System.out.println("you can not request enough stock in Banana HQ");  
	    	  }
	    	  break;
	      case 4:
	    	  int laptopnum=in.nextInt();
	    	  int laptopstock = Bra.requestStock("laptop", laptopnum);
	    	  if (laptopstock==-1) {
	    		  System.out.println("you can purchase in shop");
	    	  }
	    	  else if(laptopstock==0) {
	    		  System.out.println("you can request enough stock in Banana HQ");
	    	  }
	    	  else if (laptopstock==1) {
	    		  System.out.println("you can not request enough stock in Banana HQ");  
	    	  }
	    	  break;
	      case 5:
	    	  int desktopnum=in.nextInt();
	    	  int desktopcomputerstock = Bra.requestStock("desktop computer", desktopnum);
	    	  if (desktopcomputerstock==-1) {
	    		  System.out.println("you can purchase in shop");
	    	  }
	    	  else if(desktopcomputerstock==0) {
	    		  System.out.println("you can request enough stock in Banana HQ");
	    	  }
	    	  else if (desktopcomputerstock==1) {
	    		  System.out.println("you can not request enough stock in Banana HQ");  
	    	  }
	    	  break;	      
	}
}
}