import java.io.Serializable;

class Sales implements Serializable{
	// private int sa_productID;
	private String sa_productName;
	private int sa_productQuantity;
	private double sa_productPrice;
	private double sa_productRevenue;
	private double sa_productSales;
	private String sa_SalesID;
	private Product sa_Product;
	private ShoppingCart sa_ShoppingCart;
	private int totalQuantitySold;
	private int quantitySold;
	private Warehouse sa_Warehouse;
	//private int originalStock 
	private double totalRevenue;
	private String sa_ProductID;
	
	
	public Sales(String sa_SalesID, Product p, Warehouse  wa , ShoppingCart sc){
		
		sa_Warehouse = wa;
		sa_ShoppingCart = sc;
		sa_Product = p;
		this.sa_SalesID = sa_SalesID;
		sa_ProductID = wa.getProductID();
		
		quantitySold = wa.getStockSold();
		totalRevenue = quantitySold * sc.getPrice();
		
		//TotalQuantitySold
		//price from product
		//productID from product
		//totalRevenue
	}
	
	public String toString() {
		return "\nProduct ID: " + sa_ProductID +
				"\nQuantity Sold: " + quantitySold +
				"\nTotal Revenue " + totalRevenue;
	}
	
	public int calcQuantity(ShoppingCart sc){
		sa_ShoppingCart = sc;
		totalQuantitySold = sc.getQuantity();
		return totalQuantitySold;
	}
	
	
	
	public String getsa_ProductID(String productID){
		sa_ProductID = productID;
		return sa_ProductID;
	}
	public double caculatesa_Revenue(){
		sa_productRevenue = sa_productPrice * sa_productQuantity;
		return sa_productRevenue;
	}
	public int getsa_Quantity(int quantity){
		sa_productQuantity = quantity;
		return sa_productQuantity;
	}
	public double getsa_ProcuctPrice(double price){
		sa_productPrice = price;
		return sa_productPrice;
	}
	public double caculatesa_ProductSales(){
		sa_productSales += sa_productQuantity;
		return sa_productSales;
	}
	
}