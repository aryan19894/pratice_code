package revise._2022.striver.DSAExperience.T1Array;

public class SortColors_medium_75 {
    static class Solution {
        // [Better]: find the frequency array and assign the value w.r.t its frequency
        public void sortColors(int[] nums) {
            int[] freq = new int[3];
            for (int num : nums)
                freq[num]++;

            int id = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < freq[i]; j++)
                    nums[id++] = i;
            }
        }

        // [Better]: find the frequency array and assign the value w.r.t its frequency
        public void sortColors2(int[] nums) {
            int[] freq = new int[3];
            for (int num : nums)
                freq[num]++;

            int id = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < freq[i]; j++)
                    nums[id++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums);
    }
}
