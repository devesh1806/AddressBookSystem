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
	
	public static ContactBook[] arr;
	
	//method for adding contact
	public static int addcontact() {
		
		//taking input
		Scanner sc = new Scanner(System.in);
		
		//Adding records.
		System.out.println("Enter number of record:");
		int record = sc.nextInt();
		int j = record;
		arr = new ContactBook[record];
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
			arr[(j-record)]=cb;
			record--;
		}
		return j;
	}
	
	//method for editing contact
	public static void editcontact(int total) {
		
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
				for(i = 0 ; i < total; i++) {
					if (arr[i].firstname.equals(name) ) {
						arr[i].firstname=updatename;
						break;
					}
				}
			}
			
			else if ( input1.equals("lastname") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].lastname.equals(name) ) {
						arr[i].lastname=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("address") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].address.equals(name) ) {
						arr[i].address=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("state") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].state.equals(name) ) {
						arr[i].state=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("city") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].city.equals(name) ) {
						arr[i].city=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("emailid") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].emailid.equals(name) ) {
						arr[i].emailid=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("zipc") ) {
				int name = sc.nextInt();
				int updatename = sc.nextInt();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].zipc == name ) {
						arr[i].zipc=updatename;
						break;
					}
				}
			}
			else if ( input1.equals("phonenumber") ) {
				String name = sc.nextLine();
				String updatename = sc.nextLine();
				
				int i;
				for(i = 0 ; i < total; i++) {
					if (arr[i].phonenumber.equals(name) ) {
						arr[i].phonenumber=updatename;
						break;
					}
				}
			}
			editrecord--;
		}
	}
	
	//method to delete record
	public static void deletecontact() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of record to be deleted:" );
		int delrecord = sc.nextInt();
		while( delrecord > 0 ) {
			
			System.out.println("Enter record name ");
			String name = sc.nextLine();
			name = name.replaceAll("\\s", "");
			
			for(int i = 0; i < arr.length ; i++ ) {
				if (arr[i].firstname.equals(name)) {
					arr[i]=null;
					break;
				}
			}
			delrecord--;
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many operation:");
		int operation = sc.nextInt();
		int total=0;
		int flag = 0;
		while(operation>0) {
			System.out.println("Enter 1.Add 2.Edit 3.delete 4.exit");
			int option = sc.nextInt();
			switch (option){
				case 1:
					total = addcontact();
					break;
				case 2:
					editcontact(total);
					break;
				case 3:
					deletecontact();
					break;
				case 4:
					flag = 1;
					break;
				default:
					System.out.println("Enter valid option");
					break;
			}
			if (flag == 1) break;
			operation--;
		}
	}
}

