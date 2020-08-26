package com.addressBook;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddressBookImplementation addressBookImplementation = new AddressBookImplementation();
		AddressBookManagerImplementation addressBookManagerImplementation = new AddressBookManagerImplementation();
		
		System.out.println("\n\t\tWelcome to My Address book Application \n");
		System.out.println("Please Choose from the below options what you want to do With the Addressbook :: \n");
	
		System.out.println("\t\t1) Create new Address book \n"
				+ "\t\t2) Open Address Book \n"
				+ "\t\t3) Save Address Book \n"
				+ "\t\t4) Save As Address Book \n"
				+ "\t\t5) Close the Address Book \n"
				+ "\t\t6) Quit ");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("Please Enter your choice ::");
			int choiceMain=sc.nextInt();
			switch(choiceMain) {
				case 1:
						addressBookManagerImplementation.newAddressBook();
					break;
					
				case 2:
					addressBookManagerImplementation.openAddressBook();
					while(true) 
					{
						System.out.println("Please Enter What opration you want to do on above file ::");
						System.out.println("\t\t 1) Add Data into the file\n"
								+ "\t\t 2) Edit Data From the File\n "
								+ "\t\t 3) Delete Data From the File\n"
								+ "\t\t 4) Search Data From the file\n"
								+ "\t\t 5) Sort Data By their Zip Code\n"
								+ "\t\t 6) Sort Data By their Name\n"
								+ "\t\t 7) Display");
							
						System.out.println("Please Enter Oprations you want to perform ::");
						int ChoiceOpenBook=sc.nextInt();
						
						while(true) 
						{
							switch(ChoiceOpenBook) 
							{
									
								case 1:
									addressBookImplementation.addPerson();
									break;
								case 2:
									addressBookImplementation.editPerson();
									break;
								case 3:
									addressBookImplementation.deletePerson();
									break;
								case 4:
									addressBookImplementation.searchPerson();
									break;
								case 5:
									addressBookImplementation.sortbyZipCode();
									break;
								case 6:
									addressBookImplementation.sortbyName();
									break;
								case 7:
									addressBookImplementation.Display();
									break;
								default:
									System.out.println("Something Went Wrong. Please check the Choice");
									break;
							}
						}
					}
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
