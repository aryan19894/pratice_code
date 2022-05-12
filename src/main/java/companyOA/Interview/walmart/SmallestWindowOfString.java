package companyOA.Interview.walmart;

public class SmallestWindowOfString {
	static String smallestWindow(String s, String t) {
		int len1 = s.length();
		int len2 = t.length();

		if (len1 < len2) {
			System.out.println("No window");
			return "";
		}

		int[] has_s = new int[256];
		int[] has_t = new int[256];

		for (int i = 0; i < len2; i++)
			has_t[t.charAt(i)]++;

		int start = 0, startIndex = -1;
		int minLen = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {
			has_s[s.charAt(j)]++;

			if (has_s[s.charAt(j)] <= has_t[s.charAt(j)])
				count++;

			if (count == len2) {
				while (has_s[s.charAt(start)] > has_t[s.charAt(start)] || has_t[s.charAt(start)] == 0) {
					if (has_s[s.charAt(start)] > has_t[s.charAt(start)])
						has_s[s.charAt(start)]--;
					start++;
				}

				int lenWind = j - start + 1;
				if (minLen > lenWind) {
					minLen = lenWind;
					startIndex = start;
				}
			}
		}

		if (startIndex == -1) {
			System.out.println("No window");
			return "";
		}

		return s.substring(startIndex, startIndex + minLen);
	}

	public static void main(String[] args) throws java.lang.Exception {
		String s = "ADOBECODEBANC";
		String t = "CAN";

		String ans = smallestWindow(s, t);
		System.out.println(ans);
	}
}
