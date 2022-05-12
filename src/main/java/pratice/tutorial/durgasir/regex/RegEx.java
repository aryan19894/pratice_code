package pratice.tutorial.durgasir.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "919122851421111111111";
		Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(num);
		if(m.find() && m.group().equals(num))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
