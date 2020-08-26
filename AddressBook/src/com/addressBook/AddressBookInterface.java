package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {
	
	public HashMap<String, ArrayList<Person>> addPerson(String fileName);
	public void editPerson();
	public void deletePerson();
	public void searchPerson();
	public void sortbyZipCode();
	public void sortbyName();
	public void Display();
	
}
