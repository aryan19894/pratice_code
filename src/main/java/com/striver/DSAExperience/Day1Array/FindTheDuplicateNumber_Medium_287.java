// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindTheDuplicateNumber_Medium_287.java

package com.striver.DSAExperience.Day1Array;

import java.io.PrintStream;

public class FindTheDuplicateNumber_Medium_287
{
    static class Solution
    {

        public int findDuplicate1(int nums[])
        {
            int visited[] = new int[nums.length + 1];
            int ai[] = nums;
            int j = ai.length;
            for(int k = 0; k < j; k++)
            {
                int a = ai[k];
                visited[a]++;
            }

            for(int i = 1; i < visited.length; i++)
                if(visited[i] > 1)
                    return i;

            return -1;
        }

        public int findDuplicate2(int nums[])
        {
            int slow = nums[0];
            int fast = nums[0];
            do
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while(slow != fast);
            for(fast = nums[0]; slow != fast; fast = nums[fast])
                slow = nums[slow];

            return slow;
        }

        Solution()
        {
        }
    }


    public static void main(String args[])
    {
        Solution sol = new Solution();
        int nums[] = {
            1, 3, 4, 2, 2
        };
        int ans = sol.findDuplicate2(nums);
        System.out.println(ans);
    }
}
