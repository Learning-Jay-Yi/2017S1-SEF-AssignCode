import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart implements Serializable{
	private String sh_cartID;

	private int sh_quantity;
	private double sh_productPrice;
	private String sh_itemName;
	// private date sh_date; // sth need to fix
	private double sh_weight;
	private double sh_totalPrice;
	private double sh_discount;
	private double sh_bulkDiscount;

	private Customer sh_Customer; // *
	private String sh_CustomerID; // *
	private Product sh_product; // *
	private String sh_ProductID; // *
	private String sh_ProductType;
	private double sh_PriceWeight;
	private double sh_ProductWeight;
	private int sh_BulkDiscountNum;

	// constructor

	public ShoppingCart() {

	}

	public ShoppingCart(Customer c, Product p /* */, String cartID, int quantity) {
		this.sh_cartID = cartID;
		sh_product = p; // *
		sh_Customer = c; // *
		this.sh_CustomerID = sh_Customer.getCustomerID();
		this.sh_ProductID = sh_product.getProductID(); // *
		this.sh_itemName = sh_product.getProductName(); // *
		this.sh_quantity = quantity;
		this.sh_productPrice = sh_product.getProductPrice(); // *
		sh_totalPrice = CaculateTotalPrice();
		this.sh_discount = sh_product.getDiscount();
		this.sh_bulkDiscount = sh_product.getBulkDiscount();
		sh_ProductType = sh_product.getProductType();
		sh_BulkDiscountNum = sh_product.getBulkDiscountNum();
	}

	public ShoppingCart(Customer c, Product p /* */, String cartID, double weight) {
		this.sh_cartID = cartID;
		sh_product = p; // *
		sh_Customer = c; // *
		this.sh_CustomerID = sh_Customer.getCustomerID();
		this.sh_ProductID = sh_product.getProductID(); // *
		this.sh_itemName = sh_product.getProductName(); // *
		this.sh_weight = weight;
		this.sh_productPrice = sh_product.getProductPrice(); // *
		sh_totalPrice = CaculateTotalPrice1();
		this.sh_discount = sh_product.getDiscount();

		sh_ProductType = sh_product.getProductType();
		sh_PriceWeight = sh_product.getPriceWeight();
		sh_ProductWeight = sh_product.getProductWeight();

	}

	ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();

	/*
	 * public void addItem(){ ShoppingCart sh1 = new
	 * ShoppingCart(sh_CartID,addProductID,addItemName,
	 * addquantity,addPrice,addWeight,addDiscount,addBulkDiscou nt);
	 * cart.add(sh1); }
	 */

	public double getPrice() {
		return sh_productPrice;
	}

	public int getQuantity() {
		return sh_quantity;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "\nCustomerID: " + sh_CustomerID + "\tCartID: " + sh_cartID + "\tProductID: " + sh_ProductID
				+ "\tProductName: " + sh_itemName + "\tQuantity: " + sh_quantity + "\tPrice: $" + sh_productPrice
				+ "\tWeight: " + sh_ProductWeight + "KG" + "\tDiscount: " + sh_discount + "% \tBulkDiscount: "
				+ sh_bulkDiscount + "% \tPriceWeight: $" + sh_PriceWeight + " per/kg" + "\tTotalPrice: $"
				+ df.format(CaculateTotalPrice()) + " \t \t \n";
	}
	public void toprint()
	{
		System.out.print("\nCustomerID: " + sh_CustomerID + "\tCartID: " + sh_cartID + "\tProductID: " + sh_ProductID + "\tProductName: " + sh_itemName);
		DecimalFormat df = new DecimalFormat("#.00");
		if(sh_ProductType.equals("U"))
		{
			System.out.println("\tQuantity: " + sh_quantity + "\tPrice: $" + sh_productPrice +"\tDiscount: "
					+ sh_discount + "% \tBulkDiscount: " + sh_bulkDiscount + "\tTotalPrice: $" + df.format(CaculateTotalPrice()) + " \t \t \n");
		}else if(sh_ProductType.equals("W"))
		{
					
			System.out.println("\tweight: " + sh_weight + "\tPriceWeight: $" + sh_PriceWeight +"\tDiscount: "
					+ sh_discount  + "\tTotalPrice: $" + df.format(CaculateTotalPrice1()) + " \t \t \n");
		}
		else
		{
			System.out.println("nnnn");
		}
		
		
	}
	private double CaculateTotalPrice1() {

		if (sh_discount == 0) {
			sh_totalPrice = (sh_weight * sh_PriceWeight);
		} else {
			sh_totalPrice = (sh_weight * sh_PriceWeight) * sh_discount;
		}

		return sh_totalPrice;

	}

	public double CaculateTotalPrice() {
		if (sh_bulkDiscount == 0 && sh_discount == 0) {
			// System.out.println( sh_quantity+ "\t");
			// System.out.println(sh_productPrice + "\t");
			sh_totalPrice = (sh_quantity * sh_productPrice);
			// System.out.println(sh_totalPrice + "\t");
			// System.out.println("====================1" + "\t");
		} else if (sh_bulkDiscount == 0) {
			sh_totalPrice = (sh_quantity * sh_productPrice) * sh_discount;
			// System.out.println(2 + "\t");
		} else if (sh_discount == 0) {
			sh_totalPrice = (sh_quantity * sh_productPrice) * sh_bulkDiscount;
			// System.out.println(3 + "\t");
		} else {
			sh_totalPrice = ((sh_quantity * sh_productPrice) * sh_discount) * sh_bulkDiscount;
			// System.out.println(4 + "\t");

		}

		return sh_totalPrice;
	}

	public double getTotalPrice() {
		return sh_totalPrice;
	}

	public String getCartID() {
		return sh_cartID;
	}
	/*
	 * ArrayList <ShoppingCart> cartList; public addList(){ cartList = new
	 * ArrayList <ShoppingCart>(); cartList.add(sh); // return cartList;
	 */
	public double getWeight(){
		return sh_ProductWeight;
	}

	public String getProID() {
		// TODO Auto-generated method stub
		return sh_ProductID;
	}
}