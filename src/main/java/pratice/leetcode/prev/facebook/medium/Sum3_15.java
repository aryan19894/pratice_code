// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Sum3_15.java

package pratice.leetcode.prev.facebook.medium;

import java.util.*;

class Sum3_15
{

    Sum3_15()
    {
    }

    public List threeSum(int nums[])
    {
        List list = new ArrayList();
        if(nums == null || nums.length == 0)
            return list;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++)
            if(i <= 0 || nums[i] != nums[i - 1])
            {
                int j = i + 1;
                for(int k = nums.length - 1; j < k;)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0)
                    {
                        list.add(Arrays.asList(new Integer[] {
                            Integer.valueOf(nums[i]), Integer.valueOf(nums[j]), Integer.valueOf(nums[k])
                        }));
                        j++;
                        for(k--; j < k && nums[j] == nums[j - 1]; j++);
                        for(; j < k && nums[k] == nums[k + 1]; k--);
                    } else
                    if(sum < 0)
                        j++;
                    else
                        k--;
                }

            }

        return list;
    }
}
