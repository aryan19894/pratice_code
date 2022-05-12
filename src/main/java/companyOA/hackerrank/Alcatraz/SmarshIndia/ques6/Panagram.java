package companyOA.hackerrank.Alcatraz.SmarshIndia.ques6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

	/*
	 * Complete the 'isPangram' function below.
	 *
	 * The function is expected to return a STRING. The function accepts
	 * STRING_ARRAY pangram as parameter.
	 */

	public static String isPangram(List<String> pangram) {
		// Write your code here
		String res = "";

		ArrayList<Character> track = new ArrayList<Character>();
		for (String str : pangram) {
			track.clear();
			if (str.length() < 26 || str == "") {
				res += "0";
				continue;
			}
			for (char c : str.toCharArray()) {
				if (!track.contains(c) && 
						track.size() < 26 && 
						(c >= 'a' && c <= 'z'))
					track.add(c);
			}
			if (track.size() >= 26)
				res += "1";
			else
				res += "0";
		}
		return res;
	}

}

public class Panagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<String> track = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String s = scan.nextLine();
			track.add(s);
		}
		System.out.println(Result.isPangram(track));
	}

}
