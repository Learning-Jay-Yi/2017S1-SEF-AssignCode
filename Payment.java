import java.io.Serializable;

class Payment implements Serializable{
	Customer c = new Customer();
	ShoppingCart sh = new ShoppingCart();
	
	private String py_customerID;
	private String py_PaymentID;
	
	private double py_currentPoints;
	private int py_pointEarned;
	// $10 = 1 point, 20 point = $5 discount
	
	// get from product
	private Product sh_product; //*
	private String sh_ProductID; //*
	// get from customer
	private Customer sh_Customer;
	private String sh_CustomerID;
	//get from shoppingCart
	private int py_Quantity;
	private double py_totalAmount;
	private double py_ProductPrice;
	private double py_calcAmount;
	private double py_productWeight;
	private ShoppingCart py_ShoppingCart;
	private double discPoints;
	private int currentPoints;
	private double finalDiscount;
	private double totalAfterPoint;
	private String sh_CartID;
	private double pointsUsed;
	
	public Payment(){
	
	}
	
	
	
	public Payment(ShoppingCart s, Customer c){
		py_ShoppingCart = s;
		sh_Customer = c;
		sh_CartID = s.getCartID();
		
		py_Quantity = s.getQuantity();
		py_totalAmount = s.getTotalPrice();
		py_pointEarned = calculatePointsEarned(py_totalAmount);
		sh_CustomerID = c.getCustomerID();
		currentPoints = c.getPoints();
		finalDiscount = calcPointDiscount(currentPoints);
		py_productWeight = s.getWeight();
		// this.py_totalAmount = py_totalAmount;
		
	}
	
	
	public void setTotalPrice(double amt){
		py_totalAmount = amt; 
	}
	
	public String toString(){
		return "Your payment comes to a total of: " + py_totalAmount + "\nand your points can save: " + finalDiscount  + "\nIf you use your points you would only pay: " + (py_totalAmount - finalDiscount) ;
	}
	
	
	public double calcPointDiscount(double p){ //new 
		double diff = p%20;
		pointsUsed = p - diff; 
		discPoints = ((pointsUsed/20)*5);
		return discPoints;
		
	}
	
	public int calculatePointsEarned(double p_totalAmount){
		int points2 = (int) (py_totalAmount - (py_totalAmount%10));
		py_pointEarned = points2/10;
		return py_pointEarned;
	}
	
	public int getPointsEarned(){ //new
		return py_pointEarned;
	}
	
	public double calcPointsUsed(double p){
		pointsUsed = p - (p%20);
		return pointsUsed;
	}
	
	
	public double getPointsUsed(){ //new
		return pointsUsed;
	}
	
	//public void calcPriceAfterPoints(){
	//	py_finalPrice = py_totalAmount - discPoints;
	//}
	
	
	
	public int getQuantity(){
		return py_Quantity;
	}
	
	public double getTotal(){
		return py_totalAmount;
	}
	
	public String getCartID(){
		return sh_CartID;
	}
	
	public double calcTotalAfterPoint(){
		System.out.println("total : " + py_totalAmount + " final Discouunt: " + finalDiscount);
		totalAfterPoint = py_totalAmount - finalDiscount;
		return totalAfterPoint;
	}
	
	public double getTotalAfterPoint(){
		return totalAfterPoint;
	}
	
	
	
	public double getAmount(ShoppingCart sh){
		py_totalAmount = sh.CaculateTotalPrice();
		return py_totalAmount;
	}
	/*
	public String toString(){
		
		System.out.printf("CustomerId: %s \tTotalAmount: $ %4.2f \tCurrentPoint: %4.2f \tPointEarned: %4.2f", 
				py_customerID, py_totalAmount, py_currentPoints, py_pointEarned);
	} */
	
	/*public String toString() {
		return "\nPayment ID: " + py_PaymentID+
				"\nTotal Amount: " + py_totalAmount +
				"\nPoints Earned: " + py_pointEarned;
	}*/
	
	public double getTotalAmount(double totalAmount){
		
		py_totalAmount = totalAmount;
		return py_totalAmount;
	}

	
	public double getCurrentPoint(double currentPoint){
		py_currentPoints = currentPoint;
		return py_currentPoints;
	}
	public String getCustomerID(){
		return py_customerID;
	}
	/*
	public double getEarnePoing(double point){
		py_pointEarned = point;
		return py_pointEarned;
	}
	*/
	// public String get



	public double getPy_productWeight() {
		
		return py_productWeight;
	}
}