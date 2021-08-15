package com.addressbooksystem;
import java.util.ArrayList;
import java.util.Scanner;

//created contactBook for adding contacts
class ContactBook{
	
	String firstname; 
	String lastname; 
	String address; 
	String state; 
	String city; 
	String emailid;
	int zipc; 
	String phonenumber; 
	
	
	//constructor of class
	ContactBook( String firstname, String lastname, String address, String state, String city, String emailid, int zipc, String phonenumber){
		this.firstname = firstname; 
		this.lastname=lastname; 
		this.address=address; 
		this.state=state; 
		this.city=city;
		this.emailid= emailid ;
		this.zipc=zipc; 
		this.phonenumber=phonenumber;
		
	}
	
}


public class AddressBook {
	
	public static ArrayList<ContactBook> arr= new ArrayList();
	
	//method for adding contact
	public static void addcontact() {
		
		//taking input
		Scanner sc = new Scanner(System.in);
		
		//Adding records.
		System.out.println("Enter number of record:");
		int record = sc.nextInt();
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
			arr.add(cb);
			record--;
		}
	}
	
	//method for editing contact
	public static void editcontact() {
		
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
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).firstname.equals(name) ) {
						arr.get(i).firstname=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("lastname") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).lastname.equals(name) ) {
						arr.get(i).lastname=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("address") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).address.equals(name) ) {
						arr.get(i).address=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("state") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).state.equals(name) ) {
						arr.get(i).state=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("city") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).city.equals(name) ) {
						arr.get(i).city=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("emailid") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).emailid.equals(name) ) {
						arr.get(i).emailid=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("zipc") ) {
				int name = sc.nextInt();
				int updatename = sc.nextInt();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).zipc == name ) {
						arr.get(i).zipc=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("phonenumber") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < arr.size(); i++) {
					if (arr.get(i).phonenumber.equals(name) ) {
						arr.get(i).phonenumber=updatename;
						break;
					}
				}
			}
			editrecord--;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		addcontact();
		editcontact();
	}
}
