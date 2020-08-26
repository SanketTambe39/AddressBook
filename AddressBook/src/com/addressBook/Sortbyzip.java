package com.addressBook;


import java.util.Comparator;

public class Sortbyzip implements  Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
	
		return o1.getZipCode() - o2.getZipCode();
		
	}

}
