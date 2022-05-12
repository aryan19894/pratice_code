package companyOA.Interview.techmojo;

public class Employee {
	private int id;
	private String name;
	private long salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		// int result = 1;
		// result = prime * result + id;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		// result = prime * result + (int) (salary ^ (salary >>> 32));
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Current: "+this);
		System.out.println("Compare: "+obj);
		
		return false;
	}

}
