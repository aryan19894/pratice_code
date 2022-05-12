package pratice.gfg.companywise.facebook;

import java.util.HashMap;

// [Optimal] O(n2) - 1 arr and 2 map - storing both keys
class FindSumPairs {
    int[] arr;
    HashMap<Integer, Integer> map, map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.arr = nums2;
        map = new HashMap<>();
        map2 = new HashMap<>();
        for (int n : nums1)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for (int n : nums2)
            map2.put(n, map2.getOrDefault(n, 0) + 1);
    }

    public void add(int index, int val) {
        map2.put(arr[index], map2.get(arr[index]) - 1);
        arr[index] += val;
        map2.put(arr[index], map2.getOrDefault(arr[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int key1 : map.keySet())
            count += map.get(key1) * map2.getOrDefault(tot - key1, 0);
        return count;
    }
}


public class FindingPairsWithACertainSum_medium_1865 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {1, 4, 5, 2, 5, 4};

        FindSumPairs pairs = new FindSumPairs(arr1, arr2);
        System.out.println(pairs.count(7));
        pairs.add(3, 2);
        System.out.println(pairs.count(8));
        System.out.println(pairs.count(4));
        pairs.add(0, 1);
        pairs.add(1, 1);
        System.out.println(pairs.count(7));
    }
}
