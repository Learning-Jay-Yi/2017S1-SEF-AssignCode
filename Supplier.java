// package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Supplier implements Serializable{
	String s_SupplierID;
	private String s_ContactName;
	private String s_Company;
	private String s_Email;
	private String s_Phone;
    
	ArrayList<Product> ppl = new ArrayList<Product>();
	  //ArrayList<Supplier> spl = new ArrayList<Supplier>();
	//Scanner keyboard = new Scanner(System.in);
	public Supplier()
	{
		
	}
	public Supplier (String s_SupplierID, String s_ContactName, String s_Company, String s_Email, String s_Phone){
		
		this.s_SupplierID = s_SupplierID;
		this.s_ContactName = s_ContactName;
		this.s_Company = s_Company;
		this.s_Email = s_Email;
		this.s_Phone = s_Phone;
		
	}
	

	
	/*int n =0 ;
	
	public void addSupplier(){
		System.out.println("Please Enter Supplier ID: ");
		String ID = keyboard.nextLine();
		 
		System.out.println("Please Enter Name: ");
		String Name = keyboard.nextLine();
		System.out.println("Please Enter Company Name: ");
		String Company = keyboard.nextLine();
		System.out.println("Please Enter Email: ");
		String Email = keyboard.nextLine();
		System.out.println("Please Enter Phone: ");
		String Phone = keyboard.nextLine();
		spl.add(new Supplier(ID,Name,Company,Email,Phone));
		n +=1;
		
		//System.out.print(spl.get(0));
		 System.out.println(spl);
	}
	
	public void removeSupplier(){
		System.out.println("Please enter ID to remove");
	    String sID = keyboard.nextLine();
	    System.out.println("1"+ spl.get(0).s_SupplierID);
		System.out.println("2"+sID);
		/*for (int i = 0; i < spl.size(); i++)
		
			if (spl.get(i).s_SupplierID.equals(sID)){
				System.out.println("right");
				System.out.println(i);
				System.out.print("Which index u want to delete?");
				
				spl.remove(n);
			}
		
		System.out.println(spl.toString());
		System.out.print("Company?");
		String company = keyboard.nextLine();
		int n = keyboard.nextInt();
		spl.get(n).updateCompany(company);
		System.out.println(spl.toString());
	}
	
	public void updateCompany(){
		System.out.println("Please enter ID to update");
		String sID = keyboard.nextLine();
		for (int i = 0; i < spl.size(); i++){
			
			if (spl.get(i).s_SupplierID.equals(sID)){
				System.out.print("Company?");
				String company = keyboard.nextLine();
				spl.get(i).updateCompany(company);
				System.out.println(spl.toString());
			}
			
		}
	}
	
	public void updateContactName(){
		System.out.println("Please enter ID to update Contact Name");
		String ID = keyboard.nextLine();
		for (int i = 0; i < spl.size(); i++){
			
			if (spl.get(i).s_SupplierID.equals(ID)){
				System.out.print("Enter a new Contact Name");
			    String CName = keyboard.nextLine();
				spl.get(i).updateContactName(CName);
				System.out.println(spl.toString());
			}
			
		}
	}
	
	public void updateEmail(){
		System.out.println("Please enter ID to update Email");
		String ID = keyboard.nextLine();
		for (int i = 0; i < spl.size(); i++){
			
			if (spl.get(i).s_SupplierID.equals(ID)){
				System.out.print("Enter a new Email");
				String Email = keyboard.nextLine();
				spl.get(i).updateEmail(Email);
				System.out.println(spl.toString());
			}
			
		}
	}
	
	public void updatePhone(){
		System.out.println("Please enter ID to update Phone Number");
		String ID = keyboard.nextLine();
		for (int i = 0; i < spl.size(); i++){
			
			if (spl.get(i).s_SupplierID.equals(ID)){
				System.out.print("Enter a new Phone Number");
				String Phone = keyboard.nextLine();
				spl.get(i).updatePhone(Phone);
				System.out.println(spl.toString());
			}
			
		}
	}  
	*/
	
	public String toString() {
		return "\nSupplier ID: " + s_SupplierID +
				"\tContact Name: " + s_ContactName +
				"\tCompany: " + s_Company +
				"\tEmail: " + s_Email +
				"\tPhone: " + s_Phone;
	}
	public void updateContactName (String newContact){
		s_ContactName = newContact;
	}
	
	public void updateCompany (String newCompany){
		s_Company = newCompany;
	}
	public void updateEmail (String newEmail){
		s_Email = newEmail;
	}
	public void updatePhone (String newPhone){
		s_Phone = newPhone;
	}
	
	public String getSupplierID() {
		
		return s_SupplierID;
	}
	

		
		
		
	
	
	}