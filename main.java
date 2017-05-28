// package main;

import java.util.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.*;

public class main {

	// Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException { // testing add/update/remove on
												// supplier

		Scanner input = new Scanner(System.in);
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//
		// System Database
		//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		ArrayList<Supplier> spl = new ArrayList<Supplier>();
		ArrayList<ShoppingCart> cpl = new ArrayList<ShoppingCart>();
		ArrayList<Customer> cul = new ArrayList<Customer>();
		ArrayList<Warehouse> wal = new ArrayList<Warehouse>();
		ArrayList<Sales> sal = new ArrayList<Sales>();
		ArrayList<Product> ppl = new ArrayList<Product>();
		ArrayList<Manager> mspl = new ArrayList<Manager>();
		ArrayList<SalesStaff> sspl = new ArrayList<SalesStaff>();
		ArrayList<WarehouseStaff> wspl = new ArrayList<WarehouseStaff>();
		ArrayList<Payment> pyl = new ArrayList<Payment>();
		
		/*
		 * 
		 */
		
		/*
		try {
			// Supplier spl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Supplier.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			spl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Supplier.txt>");
		}

		try {
			// ShoppingCart cpl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/ShoppingCart.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cpl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <ShoppingCart.txt>");
		}
		try {
			// Customer cul
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Customer.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cul = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Customer.txt>");
		}

		try {
			// Warehouse wal
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Warehouse.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			wal = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Warehouse.txt>");
		}
		try {
			// Sales sal
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Sales.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			sal = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Sales.txt>");
		}

		try {
			// Product ppl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Product.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ppl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Product.txt>");
		}
		
		try {
			// Manager mspl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Manager.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			mspl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Manager.txt>");
		}
		
		try {
			// SalesStaff sspl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/SalesStaff.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			sspl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <SalesStaff.txt>");
		}
		
		try {
			// WarehouseStaff wspl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/WarehouseStaff.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			wspl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <WarehouseStaff.txt>");
		}
		try {
			// Payment pyl
			FileInputStream fis = new FileInputStream("/Users/KBOY/Documents/workspace/Data/Payment.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			pyl = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			System.out.println("Can not find <Payment.txt>");
		}
		*/
		
		/*
		 * 
		 */
		// this method just for loading data
		loadData(spl,cpl,cul,wal,sal,ppl,mspl,sspl,wspl,pyl);
		
		

		/***************************************************************
		 * 
		 * Program Start Point
		 * 
		 ***************************************************************/
		int option = 0;
		boolean test = false; // a switch to control loop.
		Product product = new Product();
		Supplier spID = new Supplier();
		Customer cID = new Customer();
		ShoppingCart shID = new ShoppingCart();
		Payment py = new Payment();
		int CartNum = 0;
		String cartID;
		// Product product = new Product();
		do { // System start running.
			String userID;
			do { // Check login information until all input is valid.
				do { // Check userID until is a valid ID
					System.out.println("\t**********\tWelcome!\t**********");
					System.out.print("\tPlease enter your ID:");
					userID = input.nextLine();
					if (userID.length() <= 0) {
						System.out.println("\tYour input is invalid, please try again.");
						userID = input.nextLine();
					}	
				} while (userID.length() <= 0); // do a loop until input not
												// null
				/***************************************************************
				 * 
				 * Login Verification
				 * 
				 ***************************************************************/
				switch (userID.toUpperCase().charAt(0)) {
				// Check Customer ID
				case 'C':
					for (int i = 0; i < cul.size(); i++) {
						// System.out.println("for loop++++++++=="+i);
						if (cul.get(i).getCustomerID().equalsIgnoreCase(userID)) {
							System.out.print("\tPlease enter your password: ");
							String password = input.nextLine();
							if (cul.get(i).getPassword().equals(password)) {
								cID = cul.get(i);
								CartNum++;
								test = true;
								break;
							} else {
								System.out.println("\tYour password is invalid, please try again.");
								// password = input.nextLine();
								break; // go to do while loop.
							}
						} else {
							System.out.println("\tYour ID is invalid, please try again.");
							break; // go to do while loop.
						}
					}
					// input.nextLine();
					option = 1;
					break;
				// Check Manager ID
				case 'M':
					for (int i = 0; i < mspl.size(); i++) {
						// System.out.println("for loop++++++++=="+i);
						if (mspl.get(i).getID().equalsIgnoreCase(userID)) {
							System.out.print("\tPlease enter your password:");
							String password = input.nextLine();
							if (mspl.get(i).getPsd().equals(password)) {
								test = true;
								break;
							} else {
								System.out.println("\tYour password is invalid, please try again.");
								// password = input.nextLine();
								break; // go to do while loop.
							}
						} else {
							System.out.println("\tYour ID is invalid, please try again.");
							break; // go to do while loop.
						}
					}
					option = 2;
					break;
				// Check Warehouse ID
				case 'W':
					for (int i = 0; i < wspl.size(); i++) {
						// System.out.println("for loop++++++++=="+i);
						if (wspl.get(i).getID().equalsIgnoreCase(userID)) {
							System.out.print("\tPlease enter your password:");
							String password = input.nextLine();
							if (wspl.get(i).getPsd().equals(password)) {
								test = true;
							} else {
								System.out.println("\tYour password is invalid, please try again.");
								// password = input.nextLine();
								break; // go to do while loop.
							}
						} else {
							System.out.println("\tYour ID is invalid, please try again.");
							break; // go to do while loop.
						}
					}
					option = 3;
					break;
				case 'E':
					System.out.print("\tYou input start With 'E', do you want exit ? yes/no ");
					boolean bExit = false;
					do{
						String exit = input.nextLine();
						
						if(exit.equalsIgnoreCase("yes")){
							option = 0;
							bExit = true;
							test = true;
							System.out.println("\tSee you.");
						}else if (exit.equalsIgnoreCase("no"))
							bExit = true;
						else
							System.out.println("\tPlease enter yes / no .");
							
					}while(!bExit);
					saveSupplier(spl);
					saveShoppingCart(cpl);
					saveCustomer(cul);
					saveWarehouse(wal);
					saveSales(sal);
					saveProduct(ppl);
					saveManager(mspl);
					saveSalesStaff(sspl);
					saveWarehouseStaff(wspl);
					savePayment(pyl);
					
					break;
				default:
					System.out.println("\tYour input is invalid, please try again.");
					break;

				}

			} while (!test);
			
			test = false;
			// ++++++++++++++++++++++++++++++++++++++++++Verfication
			// END+++++++++++++++++++++++++++++++++++++++++++++++++

			// ++++++++++++++++++++++++++++++++++++++++++ Mian program
			// +++++++++++++++++++++++++++++++++++++++++++++++++

			switch (option) {
			/***************************************************************
			 * 
			 * Customer Functions
			 * 
			 ***************************************************************/
			case 1: // Customer Menu
				int cusOption = 0;
				do {
					// input.nextLine();
					System.out.println("\t**********\tCustomer\t**********");
					System.out.println("\t1\tCheck product Price");
					System.out.println("\t2\tCheck product Discount");
					System.out.println("\t3\tShopping Cart");
					System.out.println("\t0\tLog out");
					System.out.print("\twhich option you want to pick?");
					do { // loop for check input is valid.open
						try { // customer option
							cusOption = input.nextInt();

						} catch (InputMismatchException ime) {
							System.out.println("\tYour input is invalid, please try again.");
						}
						if (cusOption >= 0 && cusOption < 6) {
							test = true;

						} else {
							System.out.println("\tYour input is invalid, please try again.");
						}

					} while (!test);
					// loop for check input is valid.close
					test = false;

					switch (cusOption) {
					/***************************************************************
					 * Check Product Price
					 ***************************************************************/
					case 1: // customer case 1 Check product price. open
						input.nextLine();
						System.out.print("Enter ProductID to show price");
						String peID = input.nextLine();
						int b = 0; // just for print if there not product exists
						for (int j = 0; j < ppl.size(); j++) {

							if (ppl.get(j).getProductID().equalsIgnoreCase(peID)) {
								b = 1; 
								System.out.println("\tProduct: "+ ppl.get(j).getProductName()
										+ "\n\tUnit price is: $" + ppl.get(j).getProductPrice()
										+ "\n\tWeight price is $" + ppl.get(j).getPriceWeight() + "per/kg");
							}
						}
						if (b == 0 )
							System.out.println("We do not have this product.");
						break;
					// customer case 1 Check product price. close
					/***************************************************************
					 * Check Product Weight
					 ***************************************************************/
					case 2:// customer case 2 Check product weight. open
						input.nextLine();
						System.out.print("Enter ProductID to show price");
						String prID = input.nextLine();
						int c = 0; // just for print if there not product exists
						for (int j = 0; j < ppl.size(); j++) {

							if (ppl.get(j).getProductID().equalsIgnoreCase(prID)) {
								c = 1; 
								System.out.print("\tProduct: "+ ppl.get(j).getProductName()
										+ "\n\tBulkDiscount is  "+ppl.get(j).getBulkDiscount()
										+ " for buy over: " + ppl.get(j).getBulkDiscountNum()
										+ "\n\tNormal discount: " + (1 - ppl.get(j).getDiscount())*100 + "%");
							}
						}
						if (c == 0 )
							System.out.println("\tWe do not have this product.");
						break;
					// customer case 2 Check product weight. close

					/***************************************************************
					 * Add Product to Shopping Cart
					 ***************************************************************/
					case 3: // customer case 3 add product. open
						int addOption = 0; // add item option
						do {
							System.out.println("\t**********\tShopping Cart\t**********");
							System.out.println("\t1\tAdd item by productID and quantity");
							System.out.println("\t2\tAdd item by productID and Weight");
							System.out.println("\t3\tList Shoping Cart");
							System.out.println("\t4\tRequest assistant");
							System.out.println("\t5\tCheckout");
							System.out.println("\t0\tBack to customer menu");
							System.out.print("\twhich option you want to pick?");
							do {
								try {
									addOption = input.nextInt();

								} catch (InputMismatchException ime) {
									System.out.println("\tYour input is invalid, please try again.");
								}
								if (addOption >= 0 && addOption < 6) {
									test = true;

								} else {
									System.out.println("\tYour input is invalid, please try again.");
								}
							} while (!test);
							test = false;

							switch (addOption) {
							/***************************************************************
							 * Add Product by ID
							 ***************************************************************/
							case 1: // Add Product by Product ID . open
								input.nextLine(); // new line

								cartID = "Cart" + Integer.toString(CartNum);
								System.out.println("**********\tAdd item by product ID\t**********\n");
								for (int i = 0; i < ppl.size(); i++) {
									if (ppl.get(i).getProductType().equals("U")) {
										System.out.println(ppl.get(i).toString());
									}
								}
								// System.out.println(ppl.toString());
								System.out.print("Enter ProductID for adding: ");
								String proID;
								do {
									boolean a = false;
									proID = input.nextLine();
									for (int i = 0; i < ppl.size(); i++) {
										if (ppl.get(i).getProductID().equals(proID)) {
											a = true;
										} else {
											System.out.println("\tYour input is invalid, please try again.");
										}
										if (a) {
											product = ppl.get(i);
											test = true;
											System.out.println("\tProduct is " + product.toString());
											break;
										}

									}
								} while (!test);
								test = false;

								// looking for the product ID

								int n = 0;
								do { // loop for check input is valid.open
									try { // customer option
										System.out.print("\tHow many quantity you want to buy: ");
										n = input.nextInt();
										test = true;
									} catch (InputMismatchException ime) {
										System.out.println("\tYour input is invalid, please try again.");
									}
								} while (!test);
								// loop for check input is valid.close
								test = false;
								input.nextLine();
								System.out.println("Item added successfully!");
								cpl.add(new ShoppingCart(cID, product, cartID, n)); 
								// carID can increase 1 every time go inside this case.
								/* System.out.println(cpl.toString()); */
								for (int j = 0; j < cpl.size(); j++) {
									cpl.get(j).toprint();
								}
								break;

							/***************************************************************
							 * Add product by Weight
							 ***************************************************************/
							case 2: // add product by Weight. open

								input.nextLine();// new line
								cartID = "Cart" + Integer.toString(CartNum);
								System.out.println("*****\tList product which need Weight\t*****\n");
								for (int i = 0; i < ppl.size(); i++) {
									if (ppl.get(i).getProductType().equals("W")) {
										System.out.println(ppl.get(i).toString());
									}
								}
								System.out.print("Enter ProductID for adding to cart: ");
								String proID1; // = input.nextLine();

								do {
									boolean a = false;
									proID1 = input.nextLine();
									for (int i = 0; i < ppl.size(); i++) {
										if (ppl.get(i).getProductID().equals(proID1)) {
											a = true;
										} else {
											System.out.println("\tYour input is invalid, please try again.");
										}
										if (a) {
											product = ppl.get(i);
											test = true;
											System.out.println("Product is " + product.toString());
											break;
										}

									}
								} while (!test);
								test = false;
								System.out.print("What is the weight of this product: ");
								double w = 0; // input.nextDouble();
								do { // loop for check input is valid.open
									try { // customer option
										System.out.print("How many much do you want to buy in kg?: ");
										w = input.nextDouble();
										test = true;
									} catch (InputMismatchException ime) {
										System.out.println("\tYour input is invalid, please try again.");
									}

								} while (!test);
								// loop for check input is valid.close
								test = false;
								cpl.add(new ShoppingCart(cID, product, cartID, w));
								// System.out.println("+++++++++++="+cpl.get(0).getPrice());
								// System.out.println(cpl.toString());
								for (int j = 0; j < cpl.size(); j++) {
									cpl.get(j).toprint();
								}
								break;
							// add product by Weight. close
							/***************************************************************
							 * List All Product On Shopping Cart
							 ***************************************************************/
							case 3:
								input.nextLine();
								System.out.println("**********\tShoppingCartList\t**********\n");
								System.out.println(cpl.toString());
								break;
							/***************************************************************
							 * 
							 * Sales Staff Assistant
							 * 
							 ***************************************************************/
							case 4: // customer call assistant. open
								System.out.println("\n\n\n\n\tShop assisteant is coming.\n\tWait a moment!\n\n\n\n");
								input.nextLine();
								String salesID;
								boolean selsLogin = false;
								do {

									do {
										// Check userID until is a valid ID
										input.nextLine();
										System.out.println("\t**********\tSales Staff Login!\t**********\n\n");
										System.out.print("\tPlease enter your ID:");
										salesID = input.nextLine();
										if (salesID.length() > 0) {
											// test = true;
										} else {
											System.out.println("\tYour input is invalid, please try again.");
											salesID = input.nextLine();
										}

									} while (userID.length() <= 0);
									for (int i = 0; i < sspl.size(); i++) {
										// System.out.println("for
										// loop++++++++=="+i);
										if (sspl.get(i).getID().equalsIgnoreCase(salesID)) {
											System.out.print("\tPlease enter your password: ");
											String password = input.nextLine();
											if (sspl.get(i).getPsd().equals(password)) {
												// cID = cul.get(i);
												// CartNum++;
												selsLogin = true;

											} else {
												System.out.println("\tYour password is invalid, please try again.");
												// password = input.nextLine();
												break; // go to do while loop.
											}
										} else {
											System.out.println("\tYour ID is invalid, please try again.");
											break; // go to do while loop.
										}
									}

								} while (!selsLogin);

								int ccAssistant = 0;// Customer call assistant
								do {
									System.out.println("\t**********\tShopping Cart Manage\t**********");

									System.out.println("\t1\tRemove item");

									System.out.println("\t2\tCancel cart");
									System.out.println("\t0\tBack");
									System.out.print("\twhich option you want to pick?");
									do {
										try {
											ccAssistant = input.nextInt();

										} catch (InputMismatchException ime) {
											System.out.println("\tYour input is invalid, please try again.");
										}
										if (ccAssistant >= 0 && ccAssistant < 3) {
											test = true;

										} else {
											System.out.println("\tYour input is invalid, please try again.");
										}
									} while (!test);
									test = false;

									switch (ccAssistant) {
									/***************************************************************
									 * Remove Item From Shopping Cart
									 ***************************************************************/
									case 1: // Remove Item
										input.nextLine(); // new line
										System.out.println("\t**********\tRemove Item\t**********");

										System.out.println("Which item you want to remove?");
										System.out.println(cpl.toString());

										System.out.print("Enter ProductID for remove: ");
										String sRemoveProID = input.nextLine();
										// looking for the product ID
										// int index = 0;
										for (int i = 0; i < cpl.size(); i++)
											if (cpl.get(i).getProID().equals(sRemoveProID)) {
												cpl.remove(i);
											} else
												System.out.println("Supplier does not exist, please add supplier first.");
										System.out.println(cpl.toString());

										break;
									/***************************************************************
									 * Cancel All Shopping
									 ***************************************************************/

									case 2:
										input.nextLine(); // new line
										boolean bCancel = false;
										do{
											System.out.print("Are you sure to cancel this shopping cart? yes / no .");
											String cInput = input.nextLine();
											System.out.println(cpl.toString());
											if(cInput.equalsIgnoreCase("yes")){
												cpl.removeAll(cpl);
												bCancel = true;
											} else if (cInput.equalsIgnoreCase("no")){
												System.out.println("Shopping cart not canceled");
												bCancel = true;
											} else
												System.out.println("Please enter yes or no.");
										}while(!bCancel);
										
										System.out.println(cpl.toString());
										break;
									case 0:
										input.nextLine();
										break;
									}
								} while (ccAssistant != 0);
								break;

							/***************************************************************
							 * Pay Total Price
							 ***************************************************************/
							case 5:
								input.nextLine();
								cartID = "Cart" + Integer.toString(CartNum);
								double finalPrice = 0;
								System.out.print("Would you like to pay? yes / no");
								for (int i1 = 0; i1 < cpl.size(); i1++) 
								{
									if (cpl.get(i1).getCartID().equalsIgnoreCase(cartID)) {

										shID = cpl.get(i1);
										pyl.add(new Payment(shID, cID));
										finalPrice += shID.getTotalPrice();
										
									}
									// pyl.get(pyl.size() - 1).setTotalPrice(finalPrice);
									System.out.println(pyl.toString());
								
									System.out.println("finalPrice: " + finalPrice);
									
									
									cID.minusPoints(py.calcPointsUsed(cID.getPoints()));
									System.out.println("asdad" + py.getPointsUsed());
									
									int pointEarn = (int)(finalPrice - (finalPrice%10));
									cID.plusPoints(py.calculatePointsEarned(finalPrice));
									System.out.println("point earn: " +cID.plusPoints(pointEarn/10));
									
									
									
									
									
									
									cID.plusPoints(py.getPointsEarned());
									System.out.println("point earn: "+ cID.plusPoints(py.getPointsEarned()));
									
									
									
									
									/*
									 * reduce stocklevel
									 */
									for (int i = 0; i < cpl.size(); i++){
										for (int j = 0; j < wal.size(); j++){
											if(cpl.get(i).getProID().equals(wal.get(j).getProductID())){
												wal.get(j).reduceStockLevel(cpl.get(i).getQuantity());
											}
										}
									}
								}
								
								cID.plusPoints(py.calculatePointsEarned(finalPrice));
								System.out.println("point earn: " +cID.plusPoints(py.calculatePointsEarned(finalPrice)));
								
								break;
								
								
							/***************************************************************
							 * Back to Customer menu
							 ***************************************************************/
							case 0:
								input.nextLine();
								break;
							}
						} while (addOption != 0);
						break;

					// customer case 3 add product. close
					case 0:
						input.nextLine();
					}
				} while (cusOption != 0);
				break;
			// ++++++++++++++++++++++++++++++++++++++++++ Customer END
			// +++++++++++++++++++++++++++++++++++++++++++++++++

			/***************************************************************
			 * 
			 * Manager
			 * 
			 ***************************************************************/
			case 2:
				int mOption = 0; // manager options
				boolean bMInputValid =  false;
				do {
					System.out.println("\t**********\tManager\t**********");
					System.out.println("\t1\tProducts");
					System.out.println("\t2\tSuppliers");
					System.out.println("\t3\tReport");
					System.out.println("\t0\tBack ");
					System.out.print("\tWhich option would you like to pick?");
					
					do{
						try{
							mOption = input.nextInt();
						}catch(InputMismatchException ime){
							System.out.println("\tYour input is invalid, please try again.");
						}
						if(mOption >=0 && mOption<= 3)
							bMInputValid = true;
						else
							System.out.println("\tOption must from 0 to 3.");
					}while(!bMInputValid);
					switch (mOption) {
					case 1:// products
							// System.out.println("Manage products\t2");
						input.nextLine();
						int mmProduct = 0; // manager manage products option
						boolean bMmInputValid =  false; // use for manager manage sth option
						do {
							System.out.println("\t**********\tManage Product\t**********");
							System.out.println("\t1\tAdd products");
							System.out.println("\t2\tRemove products");
							System.out.println("\t3\tUpdate product");
							System.out.println("\t4\tList products");
							// System.out.println("Manage Suppliers \t4");
							System.out.println("\t0\tBack");
							System.out.print("\tWhich option would you like to pick?");
							
							do{
								try{
									mmProduct = input.nextInt();
								}catch(InputMismatchException ime){
									System.out.println("\tYour input is invalid, please try again.");
								}
								if(mmProduct >=0 && mmProduct<= 4)
									bMmInputValid = true;
								else
									System.out.println("\tOption must from 0 to 4.");
							}while(!bMmInputValid);

							switch (mmProduct) {
							case 1:
								/***************************************************************
								 * Manager add Product
								 ***************************************************************/
								System.out.println("Add products");
								/*
								System.out.println(" ");
								String sID = input.nextLine();
								*/
								input.nextLine();
								String ID = null;  
								boolean bProexists = false;
								do{
									System.out.print("Please Enter ProductID: ");
									System.out.println("++++++++++++++++");
									ID = input.nextLine();
									for(int i = 0; i<ppl.size();i++){
										if(ppl.get(i).getProductID().equalsIgnoreCase(ID)){
											System.out.println("This product ID exists, please try again.");
											bProexists = true;
										}
									}
									if(bProexists)
										bProexists = false;
									else
										bProexists = true;
								}while(!bProexists);
								System.out.print("Please Enter Product Name: ");
								String Name = input.nextLine();
								// input.nextLine(); // clear line
								System.out.print("Please Enter Product Serial Number: ");
								
								boolean bSerialNum = false; // use to check serialNum valid or not
								
								int SerialNum = 0;
								do{
									try{
										SerialNum = input.nextInt();
										bSerialNum = true;
									}catch (InputMismatchException ioe){
										System.out.println("\tYour input is invalid, please try again.");
									}
									input.nextLine(); // clear line
								}while(!bSerialNum);
								
								
								/*
								System.out.println(" ");
								String ssID = input.nextLine();
								*/
								System.out.print("Please Enter Product Type W for Weight price or U for unit price: ");
								String type = input.nextLine();
								System.out.print("Please Enter Product Price: ");
								
								boolean bPrice = false; // use for checking Price valid or not
								Double Price = 0.0;
								do{
									try{
										Price = input.nextDouble();
										bPrice = true;
									}catch (InputMismatchException ioe){
										System.out.println("\tYour input is invalid, please try again.");
									}
									
									input.nextLine(); // clear line
								}while(!bPrice);
								
								System.out.print("Please Enter Product Discount: ");
								// Double Discount = input.nextDouble();
								
								boolean bDiscount = false; // use for checking Discount valid or not
								Double Discount = 0.0;
								do{
									try{
										Discount = input.nextDouble();
										
									}catch (InputMismatchException ioe){
										System.out.println("\tYour input is invalid, please try again.");
									}
									if(Discount>=0 && Discount <= 1){
										Discount = 1 - Discount; // discount means n% off;
										bDiscount = true;
									}
									else
										System.out.println("\tDiscount only accept 0 to 1. ");
									input.nextLine(); // clear line
								}while(!bDiscount);
								
								System.out.print("Please Enter Product Bulk Discount: ");
								//Double BulkDiscount = input.nextDouble();
								
								boolean bBulkDiscount = false; // use for checking Discount valid or not
								Double BulkDiscount = 0.0;
								do{
									try{
										BulkDiscount = input.nextDouble();
										
									}catch (InputMismatchException ioe){
										System.out.println("\tYour input is invalid, please try again.");
									}
									if(BulkDiscount>=0 && BulkDiscount <= 1){
										BulkDiscount = 1 - BulkDiscount; // discount means n% off;
										bBulkDiscount = true;
									}
									else
										System.out.println("\tBulk discount only accept 0 to 1. ");
									input.nextLine(); // clear line
								}while(!bBulkDiscount);
								
								System.out.print("How many does the customer have to buy to apply bulk discount?");
								// int num = input.nextInt();
								
								boolean bNum = false; // use for checking Discount valid or not
								int num = 0;
								do{
									try{
										num = input.nextInt();
										bNum = true;
									}catch (InputMismatchException ioe){
										System.out.println("\tYour input is invalid, please try again.");
									}
									input.nextLine(); // clear line
								}while(!bNum);
								
								/*
								System.out.println(" ");
								String ssSID = input.nextLine();
								*/
								
								/*
								System.out.println(" ");
								String ssSSSID = input.nextLine();
								*/
								
								boolean bSupID = false;
								do{
									// check supplier exist or not
									System.out.print("Enter SupplierID for this product");
									String supID = input.nextLine();
									for (int i = 0; i < spl.size(); i++)
									{
										if (spl.get(i).getSupplierID().equals(supID)) 
										{
											spID = spl.get(i);
											System.out.println(spl.get(i));
											bSupID = true;
										}
									}
									if(!bSupID)
										System.out.println("Supplier does not exist, please add supplier first.");
								}while(!bSupID);
								ppl.add(new Product(spID, ID, Name, type, SerialNum, Price, Discount, num,
										BulkDiscount));
								System.out.println(ppl.toString());
								break;
							/***************************************************************
							 * Manager Remove Products
							 ***************************************************************/
							case 2:
								input.nextLine();
								System.out.println("Removing products");
								System.out.println("Which product you want to remove? ");
								System.out.println(ppl.toString());
								// input.nextLine();
								System.out.print("please enter productID to remove");
								String pID = input.nextLine();
								boolean bRemove = false;
								for (int i = 0; i < ppl.size(); i++) 
								{
									if (ppl.get(i).getProductID().equals(pID)) 
									{
										ppl.remove(i);
										bRemove = true;
									}
								}
								if (!bRemove)
									System.out.println("Product is not exists, please try again.");
								// System.out.println(ppl.toString());
								break;
							/***************************************************************
							 * Manager Update Products
							 ***************************************************************/
							case 3:
								input.nextLine();
								System.out.println("Updating Product");
								int pUpdate = 0;

								do {
									System.out.println("\t**********\tUpdate Product\t**********");
									System.out.println("\t1\tUpdate Name");
									System.out.println("\t2\tUpdate Serial Number");
									System.out.println("\t3\tUpdate Price");
									System.out.println("\t4\tUpdate Product Expiry Date");
									System.out.println("\t5\tUpdate Product Discount");
									System.out.println("\t6\tUpdate Product Bulk Discount");
									System.out.println("\t0\tBack ");
									System.out.print("\tWhich option would you like to pick?");
									boolean bPUpdate = false; // use check product update.
									do{
										try{
											pUpdate = input.nextInt();
										}catch(InputMismatchException ime){
											System.out.println("\tYour input is invalid, please try again.");
										}
										if(pUpdate >=0 && pUpdate <= 6)
											bPUpdate = true;
										else
											System.out.println("\tOption must from 0 to 6.");
									}while(!bMmInputValid);
									
									switch (pUpdate) {
									/***************************************************************
									 * Update Products Name
									 ***************************************************************/
									case 1: // update name
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										 
										
										boolean bUpdatePName = false;
										do{
											System.out.print("please enter productID to update");
											String pID1 = input.nextLine();
											for (int i = 0; i < ppl.size(); i++) 
											{
												if (ppl.get(i).getProductID().equals(pID1)) 
												{
													System.out.print("Please enter new product name: ");

													String pName = input.nextLine();
													ppl.get(i).updateProductName(pName);
													bUpdatePName = true;
												}
											}
											if(!bUpdatePName)
												System.out.println("\tThis product is not existed, please try again.");
										}while(!bUpdatePName);
										

										break;
									/***************************************************************
									 * Update Products Serial Number
									 ***************************************************************/
									case 2: // update Serial Number
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										
										
										boolean bPSN = false; // check pSn valid or not
										boolean bProductExist = false;
										do{
											System.out.print("please enter productID to update");
											String pID2 = input.nextLine();
											for (int i = 0; i < ppl.size(); i++) 
											{
												if (ppl.get(i).getProductID().equals(pID2)) 
												{
													
													int pSN = 0;
													do{
														System.out.print("Please enter new Serial Number: ");
														try{
															pSN = input.nextInt();
															bPSN = true;
														}catch (InputMismatchException ime){
															System.out.println("\tYour input is invalid, please try again.");
														}
														input.nextLine();
													}while(!bPSN);
													ppl.get(i).updateProductSerialNumber(pSN);
													bProductExist = true; // after update then out of do-while loop
												}
												
											}
											if(!bProductExist)
												System.out.println("\tThis product is not existed, please try again.");
										
										}while(!bProductExist);
										break;
									/***************************************************************
									 * Update Products Price
									 ***************************************************************/
									case 3: // update Price
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										
										boolean bPP = false; // check pP(?? may be product price) is a double
										boolean bUpdatePrice = false; // check price update or not
										do{
											System.out.print("please enter productID to update");
											String pID3 = input.nextLine();
											for (int i = 0; i < ppl.size(); i++) 
											{
												if (ppl.get(i).getProductID().equals(pID3)) 
												{
													double pP = 0.0;
													do{
														System.out.print("Please enter new price: ");
														try{
															pP = input.nextDouble();
															bPP = true;
														}catch (InputMismatchException ime){
															System.out.println("\tYour input is invalid, please try again.");
														}
														input.nextLine();
													}while(!bPP);
													ppl.get(i).updateProductPrice(pP);
													bUpdatePrice = true;
												}
											}
											if(!bUpdatePrice)
												System.out.println("\tThis product is not existed, please try again.");
										}while(!bUpdatePrice);
										

										break;
									/***************************************************************
									 * Update Products Expire Date
									 ***************************************************************/
									case 4: // Expire Date
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										
										System.out.print("please enter productID to update");
										String pID4 = input.nextLine();
										boolean bExpID = false;
										// this input is a string, no idea how to check it.
										for (int i = 0; i < ppl.size(); i++) {
											if (ppl.get(i).getProductID().equals(pID4)) {
												System.out.print("Please enter new Expiry Date: ");
												String pDate = input.nextLine();
												ppl.get(i).updateProductExpiryDate(pDate);
												bExpID = true;
											}
										}
										
										if(!bExpID)
											System.out.println("This product not exists, pleas try again.");
										else
											System.out.println("Successful.");
										
										break;
									/***************************************************************
									 * Update Products Discount
									 ***************************************************************/
									case 5: // Discount
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										
										
										boolean bUpdateDiscount = false;
										boolean bpDis = false;
										
										do{
											System.out.print("please enter productID to update");
											String pID5 = input.nextLine();
											for (int i = 0; i < ppl.size(); i++) 
											{
												if (ppl.get(i).getProductID().equals(pID5)) 
												{
													System.out.print("Please enter new Discount: ");
													double pDis = 2.0;
													do
													{
														try
														{
															pDis = input.nextDouble();	
														}
														catch(InputMismatchException ime)
														{
															System.out.print("Please enter 'Double' number");
														}
														
														if(pDis >= 0 && pDis <= 1)
														{
															// pDis = 1 - pDis; // discount means n% off;
															bpDis = true;
														}
														else{
															System.out.println("\tDiscount only accept 0 to 1. ");
														}
														input.nextLine();
													}while(!bpDis);
													
													ppl.get(i).updateProductDiscount(pDis);
													bUpdateDiscount = true;
												}
											}
											
											if(!bUpdateDiscount)
												System.out.println("\tThis product is not existed, please try again.");
										}while(!bUpdateDiscount);

										break;
									/***************************************************************
									 * Update Products Bulk Discount
									 ***************************************************************/
									case 6: // Bulk Discount
										input.nextLine();
										System.out.println("Which product you want to update? ");
										System.out.println(ppl.toString());
										String pID6;
										boolean bUpdateBDis = false;
										boolean bPBdis = false;
										do{
											System.out.print("please enter productID to update");
											pID6 = input.nextLine();
											for (int i = 0; i < ppl.size(); i++) 
											{
												if (ppl.get(i).getProductID().equals(pID6)) 
												{
													double pBdis = 2.0; //input.nextDouble();
													do{
														System.out.print("Please enter new Bulk Discount: ");
														try{
															pBdis = input.nextDouble();
														}catch(InputMismatchException imo){
															System.out.println("Please enter 'Double' number");
														}
														if(pBdis>=0 && pBdis <= 1){
															// pBdis = 1 - pBdis; // discount means n% off;
															bPBdis = true;
															
														}
														else
															System.out.println("\tBulk discount only accept 0 to 1. ");
														input.nextLine();
													}while(!bPBdis);
													ppl.get(i).updateProductBulkDiscount(pBdis);
													bUpdateBDis = true;
												}
											}
											if(!bUpdateBDis)
												System.out.println("\tThis product is not existed, please try again.");
											// input.nextLine();
										}while(!bUpdateBDis);
										break;
									case 0:
										input.nextLine(); // clear line
									}
								} while (pUpdate != 0);

								break;
								/***************************************************************
								 * Layout All Products
								 ***************************************************************/
								case 4: // print product list
									System.out.println(ppl.toString());
									break;
								case 0:
									input.nextLine(); // clear line
								}
							} while (mmProduct != 0);
							break;

						case 2:
							int mmSuppliers = 0; // manager manage Suppliers

							do {
								System.out.println("\t**********\tManage Suppliers\t**********");
								System.out.println("\t1\tAdd Suppliers");
								System.out.println("\t2\tRemove Suppliers");
								System.out.println("\t3\tUpdate Suppliers");
								System.out.println("\t4\tList Suppliers");
								System.out.println("\t0\tBack ");
								System.out.print("\tWhich option would you like to pick?");
								
								boolean mmSuppliersFlag = false;
								do
								{
									try
									{
										mmSuppliers = input.nextInt();// try
									}
									catch(InputMismatchException ime)
									{
										System.out.println("Please enter valid number");
										input.nextLine();
									}
									if(mmSuppliers >= 0 && mmSuppliers <= 4)
										mmSuppliersFlag = true;
									else
										System.out.println("Please enter number between 0 - 4");
								}while(!mmSuppliersFlag);

								switch (mmSuppliers) {

								/***************************************************************
								 * Add Supplier
								 ***************************************************************/
								case 1:
									input.nextLine();
									// too many exception need to add......
									System.out.println("Adding Suppliers"); //
									// System.out.println(" "); // dirty fix
									// String sID = input.nextLine();
									
									//String ID = input.nextLine();
									String ID = null;  
									boolean bProexists = false;
									do{
										System.out.print("\tPlease Enter Supplier ID: ");
									
										ID = input.nextLine();
										for(int i = 0; i<spl.size();i++){
											if(spl.get(i).getSupplierID().equalsIgnoreCase(ID)){
												System.out.println("This Supplier ID exists, please try again.");
												bProexists = true;
											}
										}
										if(bProexists)
											bProexists = false;
										else
											bProexists = true;
									}while(!bProexists);
									System.out.println("Please Enter Name: \n");
									String Name = input.nextLine();
									System.out.println("Please Enter Company Name: \n");
									String Company = input.nextLine();
									System.out.println("Please Enter Email: \n");
									String Email = input.nextLine();
									System.out.println("Please Enter Phone: \n");
									String Phone = input.nextLine();
									spl.add(new Supplier(ID, Name, Company, Email, Phone));
									System.out.println("Done");
									System.out.println(spl.toString());
									break;
								/***************************************************************
								 * Remove Supplier
								 ***************************************************************/
								case 2:
									System.out.println("Remove Suppliers\t\t2");
									input.nextLine();
									
									boolean bRemove = false;
									do
									{
										System.out.println("Please enter ID to remove");
										String rID = input.nextLine();
										
										for (int i = 0; i < spl.size(); i++)
										{
											if (spl.get(i).getSupplierID().equals(rID)) 
											{
												spl.remove(i);
												bRemove = true;
											}
										}
										if(!bRemove)
										{
											System.out.println("\tThis Supplier is not existed, please try again.");
										}
										
									}while(!bRemove);
									
									break;
								/***************************************************************
								 * Update Supplier
								 ***************************************************************/
								case 3:
									int sUpdate = 0; // manager supplier update
													// options
									do {
										System.out.println("\t**********\tUpdate Supplier\t**********");
										System.out.println("\t1\tUpdate Contact Name");
										System.out.println("\t2\tUpdate Company");
										System.out.println("\t3\tUpdate Email");
										System.out.println("\t4\tUpdate Phone");

										// System.out.println("Manage Suppliers
										// \t4");
										System.out.println("\t0\tBack ");
										System.out.println("Which option would you like to pick?");
										boolean sUpdateFlag = false;
										do
										{
											try
											{
												sUpdate = input.nextInt();
											}
											catch(InputMismatchException ime)
											{
												System.out.println("Please enter valid number");
												input.nextLine();
											}
											if(sUpdate >= 0 && sUpdate <= 4)
												sUpdateFlag = true;
											else
												System.out.println("Please enter number between  0 - 4");
										}while(!sUpdateFlag);
										input.nextLine();
										// do{
										switch (sUpdate) {
										/***************************************************************
										 * Update Supplier Name
										 ***************************************************************/
										case 1:
											System.out.println(spl.toString());

											
											boolean bSID = false;
											do
											{
												System.out.println("Enter supplierID to update Contact Name");
												String sID1 = input.nextLine();
												
												for (int i = 0; i < spl.size(); i++) 
												{

													if (spl.get(i).getSupplierID().equals(sID1)) 
													{

														System.out.println("Please enter new Contact Name");
														String cName = input.nextLine();
														spl.get(i).updateContactName(cName);
														bSID = true;

													}
												}
												
												if(!bSID)
												{
													System.out.println("\tThis Supplier is not existed, please try again.");
												}
											}while(!bSID);
											
											System.out.println(spl.toString());
											break;
										/***************************************************************
										 * Update Supplier Company Name
										 ***************************************************************/
										case 2:
											System.out.println(spl.toString());
											boolean bsIDcompany = false;
											do
											{
												System.out.println("Enter supplierID to update Company");
												String cwID = input.nextLine();
												
												for (int i = 0; i < spl.size(); i++) 
												{
													if (spl.get(i).getSupplierID().equals(cwID)) 
													{
														System.out.println("Please enter new Company Name");
														String cName = input.nextLine();
														spl.get(i).updateCompany(cName);
														bsIDcompany = true;
													}
												}
												
												if(!bsIDcompany)
												{
													System.out.println("\tThis Supplier is not existed, please try again.");
												}
											}while(!bsIDcompany);
											
											break;
										/***************************************************************
										 * Update Supplier Email
										 ***************************************************************/
										case 3:
											System.out.println(spl.toString());
											boolean bEmail = false;
											do
											{
												System.out.println("Enter supplierID to update Email");
												String ceID = input.nextLine();
												
												for (int i = 0; i < spl.size(); i++) 
												{

													if (spl.get(i).getSupplierID().equals(ceID)) 
													{

														System.out.println("Please enter new Email");
														String cName = input.nextLine();
														spl.get(i).updateEmail(cName);
														bEmail = true;
													}
													if(!bEmail)
													{
														System.out.println("\tThis Supplier is not existed, please try again.");
													}
												}
											}while(!bEmail);
											
											break;
										/***************************************************************
										 * Update Supplier Phone Number
										 ***************************************************************/
										case 4:
											System.out.println(spl.toString());

											boolean bPhone = false;
											do
											{
												System.out.println("Enter supplierID to update Phone number");
												String crID = input.nextLine();
												for (int i = 0; i < spl.size(); i++) 
												{

													if (spl.get(i).getSupplierID().equals(crID)) 
													{

														System.out.println("Please enter new Phone Number");
														String cName = input.nextLine();
														spl.get(i).updatePhone(cName);
														bPhone = true;
													}
												}
												if(!bPhone)
												{
													System.out.println("\tThis Supplier is not existed, please try again.");
												}
												
											}while(!bPhone);
												
											break;
										case 5:
											break;

										}// while(sUpdate != 0);
									} while (sUpdate != 0);
									// while(sUpdate !=0);
									/***************************************************************
									 * List ALL Supplier
									 ***************************************************************/
								case 4:
									System.out.println(spl.toString());
									break;
								}
							} while (mmSuppliers != 0);
							break;
						case 3:// M.Report (new)
							int sReport = 0; // manager supplier update
							// options
							do {
								System.out.println("\t**********\tReport\t**********");
								System.out.println("\t1\tCreate Supply Report");
								System.out.println("\t2\tCreate Sales Report");
								System.out.println("\t3\tCreate Top Sales Report");

								// System.out.println("Manage Suppliers
								// \t4");
								System.out.println("\t0\tBack");
								System.out.println("\tWhich option would you like to pick?");
								
								boolean sReportFlag = false;
								do
								{
									try
									{
										sReport = input.nextInt();
									}
									catch(InputMismatchException ime)
									{
										System.out.println("Please enter valid number");
										input.nextLine();
									}
									if(sReport >= 0 && sReport<= 3)
										sReportFlag = true;
									else
										System.out.println("Please enter number between 0 - 3");
								}while(!sReportFlag);
								
								switch (sReport) {

								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								//
								// Generate Supplier Report
								//
								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								case 1: // (new)
									input.nextLine();
									System.out.println("Do you want to general supplier report, y or n ?");
									String w_boolean_input = input.nextLine();
									String csv_file = System.getProperty("/Users/KBOY/Documents/workspace/Data/SupplyReport.csv");
									String supplier_str_head = "Product Name" + "," + "Product ID" + ","
											+ "Product Stock Level";
									SysFileController.dataLog(csv_file, supplier_str_head, false);

									// input.hasNextLine();

									if (w_boolean_input.equals("y")) 
									{
										System.out.println("--Supplier Report Processing...--");
										for (int i = 0; i < wal.size(); i++) 
										{
											String str_2 = wal.get(i).getProductID() + "," + wal.get(i).getProductName()
													+ "," + wal.get(i).getWh_stockLevel();
											SysFileController.dataLog(csv_file, str_2, true);
										}
										System.out.println("--Supplier Report Ready--\n");
										System.out.println("           ");
									}
									break;

								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								//
								// Generate Sales Report -----new
								//
								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								case 2:// Sales report (new)
									input.nextLine();
									System.out.println("Do you want to general Sales report, y or n ?");
									String w2_boolean_input = input.nextLine();
									String csv_file_2 = System.getProperty("user.home")+"/Desktop"+"/Sales_Report.csv";
									String supplier_str2_head = "Product Name"+","+"Product ID"+","+"Product Sold";
									// Create the Sales Report File
									SysFileController.dataLog(csv_file_2, supplier_str2_head,false);
									int best_sales = 0;
									int second_best_sales = 0;
									int third_best_sales = 0;
									//int third_best_sales = 0;
									String best_sales_name = "";
									String second_sales_name = "";
									String third_sales_name = "";
									
									//input.hasNextLine();
									
									if(w2_boolean_input.equals("y"))
									{
										System.out.println("--Sales Report Processing...--");
										System.out.println("--Result for best sales--");
										for(int i = 0; i< wal.size();i++)
										{
											// Print out the sales report Line By Line
											String str_2 = wal.get(i).getProductID()+","+wal.get(i).getProductName()+","+wal.get(i).getStockSold();
											SysFileController.dataLog(csv_file_2, str_2,true);
										}
										// Find the best sales from all product
										best_sales = wal.get(0).getStockSold();
										
										for(int i = 1; i < wal.size();i++)
										{
											if(best_sales<wal.get(i).getStockSold())
											{
												best_sales = wal.get(i).getStockSold();
												best_sales_name = wal.get(i).getProductName();
											}
											
										}
										//Second Best Sales
										second_best_sales = wal.get(0).getStockSold();
										for(int i = 1; i < wal.size();i++)
										{
											if(second_best_sales<=wal.get(i).getStockSold()&&wal.get(i).getStockSold()!=best_sales)
											{
												second_best_sales = wal.get(i).getStockSold();
												second_sales_name = wal.get(i).getProductName();
											}	
										}
										//Third Best Sales
										third_best_sales = wal.get(0).getStockSold();
										for(int i = 0; i < wal.size();i++)
										{
											int current_stock = wal.get(i).getStockSold();
											if(third_best_sales<=current_stock&&current_stock!=best_sales&&current_stock!=second_best_sales)
											{
												third_best_sales = wal.get(i).getStockSold();
												third_sales_name = wal.get(i).getProductName();
												//System.out.println("++++++++++++++++++"+third_best_sales);
												//System.out.println("++++++++++++++++++"+third_sales_name);
											}										
										}								
										String str_3 = "The best sales is " + best_sales_name +", And its sales is  "+ best_sales;
										String str_4 = "The second sales is " + second_sales_name +", And its sales is  "+ second_best_sales;
										String str_5 = "The third sales is " + third_sales_name +", And its sales is  "+ third_best_sales;
										
										System.out.println(str_3);
										System.out.println(str_4);
										System.out.println(str_5);
										SysFileController.dataLog(csv_file_2, str_3,true);
										SysFileController.dataLog(csv_file_2, str_4,true);
										SysFileController.dataLog(csv_file_2, str_5,true);
										System.out.println("--Sales Report Ready--\n");
										System.out.println("           ");
									}
									break;

								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								//
								// Generate Supplier Report
								//
								// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								
								case 0:
									sReport = 0;
									break;
								}
							} while (sReport != 0);

							break;
						case 0:
							input.nextLine();
							break;
						}

					} while (mOption != 0);
					input.nextLine();
					break;

				// ++++++++++++++++++++++++++++++++++++++++++Manager
				// END+++++++++++++++++++++++++++++++++++++++++++++++++

				/***************************************************************
				 * 
				 * Warehouse
				 * 
				 ***************************************************************/

				case 3: // Warehouse Staff menu
					int wOption = 0;

					do {
						System.out.println("\t--Successfully login as Warehouse Staff--");
						System.out.println("\t1\tCheck Product Stock Level");
						System.out.println("\t2\tUpdate Product Stock Level");
						System.out.println("\t0\tExit");
						System.out.println("\tWhich option would you like to pick?");					
						boolean wOptionflag = false;
						do
						{
							try
							{
								wOption = input.nextInt(); // Staff option
							}
							catch(InputMismatchException ime)
							{
								System.out.println("Please enter valid number!");
								input.nextLine();
							}
							
							if(wOption >= 0 && wOption <= 2)
								wOptionflag = true;
							else
								System.out.println("Please enter number between 0 - 2!");
							
						}while(!wOptionflag);
						
						switch (wOption) {
						/***************************************************************
						 * Check The Warehouse Level
						 ***************************************************************/

						case 1:
							input.nextLine();
							System.out.println("\tSystem check out the warehouse level... ");
							System.out.println(wal.toString());
							break;

						/***************************************************************
						 * Update The Warehouse Stock Level
						 ***************************************************************/
						case 2:
							input.nextLine();
							
							boolean bStocklevel = false;
							do
							{
								System.out.print("\tEnter productID which is need to be updated");
								String w_ID_input = input.nextLine();
								
								for (int i = 0; i < wal.size(); i++) 
								{
									if (wal.get(i).getProductID().equals(w_ID_input)) 
									{
										
										System.out.print("Enter New StockLevel");
										boolean w_stock_flag = false;
										int w_stock_input = 0;
										do
										{
											try
											{
												w_stock_input = input.nextInt();
												w_stock_flag = true;
												
											}
											catch(InputMismatchException ime)
											{
												System.out.println("Please enter valid number!");
											}
										}while(!w_stock_flag);
										
										wal.get(i).updateStockLevel(w_stock_input);
										bStocklevel = true;
									}
									
								}
								if(!bStocklevel)
									System.out.println("Cannot find the Product");
							}while(!bStocklevel);
							System.out.println("Product Stock Level Has Succeffully Updated!!!");
							System.out.println(wal.toString());
							break;
						}

					} while (wOption != 0);
					input.nextLine();
					break;
				// ++++++++++++++++++++++++++++++++++++++++++Warehouse Staff
				// END+++++++++++++++++++++++++++++++++++++++++++++++++
				}
			} while (option != 0);

	}

	private static void loadData(ArrayList<Supplier> spl, ArrayList<ShoppingCart> cpl, ArrayList<Customer> cul,
			ArrayList<Warehouse> wal, ArrayList<Sales> sal, ArrayList<Product> ppl, ArrayList<Manager> mspl,
			ArrayList<SalesStaff> sspl, ArrayList<WarehouseStaff> wspl, ArrayList<Payment> pyl) 
	{
		Supplier s1 = new Supplier("s01", "katty", "red-farm", "katty@email.com", "32146486");
		spl.add(s1);
		Supplier s2 = new Supplier("s02", "brown", "romannie ltd.co.", "brown@email.com", "62314658");
		spl.add(s2);
		Supplier s3 = new Supplier("s03", "cathy", "drinking co.", "cathy@email.com", "72134695");
		spl.add(s3);

		Product p1 = new Product(s1, "p1", "cola", "U", 101, 3.5, 0.9, 10, 0.0);
		ppl.add(p1);
		Product p2 = new Product(s1, "p2", "pen", "U", 102, 5.0, 0.9, 5, 0.0);
		ppl.add(p2);
		Product p3 = new Product(s2, "p3", "banana", "W", 103, 0.8, 1.8);
		ppl.add(p3);
		Product p4 = new Product(s3, "p4", "apple", "W", 104, 0.85, 1.3);
		ppl.add(p4);

		Customer c1 = new Customer("John", "c1", "125 therry st", 352134, 'M', "12/02/1973", "John@email.com", 60,
				"qwert001");
		cul.add(c1);
		Customer c2 = new Customer("Sonia", "c2", "213 chennel st", 462531, 'F', "02/07/1966", "sonia@email.com", 0,
				"qaz111");
		cul.add(c2);
		Customer c3 = new Customer("Jack", "c3", "25 queen st", 2531135, 'M', "21/09/1986", "jack@email.com", 0,
				"casl001");
		cul.add(c3);
		Customer c4 = new Customer("David", "c4", "111 broow st", 7452631, 'M', "15/10/1976", "David@email.com", 0,
				"sk2314");
		cul.add(c4);
		Customer c5 = new Customer("Janny", "c5", "65 hill st", 6354921, 'F', "05/01/1967", "email@email.com", 0,
				"tt4143");
		cul.add(c5);

		SalesStaff ss1 = new SalesStaff("ss1", "jon", "raer", "G", 5, "DSADA", 21412421, "qwert100");
		sspl.add(ss1);

		Warehouse wa1 = new Warehouse(p1, 100, 30, 100);
		wal.add(wa1);
		Warehouse wa2 = new Warehouse(p2, 100, 30, 100);
		wal.add(wa2);
		Warehouse wa3 = new Warehouse(p3, 100, 30, 100);
		wal.add(wa3);
		Warehouse wa4 = new Warehouse(p4, 100, 30, 100);
		wal.add(wa4);
		/*
		 * ShoppingCart sh1 = new ShoppingCart(c1, p1, "ca1", 71); cpl.add(sh1);
		 * 
		 * Sales sa1 = new Sales("sa1",p1,wa1, sh1); sal.add(sa1);
		 */
		Manager m1 = new Manager("M1", "a", "a", "a", 1, "a", 2, "456456");
		mspl.add(m1);
		// SalesStaff ss1 = new SalesStaff("ss1", "a", "a", "a", 1, "a", 2,
		// "a");
		// sspl.add(ss1);
		WarehouseStaff ws1 = new WarehouseStaff("ws1", "a", "a", "a", 1, "a", 2, "a");
		wspl.add(ws1);
		
	}




	/*
	 *  save data
	 */
	
	// Supplier
	private static void saveSupplier(ArrayList<Supplier> spl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Supplier.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(spl);
			System.out.println("Supplier list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Supplier list.");
		}
	}
	// ShoppingCart
	private static void saveShoppingCart (ArrayList<ShoppingCart> cpl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/ShoppingCart.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(cpl);
			System.out.println("ShoppingCart list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save ShoppingCart list.");
		}
	}
	// Customer
	private static void saveCustomer(ArrayList<Customer> cul) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Customer.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(cul);
			System.out.println("Customer list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Customer list.");
		}
	}
	// Warehouse
	private static void saveWarehouse(ArrayList<Warehouse> wal) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Warehouse.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(wal);
			System.out.println("Warehouse list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Warehouse list.");
		}
	}
	// Sales
	private static void saveSales(ArrayList<Sales> sal) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Sales.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(sal);
			System.out.println("Sales list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Sales list.");
		}
	}
	// Product
	private static void saveProduct(ArrayList<Product> ppl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Product.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(ppl);
			System.out.println("Product list Save seccessfully.");
		} catch (IOException ioe) 
		{
			// ioe.getStackTrace();
			System.out.println("Can not save Product list.");
		}
	}
	// Manager
	private static void saveManager(ArrayList<Manager> mspl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Manager.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(mspl);
			System.out.println("Manager list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Manager list.");
		}
	}
	// SalesStaff
	private static void saveSalesStaff(ArrayList<SalesStaff> sspl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/SalesStaff.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(sspl);
			System.out.println("SalesStaff list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save SalesStaff list.");
		}
	}
	// WareHouseStaff
	private static void saveWarehouseStaff(ArrayList<WarehouseStaff> wspl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/WarehouseStaff.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(wspl);
			System.out.println("WarehouseStaff list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save WarehouseStaff list.");
		}
	
	}
	// Payment
	private static void savePayment(ArrayList<Payment> pyl) { 
		File fileName = new File("/Users/KBOY/Documents/workspace/Data/Payment.txt");
		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(pyl);
			System.out.println("Payment list Save seccessfully.");
		} catch (IOException ioe) 
		{
			System.out.println("Can not save Payment list.");
		}
	
	}




}






