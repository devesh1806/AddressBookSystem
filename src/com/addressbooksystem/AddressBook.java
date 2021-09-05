package com.addressbooksystem;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBook {
	
	public static HashMap<Integer, String> addressBookName = new HashMap<Integer,String>();
	public static ArrayList<ArrayList<ContactBook>> mainArr= new ArrayList<ArrayList<ContactBook>>();
	public static HashMap<String, String> addressBookCity = new HashMap<String,String>();
	public static HashMap<String, String> addressBookState = new HashMap<String,String>();
	
	//method for adding contact
	public static void addContact(int input) {
		Scanner sc = new Scanner(System.in);
		
		//Adding records.
		System.out.println("Enter number of record:");
		int record = sc.nextInt();
		
		
		ArrayList<ContactBook> arr = new ArrayList<>();
		
		while ( record!=0 ) {
			
			String firstName= sc.nextLine();
			
			String lastName= sc.nextLine();
			
			String address= sc.nextLine();
			
			String state= sc.nextLine();
			
			String city= sc.nextLine();
			
			String emailId= sc.nextLine();
			
			int zip=sc.nextInt(); 
			
			String phoneNumber=sc.nextLine(); 
			
			//Below substring done due to ide memory buffer error
			firstName = firstName.replaceAll("\\s", "");
			phoneNumber = phoneNumber.replaceAll("\\s", "");
			//creation of object or address book creation
			ContactBook cb = new ContactBook(firstName,lastName,address,state,city,emailId,zip,phoneNumber);
			if ((input-1)>=0) {
				if (!duplicateChecker(firstName +" "+lastName, mainArr.get(input-1))) {
					mainArr.get(input-1).add(cb);
					addressBookCity.put(firstName+" "+lastName,city);
					addressBookState.put(firstName+" "+lastName,state);
				}
			}
			else {
				arr.add(cb);
				addressBookCity.put(firstName+" "+lastName,city);
				addressBookState.put(firstName+" "+lastName,state);
			}
			record--;
		}
		if ((input-1)<0) mainArr.add(arr);
		
	}
	
	private static boolean duplicateChecker(String name, ArrayList<ContactBook> arr) {
		boolean flag = arr.stream().anyMatch(n->(n.firstName+" "+n.lastName).equals(name));
		return flag;
	}
	
	//method for editing contact
	public static void editContact() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter records to be edited: ");
		int editrecord = sc.nextInt();
		while ( editrecord!= 0 ) {
			System.out.println("Enter Firstname and Lastname :");
			String input1 = sc.nextLine();
			input1 = input1.replaceAll("\\s", "");
			String input2 = sc.nextLine();
			
			String firstName= sc.nextLine();
			
			String lastName= sc.nextLine();
			
			String address= sc.nextLine();
			
			String state= sc.nextLine();
			
			String city= sc.nextLine();
			
			String emailId= sc.nextLine();
			
			int zip =sc.nextInt(); 
			
			String phoneNumber=sc.nextLine(); 
			
			//Below substring done due to ide memory buffer error
			firstName = firstName.replaceAll("\\s", "");
			phoneNumber = phoneNumber.replaceAll("\\s", "");

			//creation of object or address book creation
			ContactBook cb = new ContactBook(firstName,lastName,address,state,city,emailId,zip,phoneNumber);
			int flag = 0;
			for(int i=0;i<mainArr.size();i++) {
				for(int j=0;j<mainArr.get(i).size();j++) {
					if (mainArr.get(i).get(j).firstName.equals(input1) && mainArr.get(i).get(j).lastName.equals(input2)) {
						for(String names: addressBookCity.keySet()) {
							if ((names).equals(input1+" "+input2)) {
								addressBookCity.remove(names);
								break;
							}
						}
						for(String namesS: addressBookState.keySet()) {
							if ((namesS).equals(input1+" "+input2)) {
								addressBookState.remove(namesS);
								break;
							}
						}
						mainArr.get(i).remove(j);
						mainArr.get(i).add(j, cb);
						addressBookCity.put(firstName+" "+lastName, city);
						addressBookState.put(firstName+" "+lastName, state);
						flag = 1;
						break;
					}
				}
				if (flag==1) break;
			}
			editrecord--;
		}
	}



	public static void deleteContact() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of record to be deleted:" );
		int delrecord = sc.nextInt();
		while( delrecord > 0 ) {
			
			System.out.println("Enter record name ");
			String name = sc.nextLine();
			name = name.replaceAll("\\s", "");
			
			for(int j = 0;j<mainArr.size();j++) {
				for(int i = 0 ; i < mainArr.get(j).size(); i++) {
					if (mainArr.get(j).get(i).firstName.equals(name)) {
						mainArr.get(j).remove(i);
						break;
					}
				}
			}
			delrecord--;
		}
	}
	
	//method to display contact
	public static void displayContact() {
		
		for(int j = 0;j<mainArr.size();j++) {
			System.out.println();
			System.out.println(addressBookName.get(j));
			for(int i = 0 ; i < mainArr.get(j).size(); i++) {
				System.out.println("Firstname: " + mainArr.get(j).get(i).firstName);
				System.out.println("Lastname: " + mainArr.get(j).get(i).lastName);
				System.out.println("Address: " + mainArr.get(j).get(i).address);
				System.out.println("State: " + mainArr.get(j).get(i).state);
				System.out.println("City: " + mainArr.get(j).get(i).city);
				System.out.println("Emailid: " + mainArr.get(j).get(i).emailId);
				System.out.println("Zipcode: " + mainArr.get(j).get(i).zip);
				System.out.println("Phone number: " + mainArr.get(j).get(i).phoneNumber);
				System.out.println();
			}
		}
	}	

	private static void multiAddContact() {
		Scanner sc = new Scanner(System.in);
		if (mainArr.size()>0) {
			System.out.println("Enter position: 1-" + mainArr.size());
			int input = sc.nextInt();
			if (input > mainArr.size()) {
				System.out.println("Enter Address Book name");
				String dummy = sc.nextLine();
				String adName = sc.nextLine();
				addressBookName.put(input-1, adName);
				addContact(0);
			}
			else {
				addContact(input);
			}
			
		}
		else {
			System.out.println("Enter Address Book name");
			String adName = sc.nextLine();
			addressBookName.put(0, adName);
			addContact(0);
		}
	}
	
	private static void searchPersons() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter to Search According to 1.City 2.State");
		int input = sc.nextInt();
		String adName = sc.nextLine().replace(" ", "");
		System.out.println();

		if (input==1) {
			mainArr.stream().forEach(n->{
			for (ContactBook contactBook : n) {
				if (contactBook.city.equals(adName)) System.out.println(contactBook.firstName+" "+contactBook.lastName);
			}});
		}
		else {
			mainArr.stream().forEach(n->{
				for (ContactBook contactBook : n) {
					if (contactBook.state.equals(adName)) System.out.println(contactBook.firstName+" "+contactBook.lastName);
				}});
		}
	}
		

	private static void viewPersons() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter to Search According to 1.City 2.State");
		int input = sc.nextInt();
		String adName = sc.nextLine().replace(" ", "");
		System.out.println();

		if (input==1) {
			addressBookCity.keySet().stream().forEach(n->{
				System.out.println(n+" lives in "+addressBookCity.get(n));
			});; 
		}
		else {
			addressBookState.keySet().stream().forEach(n->{
				System.out.println(n+" lives in "+addressBookState.get(n));
			});;
		}
	}
	
	private static void countPersons() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter to Search According to 1.City 2.State");
		int input = sc.nextInt();
		String adName = sc.nextLine().replace(" ", "");
		System.out.println();
		
		if (input==1) {
			Map<String, Long> count = addressBookCity.values().stream().collect(Collectors.groupingBy(Function.identity(),
	                Collectors.counting()));
			count.keySet().stream().forEach(n->{
				System.out.println(n+" : "+count.get(n));
			});
		}
		else {
			Map<String, Long> count = addressBookState.values().stream().collect(Collectors.groupingBy(Function.identity(),
	                Collectors.counting()));
			count.keySet().stream().forEach(n->{
				System.out.println(n+" : "+count.get(n));
			});
		}
		
	}
	
	//main method
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total=0;
		int flag = 0;
		while(true) {
			System.out.println("Enter 1.Add 2.Edit 3.delete 4.Display 5.Search 6.View Persons 7.Count Persons 8.exit");
			int option = sc.nextInt();
			switch (option){
				case 1:
					multiAddContact();
					break;
				case 2:
					editContact();
					break;
				case 3:
					deleteContact();
					break;
				case 4:
					displayContact();
					break;
				case 5:
					searchPersons();
					break;
				case 6:
					viewPersons();
					break;
				case 7:
					countPersons();
					break;
				case 8:
					flag=1;
					break;
				default:
					System.out.println("Enter valid option");
					break;
			}
			if (flag == 1) break;
		}
	}

}

