package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import service.AdressBookMethod;

public class AddressBook 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scanner=new Scanner(System.in);
	
		
		AdressBookMethod addressbookmethod=new AdressBookMethod();
		addressbookmethod.readJson();
		
		int choice;
		do
		{
			
			System.out.println("1.Create AddressBook ");
			System.out.println("2.Open Address");
			System.out.println("3.Save the Address");
			System.out.println("4.Save As");
			System.out.println("Enter the choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				addressbookmethod.createNewAddressBook();
				break;
				
			case 2:
				addressbookmethod.openAddressBook();
				break;
				
			case 3:
				addressbookmethod.save();
				break;
			
			case 4:
				addressbookmethod.saveAs();
				break;
			
			case 5:
				 
				System.out.println("Thank you for using address book!!!!");
				System.exit(0);
				break;
			
			default:
				
				System.out.println("please enter valid option from menu");
				break;
				
			}
			
		}while(choice!=6);
		scanner.close();
	}
}
