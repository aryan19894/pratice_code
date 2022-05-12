package pratice.gfg.companywise.google;

import pratice.common.Out;

import java.util.Stack;

public class LongestValidParentheses {
    static int maxLength(String S) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                st.push(i);
            else {
                if (!st.isEmpty())
                    st.pop();

                if (!st.isEmpty())
                    count = Math.max(count, i - st.peek());
                else st.push(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = ")()(()))))";
        Out.print(maxLength(S));
    }
}
