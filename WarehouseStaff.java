import java.io.Serializable;
import java.util.*;

public class WarehouseStaff extends Employee implements Serializable{
	
	
	
	public WarehouseStaff(String id,String name,String department,String gender, int dob, String email,long phoneNum,String password)
	{
		super(id,name, department, gender,dob, email, phoneNum, password);
	}
	public void checkStockLevel(Warehouse wh){
		wh.toString();
	}
	
	public void updateStock(Warehouse wh){
		Scanner s1 = new Scanner(System.in);
		System.out.println("Please enter number to update stock level :");
		int a = s1.nextInt();		
		wh.updateStockLevel(a);
}
	
	

	
}