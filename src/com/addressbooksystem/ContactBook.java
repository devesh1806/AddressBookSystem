package com.addressbooksystem;

public class ContactBook {
	
	String firstName; 
	String lastName; 
	String address; 
	String state; 
	String city; 
	String emailId;
	int zip; 
	String phoneNumber; 
	
	
	//constructor of class
	public ContactBook( String firstName, String lastName, String address, String state, String city, String emailId, int zip, String phoneNumber){
		this.firstName = firstName; 
		this.lastName=lastName; 
		this.address=address; 
		this.state=state; 
		this.city=city;
		this.emailId= emailId ;
		this.zip=zip; 
		this.phoneNumber=phoneNumber;
		
	}
	
	@Override
	public String toString() {
		return "Firstname: " + firstName +" Lastname: " + lastName+" Address: " + address+" State: " + state+ " City: "+ city+ " Emailid: " + emailId+" Zipcode: " + zip+" Phone number: " + phoneNumber+"\n";
	}
}