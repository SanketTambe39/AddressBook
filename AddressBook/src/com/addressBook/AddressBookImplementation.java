package com.addressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class AddressBookImplementation implements AddressBookInterface {

	public String firstname,lastname,city,state,phonenumber;
	public int zipcode;
	
	public static File file;
	
	Scanner sc = new Scanner(System.in);
	
	public ArrayList<Person> personArrayList = new ArrayList<Person>(100);
	public HashMap<String, ArrayList<Person>> personHashMap = new HashMap<>(100);

	public String patternPhone = "^[6-9]{1}[0-9]{9}";
	public BufferedWriter bw;
	public BufferedReader br;
	public FileReader fileReader;
	
	int flag = 0;

	
	@Override
	public HashMap<String, ArrayList<Person>> addPerson(String fileName) {
		
		System.out.println("How many Records you want to Store in " +fileName+".csv");
		int NumberOfDaTa = sc.nextInt();
		for (int i = 1; i <= NumberOfDaTa; i++) {
			
			System.out.println("Enter First Name :");
			firstname = sc.next();
			
			System.out.println("Enter Last Name :");
			lastname = sc.next();
			
			System.out.println("Enter City :");
			city = sc.next();
			
			System.out.println("Enter State :");
			state = sc.next();
			
			System.out.println("Enter Zip Code :");
			zipcode = sc.nextInt();
			
			System.out.println("Enter Phone Number :");
			phonenumber = sc.next();
			
			boolean flag1 = phonenumber.matches(patternPhone);
			
			while (flag1 == false) {
				System.out.println("Enter Phone Number with 10 digit between 0-9 :");
				phonenumber = sc.next();
				flag1 = phonenumber.matches(patternPhone);
			}
			personArrayList.add(
					new Person(firstname + ",", lastname + ",", city + ",", state + ",", zipcode, "," + phonenumber));
			personHashMap.put(fileName, personArrayList);
		}
		return personHashMap;
	}
	@Override
	public String editPerson(String fileName) {
		// TODO Auto-generated method stub

		System.out.println("Enter number for edit person data\n");
		String lineToFind = sc.next();
		
		File inFile = new File((fileName+".csv"));
		File tempFile = new File(fileName + ".tmp");
		
		
		try {
			br = new BufferedReader(new FileReader(inFile));
			bw = new BufferedWriter(new FileWriter(tempFile));
		
		
			String line = null;
			
			while ((line = br.readLine()) != null) {
				if (line.trim().contains(lineToFind)) {
					
					System.out.println("Data found for given number\n" + line);
					
					String[] persondrtails = line.split(",");
					
					String firstname = persondrtails[0];
					String lastname = persondrtails[1];
					
					System.out.println("enter the city");
					String city = sc.next();
					
					System.out.println("enter the State");
					String state = sc.next();
					
					System.out.println("enter the Zipcode");
					int zipcode = sc.nextInt();
					
					String phonenumber = persondrtails[5];
					
					bw.write(firstname);
					bw.write("," + lastname);
					bw.write("," + city);
					bw.write("," + state);
					bw.write("," + zipcode);
					bw.write("," + phonenumber);
					bw.newLine();
					flag++;
				} else {
					bw.write(line);
					bw.newLine();
				}
	
				
				
			}
			bw.close();
			br.close();
			
			inFile.delete();
			tempFile.renameTo(inFile);
			
			if (flag == 0)
				System.out.println("Data not found in AddressBook :" + fileName);
			else
				System.out.println("Data Modified Successfully..");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String deletePerson(String fileName) {
		// TODO Auto-generated method stub

		System.out.println("Enter Number for Delete");
		String lineToRemove = sc.next();
		
		File inFile = new File((fileName+".csv"));
		File tempFile = new File(fileName+".tmp");
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(inFile));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;
			while ((line = br.readLine()) != null) {
				if (!line.trim().contains(lineToRemove)) {
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			inFile.delete();
			
			System.out.println("Data deleted From AddressBook");
			tempFile.renameTo(inFile);
			System.out.println(" ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String searchPerson(String fileName) {
		// TODO Auto-generated method stub
		File input = new File((fileName+".csv"));
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);

		flag=0;
		
		String search, str;
		
		System.out.println("Please enter number for search :");
		search = ob.nextLine();
		
		try {
			fr = new FileReader(input);
		
		br = new BufferedReader(fr);
		while ((str = br.readLine()) != null) {
			if (str.contains(search)) {
				flag++;
				System.out.println("Data found: \n" + str);
			}
		}
		if(flag==0)
			System.out.println("wrong Number not data found try another way ");

		fr.close();
		br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String sortbyZipCode(String fileName) {
		// TODO Auto-generated method stub
		File inFile = new File((fileName+".csv"));
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inFile));
		
		ArrayList<Person> lines2 = new ArrayList<Person>();
		
		String currentLine1 = reader.readLine();
		
		String currentLine = reader.readLine();
		
		while (currentLine != null) {
			String[] persondrtails = currentLine.split(",");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines2.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		Collections.sort(lines2, new Sortbyzip());
		System.out.println("Data after Sort By Zip: ");
		for (Person P : lines2) {
			System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " "
					+ P.getZipCode() + " " + P.getPhoneNumber());
		}
		System.out.println("");
		reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String sortbyName(String fileName) {
		// TODO Auto-generated method stub
		File inFile = new File((fileName+".csv"));

		BufferedReader reader;
		try {
		
			reader = new BufferedReader(new FileReader(inFile));
		
		ArrayList<Person> lines = new ArrayList<Person>();
		String currentLine1 = reader.readLine(); // for ignore the first Line
		
		String currentLine = reader.readLine();
		
		while (currentLine != null) {
			String[] persondrtails = currentLine.split(",");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		
		Collections.sort(lines, new SortByname());
		System.out.println("Data after Sort By Name: ");
		for (Person P : lines) {
			System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " "
					+ P.getZipCode() + " " + P.getPhoneNumber());
		}
		
		System.out.println("");
		reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void Display(String fileName) {
		// TODO Auto-generated method stub

		System.out.println("Data Present in System :");
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileName+".csv"));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
			
			System.out.println(" \n\n");
			file.exists();
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String acess(){
		
		System.out.println("AddressBook Present in System \n");
		try 
		{
            File file = new File(".");
 
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    return name.endsWith(".csv");
                }
            };
            
            File[] files = file.listFiles(filter);

            for (int i = 0; i < files.length; i++) 
            {
                System.out.println("\t\t"+files[i].getName());
            }
        }catch (Exception e) 
		{
            System.err.println(e.getMessage());
        }
		
		System.out.println("======================");
		System.out.println("Please Enter Address Book you want to Make Oprations On ::\n");
		String fileName = sc.next();
		file = new File(fileName+".csv");
		if (file.isFile()) {
			return fileName;
		} else

			return null;
	}
}
