package pratice.striver.DSAExperience.T7RecursionBacktracking.theory;

public class PalindromeString {
    // [Recursive] O(n/2) - upto mid of element is iteration
    private static boolean palindrome(String str, int i, int n) {
        if (i >= n / 2) return true;
        return str.charAt(i) == str.charAt(n - i - 1) && palindrome(str, i + 1, n);
    }

    public static void main(String[] args) {
        String str = "bannabb";
        System.out.println(palindrome(str, 0, str.length()));
    }
}
