package book.karumachi.string;

public class StringMatching {
    public static int bruteForce(String str, int n, String substr, int m) {
        for (int i = 0; i <= (n - m); i++) {
            int j = 0;
            while (j < m && str.charAt(i + j) == substr.charAt(j++)) ;
            if (j == m)
                return i;
        }
        return -1;
    }

    public static int KMPAlgo(String str, int n, String substr, int m) {
        int[] prefix = calcPrefix(substr, m);
        int i = 0, j = 0;
        while (i < n) {
            if (str.charAt(i) == substr.charAt(j)) {
                if (j == m - 1) return i - j;
                else {
                    i++;
                    j++;
                }
            } else if (j > 0)
                j = prefix[j - 1];
            else
                i++;
        }
        return 0;
    }

    private static int[] calcPrefix(String substr, int m) {
        int[] prefix = new int[m];
        int i = 1, j = 0;
        while (i < m) {
            if (substr.charAt(i) == substr.charAt(j))
                prefix[i++] = ++j;
            else if (j > 0)
                j = prefix[j - 1];
            else
                i++;
        }

        return prefix;
    }

    public static void main(String[] args) {
        String str = "bacbabababacaca";
        String substr = "ababaca";
        System.out.println(bruteForce(str, str.length(), substr, substr.length()));
        System.out.println(KMPAlgo(str, str.length(), substr, substr.length()));
    }
}
