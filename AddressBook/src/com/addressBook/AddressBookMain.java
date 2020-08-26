package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddressBookImplementation addressBookImplementation = new AddressBookImplementation();
		AddressBookManagerImplementation addressBookManagerImplementation = new AddressBookManagerImplementation();
		
		ArrayList<Person> personArrayList = new ArrayList<Person>(100);
		HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>(100);
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("\n\t\tWelcome to My Address book Application \n");
			System.out.println("Please Choose from the below options what you want to do With the Addressbook :: \n");
		
			System.out.println("\t\t1) Create new Address book \n"
					+ "\t\t2) Open Address Book \n"
					+ "\t\t3) Save Address Book \n"
					+ "\t\t4) Save As Address Book \n"
					+ "\t\t5) Close the Address Book \n"
					+ "\t\t6) Quit \n");
			
			System.out.println("Please Enter your choice ::");
			int choiceMain=sc.nextInt();
			switch(choiceMain) {
				case 1:
						addressBookManagerImplementation.newAddressBook();
					break;
					
				case 2:
					personHashMap = addressBookManagerImplementation.openAddressBook();
					break;
				case 3:
					addressBookManagerImplementation.saveAddressBook();
					break;
				case 4:
					addressBookManagerImplementation.saveAsAddressBook();
					break;
				case 5:
					addressBookManagerImplementation.closeAddressBook();
					break;
				case 6:
					addressBookManagerImplementation.quit();
					System.out.println("Please Confirm you want to Exit ??(Y or N)");
					String exit=sc.next();
					if(exit.equalsIgnoreCase("Y"))
						return;
					break;
				default:
					System.out.println("Wrong choice Please choose from the above only");
					break;
			}
		}
		
	}
}
