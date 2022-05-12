package companyOA.qualified;

import java.util.HashMap;

class Challenge1 {
	public static Integer decode(String roman) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int res = 0;
		for (int i = 0; i < roman.length(); i++) {
			if (i > 0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i - 1)))
				res += map.get(roman.charAt(i)) - 2 * map.get(roman.charAt(i - 1));
			else
				res += map.get(roman.charAt(i));
		}

		return res;
	}
}

public class ConvertRomanToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Challenge1.decode("MDXII"));
	}

}
