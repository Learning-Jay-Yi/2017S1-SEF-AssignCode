// package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	/* the attributes of customer */
	private String name;
	private String customerNumber;
	private String address;
	private int phoneNumber;
	private char gender;
	private String dateOfBirth;
	private String eMail;
	private int points;
	private String c_password;

	/* construct a customer */
	public Customer() {

	}
    //Constructor to use when adding a new customer where points is set to 0
	public Customer(String name, String customerNumber, String address, int phoneNumber, char gender,
			String dateOfBirth, String eMail) {
		this.name = name;
		this.customerNumber = customerNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.eMail = eMail;
		this.points = 0;
	}
	
	
	
	//Constructor to use to add customer with points for testing
	public Customer(String name, String customerNumber, String address, int phoneNumber, char gender,
			String dateOfBirth, String eMail, int points, String password) {
		this.name = name;
		this.customerNumber = customerNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.eMail = eMail;
		this.points = points;
		c_password = password;
	}

	@Override
	public String toString() {
		return "Customer Name = " + name + "\nCustomer Number = " + customerNumber + "\nAddress = " + address
				+ "\nPhone Number = " + phoneNumber + "\nGender = " + gender + "\nDate of Birth = " + dateOfBirth
				+ "\nEmail = " + eMail + "\nPoints = " + points;
	}

	public void searchProductPrice(ArrayList<Product> ppl, String ProductID) {
		for (int i = 0; i < ppl.size(); i++) {

			if (ppl.get(i).getProductID().equals(ProductID)) {
				System.out.println("The price of product ID " + ProductID + " is: $" + ppl.get(i).getProductPrice());

			}
		}

	}

	public void searchProductDiscount(ArrayList<Product> ppl, String ProductID) {
		for (int i = 0; i < ppl.size(); i++) {

			if (ppl.get(i).getProductID().equals(ProductID)) {
				System.out.println("The discount for product ID " + ProductID + " is " + (ppl.get(i).getDiscount() * 100) + "% and the Bulk discount for this product is " + (ppl.get(i).getBulkDiscount() * 100) + "% if you buy " +(ppl.get(i).getBulkDiscountNum()) + " amount");

			}
		}

	}

	/*
	 * double p is points which customer get from current transaction this
	 * method tries to add current transaction points with historical points
	 */
	public double plusPoints(double p) {
		points += p;
		return points;
	}

	/*
	 * double p is points which will be used in current transaction this method
	 * tries to subtract current transaction points from historical points
	 */
	public double minusPoints(double p) {
		points -= p;
		return points;
	}

	/* get method for each element */
	public String getName() {
		return name;
	}

	public String getCustomerID() {
		return customerNumber;
	}

	 public String getAddress() {
		return address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public char getGender() {
		return gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String geteMail() {
		return eMail;
	}

	public int getPoints() {
		return points;
	}

	/* change value for each element */
	public void updateName(String name) {
		this.name = name;
	}

	public void updateCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void updateAddress(String address) {
		this.address = address;
	}

	public void updatePhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void updateGender(char gender) {
		this.gender = gender;
	}

	public void updateDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void updateEmail(String eMail) {
		this.eMail = eMail;
	}

	public void updatePoints(int points) {
		this.points = points;
	}
	public String getPassword(){
		return c_password;
	}
}