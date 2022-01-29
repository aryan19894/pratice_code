package com.striver.DSAExperience.T5Greedy;

import com.common.Out;

import java.util.Arrays;

public class JobSequencingProblem {
    //[Optimal] O(nlogn)+O(n*m), O(m) - m is for check each meeting with last deadline day to its 1st days, traversal.
    // sort on basis of end time, check and verify to fill on from the last day of its deadline to each meeting 1by1.
    static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int[] res = new int[2];
        int maxDeadline = Integer.MIN_VALUE;
        for (Job j : arr)
            maxDeadline = Math.max(maxDeadline, j.deadline);
        int[] jobSchedule = new int[maxDeadline + 1];
        Arrays.fill(jobSchedule, -1);

        for (Job j : arr) {
            if (res[0] == maxDeadline)
                break;

            int currentElement = j.deadline;
            while (currentElement > 0) {
                if (jobSchedule[currentElement--] == -1) {
                    jobSchedule[++currentElement] = j.id;
                    res[0]++;
                    res[1] += j.profit;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[][] = {{1, 4, 20}, {2, 5, 60}, {3, 6, 70}, {4, 6, 65}
                , {5, 4, 25}, {6, 2, 80}, {7, 2, 10}, {8, 2, 22}};
        int[] ans = JobScheduling(Job.toJob(nums), nums.length);
        Out.print(ans);
    }
}

class Job {
    int id, profit, deadline;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }

    public static Job[] toJob(int[][] nums) {
        Job[] jobs = new Job[nums.length];
        int i = 0;
        for (int[] n : nums) {
            jobs[i++] = new Job(n[0], n[1], n[2]);
        }
        return jobs;
    }
}