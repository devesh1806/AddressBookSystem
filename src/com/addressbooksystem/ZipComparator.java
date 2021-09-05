package com.addressbooksystem;

import java.util.Comparator;

public class ZipComparator implements Comparator<ContactBook> {

	public int compare(ContactBook n1,ContactBook n2) {
		Integer numberOne = n1.zip;
		Integer numberTwo = n2.zip;
		return numberOne.compareTo(numberTwo);
	}

}
