package pratice.leetcode.prev.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            int i = 0, n = words.length;
            while (i < n) {
                StringBuilder sb = new StringBuilder();
                List<String> line = new ArrayList<>();
                int currLen = 0;
                boolean thisLine = true;

                while (i < n && thisLine) {
                    String word = words[i];
                    if (currLen + line.size() + word.length() <= maxWidth) {
                        line.add(word);
                        currLen += word.length();
                        i++;
                    } else thisLine = false;
                }

                int spaces = maxWidth - currLen;
                if (line.size() == 1 || i == n) {
                    for (String w : line) {
                        sb.append(w);
                        if (spaces-- > 0) {
                            sb.append(' ');
                        }
                    }
                    appendSpace(sb, spaces);
                } else {
                    int lineSize = line.size();
                    int commonSpace = spaces / (lineSize - 1);
                    int extraSpace = spaces % (lineSize - 1);
                    for (int j = 0; j < lineSize; j++) {
                        String word = line.get(j);
                        sb.append(word);
                        if (j == lineSize - 1) continue;
                        appendSpace(sb, commonSpace);
                        if (extraSpace > 0) {
                            sb.append(' ');
                            extraSpace--;
                        }
                    }
                }
                result.add(sb.toString());
            }
            return result;
        }

        private void appendSpace(StringBuilder sb, int spaces) {
            for (int j = 0; j < spaces; j++)
                sb.append(' ');
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> result = sol.fullJustify(words, maxWidth);
        for (String r : result)
            System.out.println("\""+r+"\"");
    }
}
