import java.io.Serializable;
import java.util.*;
public class SalesStaff extends Employee implements Serializable{
	public SalesStaff(String id,String name,String department,String gender, int dob, String email,long phoneNum,String password)
	{
		super(id,name, department, gender,dob, email, phoneNum, password);
	}
	
	public void removeItems(ArrayList shc_list,ShoppingCart shc){
		shc_list.remove(shc);
	}
	
	public void cancelTransaction(ArrayList shc_list,ShoppingCart shc){
		shc_list.removeAll(shc_list);
	}
	/*
	public String getPassword(){	
		return password;
	}
	*/

	}