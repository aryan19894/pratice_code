package pratice.tutorial.durgasir.pkg;

public class Student {
	String name;
	int roll;
	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + roll;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		try {
			Student s=(Student)obj;
			if(this.name.equals(s.name) && this.roll == s.roll)
				return true;
			else 
				return false;
		} catch(NullPointerException | ClassCastException e) {
			return false;
		}
		
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (roll != other.roll)
//			return false;
//		return true;
	}
	public static void main(String[] args) {
		Student s1 = new Student("a", 10);
		Student s2 = new Student("b", 20);
		Student s3 = new Student("a", 10);
		Student s4 = s1;
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals("a"));
		System.out.println(s1.equals(null));
		
		
		
	}
}
