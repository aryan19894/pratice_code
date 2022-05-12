package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetMultipleNull {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet();
		t = new TreeSet(new MultipleNull());
		t.add("A");
		t.add(new Integer(5));

		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class MultipleNull implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return -1;
	}
}