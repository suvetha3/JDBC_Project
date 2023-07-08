package controller;

import java.sql.SQLException;
import java.util.Scanner;
import model.login;
import model.product;
import dao.logindao;
import dao.productdao;
public class Main 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		int choice,option;
		login log=new login();
		product pro=new product();
		logindao logd=new logindao();
		productdao prod=new productdao();
	  	do
		{
			System.out.println("1. Admin");
			System.out.println("2. Agent");
			System.out.println("3. Exit");
			System.out.println("...***##***...");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Admin Login");
				sc.nextLine();
				System.out.println("Enter your username");
				String username=sc.nextLine();
				System.out.println("Enter your password");
				String password=sc.nextLine();
				log.setUsername(username);
				log.setPassword(password);
			if(logd.validate(log))//password correct
			{
			    System.out.println("Login Successful!...");
		      do
				{
					System.out.println("1. Add Product");
					System.out.println("2.Display Product");
				    System.out.println("3. Logout");
					System.out.println("***.....***");
					System.out.println(" Enter your option");
					option=sc.nextInt();
					switch(option)
					{
						case 1:System.out.println("Add Product");
						  System.out.println("productId");
						  int productId=sc.nextInt();
						  sc.nextLine();
						  System.out.println("Enter the productName");
						  String productName=sc.nextLine();
						  System.out.println("Enter the minimum sell quantity");
						  int minsellquantity=sc.nextInt();
						  System.out.println("Enter the price");
						  int price=sc.nextInt();
						  System.out.println("Enter the quantity");
						  int quantity=sc.nextInt();
						  pro.setProductId(productId);
						  pro.setProductName(productName);
						  pro.setMinsellquantity(minsellquantity);
						  pro.setPrice(price);
						  pro.setQuantity(quantity);
						  prod.addProduct(pro);
						  break;
						case 2:System.out.println("Display Product");
						prod.display();
						break;						
						case 3:System.out.println("Logout");break;
					}
				}while(option!=3);			
			}
			else
			{
			  System.out.println("Login Failure!...");
			}
			break;
				case 2:System.out.println("Agent Login");
				sc.nextLine();
				System.out.println("Enter your username");
				String username1=sc.nextLine();
				System.out.println("Enter your password");
				String password1=sc.nextLine();
				log.setUsername(username1);
				log.setPassword(password1);
			if(logd.validate(log))//password correct
			{
				   System.out.println("Login Successful!!...");
				do
				{
					System.out.println("1.Display Product");
					System.out.println("2.Logout");
					System.out.println("***.....***");
					System.out.println(" Enter your option");
					option=sc.nextInt();
					switch(option)
					{
						case 1:System.out.println("Display Product");
						prod.display();
						break;
						case 2:System.out.println("Logout");
						break;
					}
				}while(option!=2);
			}
			else
			{
			  System.out.println("Login Failure!!...");
			}
			break;
				case 3:System.out.println("Exit");break;
			}
		}while(choice!=3);
	  	sc.close();
	}

}
