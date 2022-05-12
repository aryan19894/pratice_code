package pratice.tutorial.durgasir.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparable {
	int eid;
	String name;

	public Employee(int eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Object o1) {
		Employee e = (Employee) o1;
		return this.eid - e.eid;
	}

}

public class TreeSetEmployeeBoth {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		TreeSet t = new TreeSet();
		Employee e1 = new Employee(100, "nag");
		Employee e2 = new Employee(200, "balaih");
		Employee e3 = new Employee(50, "chiru");
		Employee e4 = new Employee(150, "venki");
		Employee e5 = new Employee(100, "nag");

		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);

		System.out.println(t);

		t = new TreeSet(new NameComparator());
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);

		System.out.println(t);
	}
}

@SuppressWarnings("rawtypes")
class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;

		return e1.name.compareTo(e2.name);
	}
}