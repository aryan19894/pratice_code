package companyOA.hackerrank.Alcatraz.SmarshIndia.ques1;

import java.util.Scanner;

class Result {
	public static String longestEvenWord(String str) {
		String maxString = "";
		for (String s : str.split(" ")) {
			if (s.length() % 2 == 0) {
				if (maxString.length() < s.length())
					maxString = s;
			}
		}
		return (maxString == "") ? "00" : maxString;
	}
}

public class LongestEvenLengthWord {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		System.out.println(Result.longestEvenWord(s));
	}

}
