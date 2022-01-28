package com.striver.DSAExperience.T8Bits;

import com.common.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet_Easy {
    // [Optimal] TC: O(2powerN*N), SC: O(1) - bit manipulation
    // 2powerN - for first iteration
    // N is for checking bit is on or off
    public static List<String> allPossibleStrings(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        int totalStr = (int) Math.pow(2, n);
        for (int i = 1; i < totalStr; i++) {
            String sub = "";
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) != 0)
                    sub += s.charAt(j);
            ans.add(sub);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = allPossibleStrings("abc");
        Printer.print(ans);
    }
}
