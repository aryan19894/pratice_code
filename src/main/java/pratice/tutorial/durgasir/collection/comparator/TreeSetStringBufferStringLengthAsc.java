package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetStringBufferStringLengthAsc {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet(new StringBufferStringAsc());
		t.add("raj");
		t.add("aryan");
		t.add("rahul");
		t.add("akash");
		t.add(new StringBuffer("raj"));
		t.add(new StringBuffer("lokesh"));
		t.add(new StringBuffer("rahul"));
		t.add(new StringBuffer("mithun"));
		t.add(new StringBuffer("anik"));

		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class StringBufferStringAsc implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString();
		String s2 = o2.toString();

		Integer len1 = (Integer) s1.length();
		Integer len2 = (Integer) s2.length();
		if (len1 == len2)
			return s1.compareTo(s2);

		return len1.compareTo(len2);
	}
}