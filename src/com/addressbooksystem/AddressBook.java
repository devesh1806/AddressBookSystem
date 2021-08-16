package com.addressbooksystem;
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
	public static void main(String[] args) {
		
		
		//taking input
		Scanner sc = new Scanner(System.in);
		
		//Adding records.
		System.out.println("Enter number of record:");
		int record = sc.nextInt();
		ContactBook[] arr= new ContactBook[record];
		int j = record;
		while ( record!=0 ) {
			
			String firstname= sc.nextLine();
			
			String lastname= sc.nextLine();
			
			String address= sc.nextLine();
			
			String state= sc.nextLine();
			
			String city= sc.nextLine();
			
			String emailid= sc.nextLine();
			
			int zipc=sc.nextInt(); 
			
			String phonenumber=sc.nextLine(); 
			
			firstname = firstname.replace("\\s", "");
			phonenumber = phonenumber.replace("\\s", "");
			//creation of object or address book creation
			ContactBook cb = new ContactBook(firstname,lastname,address,state,city,emailid,zipc,phonenumber);
			arr[(j-record)]=cb;
			record--;
		}
	}
}
