package MyKata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// 2010.05.31:  practice problem:  "given a whitespace-delimited String of words, return
// the list of the top 50% of longest unique words"

public class LongestUniqueWords {
	public static String[] count(String s) {

		Set<String> mySet = new TreeSet<String>( new Comparator<String>() {
			public int compare(String a, String b) {
				return a.length() == b.length() ? a.compareTo(b) : b.length() - a.length();
			}
		});

		for (String x : s.split("\\W+")) {
			mySet.add(x);
		}

		List<String> myList = new ArrayList<String>(mySet);
		int halfSize = myList.size() / 2;

		return myList.subList(0, halfSize).toArray(new String[halfSize]);
	}
	
    public static void main(String[] args) {
    }	
}
