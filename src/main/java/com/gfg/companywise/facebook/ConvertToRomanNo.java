package com.gfg.companywise.facebook;

import com.common.Out;

public class ConvertToRomanNo {
    static public class Solution {
        String convertToRoman(int n) {
            String sym[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

			String result = "";
			for (int i = 0; i <= 12; i++) {
                while (n >= val[i]) {
					result += sym[i];
                    n -= val[i];
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        Out.print(sol.convertToRoman(n));
    }
}
