package companyOA.Interview.gartner.round2;

import java.util.Stack;

public class ReverseWord {
    public static void main(String[] args) {
        String line = "This is a boy";
        line = reverseWord(line);
        System.out.print(line);
    }

    private static String reverseWord(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch != ' ')
                st.push(ch);
            else {
                while (!st.isEmpty()) {
                    ans += st.pop();
                }
                ans += " ";
            }
        }

        // for last word
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}
