package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetStringDesc {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet(new StringDesc());
		t.add("raj");
		t.add("aryan");
		t.add("rahul");
		t.add("akash");

		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class StringDesc implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString();
		String s2 = (String) o2;
		return s2.compareTo(s1);
	}
}