package com.addressbooksystem;

import java.util.Comparator;

public class StateComparator implements Comparator<ContactBook> {

	public int compare(ContactBook n1,ContactBook n2) {
		return n1.state.compareTo(n2.state);
	}

}
