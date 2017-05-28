import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Product implements Serializable{
	private String p_ProductID;
	private String p_Name;
	private int p_SerialNum;
	private double p_Price;
	//private int p_Quantity;
	private Supplier p_Supplier;
	private String p_ExpiryDate;
	private double p_Discount;
	private double p_BulkDiscount;
	private String p_SupplierID;
	private int p_BulkDiscountNum;
	private String p_ProductType;
	private double p_PriceWeight;
	private double p_ProductWeight;
	
	Scanner keyboard = new Scanner(System.in);
	//ArrayList<Product> ppl = new ArrayList<Product>();
	
	public Product(){
	
	}
	
	/*public Product(Supplier s,String p_ProductID, String p_Name, int p_SerialNum, double p_Price, int p_Quantity, int i, double p_Discount, double p_BulkDiscount){
		p_Supplier = s;
		this.p_ProductID = p_ProductID;
		this.p_Name = p_Name;
		this.p_SerialNum = p_SerialNum;
		this.p_Price = p_Price;
		this.p_Quantity = p_Quantity;	
		this.p_SupplierID = p_Supplier.getSupplierID();
		this.p_Discount = p_Discount;
		this.p_BulkDiscount = p_BulkDiscount;
		
	} */
	
	public Product(Supplier s, String p_ProductID, String p_Name, String p_ProductType, int p_SerialNum, double p_Price, double p_Discount, int p_BulkDiscountNum, double p_BulkDiscount){
		
		p_Supplier = s;
		this.p_ProductID = p_ProductID;
		this.p_Name = p_Name;
		this.p_SerialNum = p_SerialNum;
		this.p_Price = p_Price;	
		this.p_SupplierID = p_Supplier.getSupplierID();
		this.p_Discount = p_Discount;
		this.p_ProductType = p_ProductType;
		this.p_BulkDiscount = p_BulkDiscount;
		this.p_BulkDiscountNum = p_BulkDiscountNum;
		
	}
	
	public Product(Supplier s, String p_ProductID, String p_Name, String p_ProductType, int p_SerialNum,  double p_Discount,  double p_PriceWeight){
		
		p_Supplier = s;
		this.p_ProductID = p_ProductID;
		this.p_Name = p_Name;
		this.p_SerialNum = p_SerialNum;
		this.p_SupplierID = p_Supplier.getSupplierID();
		this.p_Discount = p_Discount;
		//this.p_BulkDiscount = p_BulkDiscount;
		//this.p_BulkDiscountNum = p_BulkDiscountNum;
		this.p_ProductType = p_ProductType;
		this.p_PriceWeight = p_PriceWeight;
		
		
	}
	
/*	public void addProduct(){
		System.out.println("Please Enter ProductID: ");
		String ID = keyboard.nextLine();
		System.out.println("Please Enter Product Name: ");
		String Name = keyboard.nextLine();
		System.out.println("Please Enter Product Serial Number: ");
		int SerialNum = keyboard.nextInt();
		System.out.println("Please Enter Product Price: ");
		Double Price = keyboard.nextDouble();
		System.out.println("Please Enter Product Discount: ");
		Double Discount = keyboard.nextDouble();
		System.out.println("Please Enter Product Bulk Discount: ");
		Double BulkDiscount = keyboard.nextDouble();
		ppl.add(new Product( ID,Name,SerialNum, Price, Discount, BulkDiscount));
		
}
	*/
	
	
	public String toString() {
		return "\nProduct ID: " + p_ProductID +
				"\tName: " + p_Name +
				"\tSerial Number: " + p_SerialNum +
				"\tPrice: $" + p_Price + 
				"\tDiscount: " + p_Discount*100 + "%" +
				"\tBulk Discount: " + p_BulkDiscount*100 + "%" +"\n";
	}
	
	public void updateProductID (String newProductID){
		p_ProductID = newProductID;
	}
	
	public void updateProductName (String newProductName){
		p_Name = newProductName;
	}
	
	public void updateProductSerialNumber (int newProductSerialNumber){
		p_SerialNum= newProductSerialNumber;
	}
	
	public void updateProductPrice (double newProductPrice){
		p_Price = newProductPrice;
	}
	
	
	public void updateProductExpiryDate (String newProductExpiryDate){ // have to figure out how to type date into constructor
		p_ExpiryDate = newProductExpiryDate;
	}
	
	public void updateProductDiscount (double newProductDiscount){
		p_Discount = newProductDiscount;
	}
	
	public void updateProductBulkDiscount (double newProductBulkDiscount){
		p_BulkDiscount = newProductBulkDiscount;
	}
	
	public String getProductID(){
		return p_ProductID;
	}
	
	public double getProductPrice(){
		return p_Price;
	}
	
	public String getProductName(){
		return p_Name;
	}
	
	public double getDiscount(){
		return p_Discount;
	}
	
	public int getBulkDiscountNum(){
		return p_BulkDiscountNum;
	}
	
	public double getBulkDiscount(){
		return p_BulkDiscount;
	}
	
	public String getProductType(){
		return p_ProductType;
	}
	
	public double getPriceWeight(){
		return p_PriceWeight;
	}
	
	public double getProductWeight(){
		return p_ProductWeight;
	}
	
	

}