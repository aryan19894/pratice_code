package pratice.tutorial.durgasir.pkg;

public class StringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("abcd").append("xy").append("z").insert(2, "xy").reverse().delete(2, 5);
		System.out.println(sb);
	}

}
