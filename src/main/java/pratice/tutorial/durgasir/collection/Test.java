package pratice.tutorial.durgasir.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

class D {
	private int i;

	public D(int i) {
		super();
		this.i = i;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

}

public class Test {
	public static void main(String[] args) {
		ArrayList l = new ArrayList();
		//
		// Iterator itr = l.iterator();
		// ListIterator i = l.listIterator();
		//
		// System.out.println(itr.getClass().getName());
		// System.out.println(i.getClass().getName());
		//
		
		l.add(4);
		l.add("A");
		l.add("A");
		l.add(null);
		l.add("B");
		l.add(null);
		
		
		LinkedHashSet h = new LinkedHashSet(l);
		TreeSet<Object> t = new TreeSet();
		Object o = 4.3f;
		Object o1 = 4L;
		//t.add("A");
		t.add(o);
		t.add(o1);
		//t.add((Object)2);
		//t.add("A");
		
		
//		h.add(10);
//		h.add(12);
//		h.add(7);
//		h.add(null);
//		h.add("A");
		System.out.println(t);
		
//		System.out.println(h.add(new D(5)));
//		System.out.println(h.add(new D(4)));
//		System.out.println(h.add(new D(6)));

	}

}
