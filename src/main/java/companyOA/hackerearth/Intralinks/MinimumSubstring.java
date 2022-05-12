package companyOA.hackerearth.Intralinks;

public class MinimumSubstring {
	static final int a = 256;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "FORCESABCDEFDIVGHIJKLMNOPQRSTUVWXYZ";
		

		System.out.print("Smallest window is :\n " + solve(str));
	}

	static int solve(String str) {
		String pat = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int len1 = str.length();
		int len2 = pat.length();

		if (len1 < len2) {
			return 0;
		}

		int hash_pat[] = new int[256];
		int hash_str[] = new int[256];

		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {
			hash_str[str.charAt(j)]++;
			if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			if (count == len2) {
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		if (start_index == -1) {
			return 0;
		}

		return str.substring(start_index, start_index + min_len).length();
	}
}
