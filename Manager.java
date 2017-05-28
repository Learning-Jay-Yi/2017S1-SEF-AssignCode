// package main;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Manager extends Employee implements Serializable
{
	
	public Manager(String id,String name,String department,String gender, int dob, String email,long phoneNum,String password)
	{
		super(id,name, department, gender,dob, email, phoneNum, password);
	}
	
	public void addProduct(ArrayList<Product> p_List,Product p)
	{
		p_List.add(p);
	}
	
	public void removeProduct(ArrayList<Product> p_List,Product p)
	{
		if(p_List.contains(p))
		{
			p_List.remove(p);
		}
		else
		{
			System.out.println("No such product in the DB");
		}
	}
	
	public void updateProductPrice(ArrayList<Product> p_list,Product p, double price)
	{
		int size = 0;
		String id = "";
		if(p_list.contains(p))
		{
			
			
			for(int i = 0;i<p_list.size();i++)
			{	
				System.out.println("============================");
				id = p_list.get(i).getProductID();
				if(id.equals(p.getProductID()))
				{
					p_list.get(i).updateProductPrice(price);
					System.out.println("Price Change");
					System.out.println("New Price :" +p_list.get(i).getProductPrice());
				}
			}
		}
		else
		{
			System.out.println("No such product in the DB");
		}		
	}
	
	
	public void updateProductDiscont(ArrayList<Product> p_list,Product p, double discount)
	{
		//int size = 0;
		if(p_list.contains(p))
		{
			for(int i = 0;i<p_list.size();i++)
			{
				String id = p_list.get(i).getProductID();
				if(id.equals(p.getProductID()))
				{
					p_list.get(i).updateProductDiscount(discount);
					System.out.println("Product Discount Changed");					
				}
			}
		}
		else
		{
			System.out.println("No such product in the DB");
		}	
	}
	public void updateProductBuckDiscount(ArrayList<Product> p_list,Product p, double bulkDiscount)
	{
		//int size = 0;
		if(p_list.contains(p))
		{
			for(int i = 0;i<p_list.size();i++)
			{
				String id = p_list.get(i).getProductID();
				if(id.equals(p.getProductID()))
				{
					p_list.get(i).updateProductBulkDiscount(bulkDiscount);
					System.out.println("Product Bulk Discount Changed");					
				}
			}
		}
		else
		{
			System.out.println("No such product in the DB");
		}		
	}


}