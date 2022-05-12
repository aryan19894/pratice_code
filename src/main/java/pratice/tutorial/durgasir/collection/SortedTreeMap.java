package pratice.tutorial.durgasir.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class SortedTreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap t = new TreeMap(new InsertionOrder());
		t.put(101, "a");
		t.put(121, "b");
		t.put(141, "x");
		t.put(11, "z");
		t.put(101, "b");
		
		System.out.println(t.headMap(121));
		
		System.out.println(t);
	}

}

class InsertionOrder implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Integer i1 =(Integer)o1;
		Integer i2 =(Integer)o2;
		
		return 1;
		//return i1.compareTo(i2);
	}
	
}
