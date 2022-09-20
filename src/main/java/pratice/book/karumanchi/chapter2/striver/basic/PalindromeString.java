package pratice.book.karumanchi.chapter2.striver.basic;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("mmadddam", 0));
    }

//    private static boolean isPalindrome(String str, int i) {
//        int n = str.length();
//        if (i >= n / 2) return true;
//
//        if (str.charAt(i) == str.charAt(n - i - 1))
//            return isPalindrome(str, i + 1);
//        return false;
//    }

    private static boolean isPalindrome(String str, int i) {
        int n = str.length();
        if (i >= n / 2) return true;
        if (str.charAt(i) != str.charAt(n - i - 1)) return false;

        return isPalindrome(str, i + 1);
    }

}
