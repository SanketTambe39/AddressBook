package com.addressBook;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookInterface {
	
	public HashMap<String, ArrayList<Person>> addPerson(String fileName);
	public String editPerson(String fileName);
	public String deletePerson(String fileName);
	public String searchPerson(String fileName);
	public String sortbyZipCode(String fileName);
	public String sortbyName(String fileName);
	public void Display(String fileName);
	
}
