package pratice.striver.DSAExperience.T7RecursionBacktracking;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum_Easy {
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        subsetSumsRecursive(0, 0, arr, N, result);
        Collections.sort(result);
        return result;
    }

    // [Optimal] O(2powNlog2powN), O(2powN) - Recursive with element is picked or not
    private static void subsetSumsRecursive(int id, int sum, ArrayList<Integer> arr,
                                            int n, ArrayList<Integer> result) {
        if (id == n) {
            result.add(sum);
            return;
        }

        //picked element
        subsetSumsRecursive(id + 1, sum + arr.get(id), arr, n, result);
        //not picked
        subsetSumsRecursive(id + 1, sum, arr, n, result);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        //arr.add(6);

        arr = subsetSums(arr, arr.size());
        Out.print(arr);
    }
}
