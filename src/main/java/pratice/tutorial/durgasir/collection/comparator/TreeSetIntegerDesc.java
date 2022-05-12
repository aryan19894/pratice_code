package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetIntegerDesc {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet(new IntegerDesc());
		t.add(new Integer(10));
		t.add(new Integer(13));
		t.add(new Integer(8));
		t.add(new Integer(11));
		
		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class IntegerDesc implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		if (i1 < i2)
			return +1;
		else if (i1 > i2)
			return -1;
		else
			return 0;
	}
}