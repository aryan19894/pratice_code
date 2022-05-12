// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MajorityElementIi_229.java

package pratice.striver.DSAExperience.T1Array;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_Medium_229 {
    static class Solution {

        public List majorityElement(int nums[]) {
            List ans = new ArrayList();
            int cnt1 = 0;
            int cnt2 = 0;
            int ele1 = -1;
            int ele2 = -1;
            int ai[] = nums;
            int i = ai.length;
            for (int j = 0; j < i; j++) {
                int num = ai[j];
                if (ele1 == num) {
                    cnt1++;
                    continue;
                }
                if (ele2 == num) {
                    cnt2++;
                    continue;
                }
                if (cnt1 == 0) {
                    ele1 = num;
                    cnt1 = 1;
                    continue;
                }
                if (cnt2 == 0) {
                    ele2 = num;
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }

            return ans;
        }

        Solution() {
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        int nums[] = {
                2, 2, 1, 1, 1, 2, 2
        };
        List ans = sol.majorityElement(nums);
        Out.print(ans);
    }
}
