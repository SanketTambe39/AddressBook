package com.addressBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {

	public String fileName;
	public static File file;
	public FileWriter fileWriter;
	
	Scanner sc = new Scanner(System.in);
	public BufferedWriter bw;
	
	@Override
	public File newAddressBook() {
		// TODO Auto-generated method stub

		System.out.print("Enter Address Book Name : ");
		fileName = sc.next();
		
		fileName = fileName+".csv";
		file = new File(fileName);
		
		System.out.println("Please Press Y For Creating Address Book else press N");
		String op = sc.next();
		
		if (op.equalsIgnoreCase("Y")) 
		{
			
			try {
				
				file.createNewFile();
			
				fileWriter = new FileWriter(file);
				
				bw = new BufferedWriter(fileWriter);
				bw.write("First_Name");
				bw.write(",Last_name");
				bw.write(",City");
				bw.write(",State");
				bw.write(",Zipcode");
				bw.write(",Phone_Number");
				bw.newLine();
			
				System.out.println("Address Book Is Succesfully Created ");
				} 
			catch (IOException e) 
			{
					// TODO Auto-generated catch block
				System.out.println("Some Error Occure During the input");	
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println("Unable to create An AdressBook");
		}
		
		try {
			bw.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
		
	}

	@Override
	public void openAddressBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAddressBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAsAddressBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeAddressBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub

	}

}
