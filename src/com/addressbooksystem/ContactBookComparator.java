package com.addressbooksystem;

import java.util.Comparator;

public class ContactBookComparator implements Comparator<ContactBook> {
	public int compare(ContactBook n1,ContactBook n2) {
		if (n1.firstName.compareTo(n2.firstName)!= 0) return n1.firstName.compareTo(n2.firstName);
		else return n1.lastName.compareTo(n2.lastName);
	}
}
