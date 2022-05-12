package pratice.tutorial.durgasir.class3;

public class Car {
	private Engine e = new Engine();

	public Engine getE() {
		return e;
	}

	public void setE(Engine e) {
		this.e = e;
	}
	
	public String getEngineName() {
		return e.getEngineName();
	}
}
