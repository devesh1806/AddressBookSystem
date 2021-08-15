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
	int phonenumber; 
	
	
	//constructor of class
	ContactBook( String firstname, String lastname, String address, String state, String city, String emailid, int zipc, int phonenumber){
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
		
		
	}
}
