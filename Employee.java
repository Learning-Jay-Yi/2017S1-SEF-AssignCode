import java.io.Serializable;

// package main;

public class Employee implements Serializable
{
	protected String e_ID;
	protected String e_name;
	protected String e_department;
	protected String e_gender;
	protected int e_DOB;
	protected String e_Email;
	protected long e_phoneNum;
	protected String e_password;
	//private String e_login_statues;
	
	public Employee()
	{
		
	}
	
	public Employee(String id,String name,String department,String gender, int dob, String email,long phoneNum,String password)
	{
		this.e_ID = id;
		this.e_name = name;
		this.e_department = department;
		this.e_gender = gender;
		this.e_DOB = dob;
		this.e_Email = email;
		this.e_phoneNum = phoneNum;
		this.e_password = password;
		//this.e_login_statues = login;
	}
	// ID functions
	public void setID(String id){this.e_ID = id;}
	public String getID(){return e_ID;}
	
	// Name functions	
	public void setName(String name){this.e_name = name;}
	public String getName(){return e_name;}
	
	// Department functions	
	public void setDepartment(String department){this.e_department = department;}
	public String getDepartment(){return e_department;}
	
	// Gender functions	
	public void setGender(String gender){this.e_gender = gender;}
	public String getGender(){return e_gender;}
	
	// Date of Birth functions
	public void setDOB(int dob){this.e_DOB = dob;}
	public int getDOB(){return e_DOB;}
	
	// Email functions	
	public void setEmail(String email){this.e_Email = email;}
	public String getEmail(){return e_Email;}	
	
	//Phone functions
	public void setPhone(long phone_Num){this.e_phoneNum = phone_Num;}
	public long getPhone(){return e_phoneNum;}	
	
	//Password functions
	public void setPsd(String password){this.e_password = password;}
	public String getPsd(){return e_password;}	
	
	// To String
	public String displayAll()
	{
		return "EMPLOYMENT ID: "+ e_ID+"\n" + "EMPLOYMENT NAME: "+e_name+"\n" + "EMPLOYMENT DEPARTMENT: " 
				+ e_department +"\n"+"EMPLOYMENT GENDER: "+e_gender+"\n"+"EMPLOYMENT EMAIL: "+e_Email+"\n" 
				+"EMPLOYMENT DOB: "+ e_DOB+"\n";
	}

}