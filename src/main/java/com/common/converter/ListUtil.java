package com.common.converter;

import java.util.List;

public class ListUtil {
    public static int[][] toArray(List<List<Integer>> list) {
        int[][] res = new int[list.size()][list.get(0).size()];
        int i = 0;
        for (List<Integer> ls : list) {
            int j = 0;
            for (int ele : ls)
                res[i][j++] = ele;
            i++;
        }

        return res;
    }
}
