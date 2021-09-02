package com.addressbooksystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class AddressBook {
	
	public static HashMap<Integer, String> addressBookName = new HashMap<Integer,String>();
	public static ArrayList<ArrayList<ContactBook>> mainArr= new ArrayList<ArrayList<ContactBook>>();
	
	private static boolean duplicateCheck(ArrayList<ContactBook> arr1,String fName,String lName) {
		for(int i=0;i<arr1.size();i++) {
			if (arr1.get(i).firstname.equals(fName) && arr1.get(i).lastname.equals(lName)) return true;
		}
		return false;
	}
	
	
	//method for adding contact
	public static void addContact(final int input) {
		Scanner sc = new Scanner(System.in);
		
		//Adding records.
		System.out.println("Enter number of record:");
		int record = sc.nextInt();
		
		ArrayList<ContactBook> arr = new ArrayList<>();
		
		while ( record!=0 ) {
			
			String firstname= sc.nextLine();
			
			String lastname= sc.nextLine();
			
			String address= sc.nextLine();
			
			String state= sc.nextLine();
			
			String city= sc.nextLine();
			
			String emailid= sc.nextLine();
			
			int zipc=sc.nextInt(); 
			
			String phonenumber=sc.nextLine(); 
			
			//Below substring done due to ide memory buffer error
			firstname = firstname.replaceAll("\\s", "");
			phonenumber = phonenumber.replaceAll("\\s", "");
			
			//creation of object or address book creation
			ContactBook cb = new ContactBook(firstname,lastname,address,state,city,emailid,zipc,phonenumber);
			if ((input-1)>=0) {
				if (duplicateCheck(mainArr.get(input-1),firstname,lastname)) {
					System.out.println("Entry already in Address Book");
				}
				else {
					mainArr.get(input-1).add(cb);
				}
				
			}
			else arr.add(cb);
			record--;
		}
		if ((input-1)<0) mainArr.add(arr);
		
	}
	

	//method for editing contact
	public static void editContact() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter records to be edited: ");
		int editrecord = sc.nextInt();
		
		while ( editrecord!= 0 ) {
			System.out.println("Enter firstname lastname address state city emailid zipc phonenumber");
			String input1 = sc.nextLine();
			input1 = input1.replaceAll("\\s", "");
			if ( input1.equals("firstname") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				for(int j =0 ;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).firstname.equals(name) ) {
							mainArr.get(j).get(i).firstname=updatename;
							break;
						}
					}
				}
			}
			
			else if ( input1.equals("lastname") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).lastname.equals(name) ) {
							mainArr.get(j).get(i).lastname=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("address") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).address.equals(name) ) {
							mainArr.get(j).get(i).address=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("state") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).state.equals(name) ) {
							mainArr.get(j).get(i).state=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("city") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).city.equals(name) ) {
							mainArr.get(j).get(i).city=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("emailid") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).emailid.equals(name) ) {
							mainArr.get(j).get(i).emailid=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("zipc") ) {
				int name = sc.nextInt();
				int updatename = sc.nextInt();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).zipc == name ) {
							mainArr.get(j).get(i).zipc=updatename;
							break;
						}
					}
				}
			}
			else if ( input1.equals("phonenumber") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				for(int j = 0;j<mainArr.size();j++) {
					for(int i = 0 ; i < mainArr.get(j).size(); i++) {
						if (mainArr.get(j).get(i).phonenumber.equals(name) ) {
							mainArr.get(j).get(i).phonenumber=updatename;
							break;
						}
					}
				}
			}
			editrecord--;
		}
	}



	public static void deleteContact() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of record to be deleted:" );
		int delrecord = sc.nextInt();
		while( delrecord > 0 ) {
			
			System.out.println("Enter record Firstname and Lastname:");
			String name = sc.nextLine();
			name = name.replaceAll("\\s", "");
			String lName = sc.nextLine();
			for(int j = 0;j<mainArr.size();j++) {
				for(int i = 0 ; i < mainArr.get(j).size(); i++) {
					if (mainArr.get(j).get(i).firstname.equals(name) && mainArr.get(j).get(i).lastname.equals(lName)) {
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
				System.out.println("Firstname: " + mainArr.get(j).get(i).firstname);
				System.out.println("Lastname: " + mainArr.get(j).get(i).lastname);
				System.out.println("Address: " + mainArr.get(j).get(i).address);
				System.out.println("State: " + mainArr.get(j).get(i).state);
				System.out.println("City: " + mainArr.get(j).get(i).city);
				System.out.println("Emailid: " + mainArr.get(j).get(i).emailid);
				System.out.println("Zipcode: " + mainArr.get(j).get(i).zipc);
				System.out.println("Phone number: " + mainArr.get(j).get(i).phonenumber);
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
				addressBookName.put(input, adName);
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
	

	//main method
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total=0;
		int flag = 0;
		while(true) {
			System.out.println("Enter 1.Add 2.Edit 3.delete 4.Display 5.exit");
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

