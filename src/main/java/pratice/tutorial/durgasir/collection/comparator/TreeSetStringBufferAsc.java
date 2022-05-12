package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetStringBufferAsc {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet(new StringBufferAsc());
		t.add(new StringBuffer("a"));
		t.add(new StringBuffer("z"));
		t.add(new StringBuffer("c"));
		t.add(new StringBuffer("e"));
		t.add(new StringBuffer("x"));
		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class StringBufferAsc implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString();
		String s2 = o2.toString();
		return s1.compareTo(s2);
	}
}