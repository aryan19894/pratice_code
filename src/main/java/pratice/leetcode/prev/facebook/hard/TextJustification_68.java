package pratice.leetcode.prev.facebook.hard;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            List<String> sub = new ArrayList<>();
            int currLen = 0;
            for (String word : words) {
//                if (currLen + word.length() <= maxWidth) {
//                    currLen += word.length() + 1;
//                    sub.add(word);
//                }
                if(currLen + word.length() > maxWidth) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < sub.size() - 1; i++)
                        sb.append(sub.get(i) + " ");
                    for (int i = currLen; i < maxWidth; i++)
                        sb.append(" ");
                    sb.append(sub.get(sub.size() - 1));
                    result.add(new String(sb));
                    currLen = 0;
                    sub = new ArrayList<>();
                }
                currLen += word.length() + 1;
                sub.add(word);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        Out.print(sol.fullJustify(words, maxWidth));
    }
}
