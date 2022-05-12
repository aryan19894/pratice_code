package other.pratice;

import java.util.Set;
import java.util.TreeSet;

class A implements Comparable<A>{
	private String fname;
	private String lname;
	
	@Override
	public String toString() {
		return "A [fname=" + fname + ", lname=" + lname + "]";
	}
	public A(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}
	@Override
	public int compareTo(A arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
//class B extends A {
//
//	static {
//		System.out.println("B static block");
//	}
//	{
//		System.out.println("B instance block");
//	}
//	public B() {
//		System.out.println("B cons");;
//	}
//}
public class TestClass {
	public static void main(String[] ar) {
		A a1=new A("fn1", "ln1");
		A a2 = new A("fn2", "ln2");
		Set<A> map = new TreeSet<>();
		
		map.add(a2);
		map.add(null);
		map.add(a1);
		
		for(A a: map)
			System.out.println(a);
	}
	
}
