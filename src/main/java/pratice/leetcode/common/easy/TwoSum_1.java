// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TwoSum_1.java

package pratice.leetcode.common.easy;

import java.util.HashMap;
import java.util.Map;

class TwoSum_1
{

    TwoSum_1()
    {
    }

    public int[] twoSum(int nums[], int target)
    {
        Map map = new HashMap();
        int res[] = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(Integer.valueOf(diff)))
            {
                res[1] = i;
                res[0] = ((Integer)map.get(Integer.valueOf(diff))).intValue();
                return res;
            }
            map.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
        }

        return res;
    }
}
