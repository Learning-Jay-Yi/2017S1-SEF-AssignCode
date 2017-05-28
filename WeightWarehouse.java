import java.io.Serializable;

public class WeightWarehouse extends Warehouse implements Serializable
{
	private double wh_weightLevel;
	private double wh_weightThresholdLevel;
	private double wh_maxWeightLevel;
	private double wh_weightSold;
	
	
	public WeightWarehouse(Product p, double wh_weightLevel, double wh_weightThresholdLevel, double wh_maxWeightLevel)
	{
		super(p);
		this.wh_weightLevel = wh_weightLevel;
		this.wh_weightThresholdLevel = wh_weightThresholdLevel;
		this.wh_maxWeightLevel = wh_maxWeightLevel;
	}
	
	@Override
	public String toString()
	{
		 return "\nProduct ID: " + super.getProductID() +
				"\nStock Level: " + wh_weightLevel +
				"\nRestock level: " + wh_weightThresholdLevel;
	}

	/*check the stock weight level*/
	public boolean overThresholdLevel(){
		if(wh_weightLevel < wh_weightThresholdLevel){
			System.out.println("Warning! Product" + super.getProductID()+ "has lower stock level");
			return false;
		}
		else{
			return true;
		}
	}
	
	
	
	/*Automatically reorder*/
	public void reorder()
	{
		if(this.overThresholdLevel()){
			
		}else{
			System.out.println("Stock Level is low, Making an order to purchasing");
			
			
		}
		
	}
	
	
	public double updateStockLevel(double a)
	{
		return wh_weightLevel += a;
		
	}
	
	public double calcWeightSold(){
		
		return wh_weightSold = wh_maxWeightLevel - wh_weightLevel;
	
	}
	
	public double weightAfter(Payment py){
		return wh_weightLevel -= py.getPy_productWeight();
	}

	public void setWh_weightLevel(double wh_weightLevel) {
		this.wh_weightLevel = wh_weightLevel;
	}


	public void setWh_weightThresholdLevel(double wh_weightThresholdLevel) {
		this.wh_weightThresholdLevel = wh_weightThresholdLevel;
	}


	public void setWh_maxWeightLevel(double wh_maxWeightLevel) {
		this.wh_maxWeightLevel = wh_maxWeightLevel;
	}


	public void setWh_weightSold(double wh_weightSold) {
		this.wh_weightSold = wh_weightSold;
	}


	public double getWh_weightLevel() {
		return wh_weightLevel;
	}


	public double getWh_weightThresholdLevel() {
		return wh_weightThresholdLevel;
	}


	public double getWh_maxWeightLevel() {
		return wh_maxWeightLevel;
	}


	public double getWh_weightSold() {
		return wh_weightSold;
	}	
}