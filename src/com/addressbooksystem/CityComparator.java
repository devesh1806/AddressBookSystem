package com.addressbooksystem;

import java.util.Comparator;

public class CityComparator implements Comparator<ContactBook> {

	public int compare(ContactBook n1,ContactBook n2) {
		return n1.city.compareTo(n2.city);
	}

}
