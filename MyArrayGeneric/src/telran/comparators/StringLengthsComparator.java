package telran.comparators;

import java.util.Comparator;

public class StringLengthsComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}

}
