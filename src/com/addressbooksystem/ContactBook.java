package com.addressbooksystem;

public class ContactBook {
	
	String firstname; 
	String lastname; 
	String address; 
	String state; 
	String city; 
	String emailid;
	int zipc; 
	String phonenumber; 
	
	
	//constructor of class
	public ContactBook( String firstname, String lastname, String address, String state, String city, String emailid, int zipc, String phonenumber){
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
