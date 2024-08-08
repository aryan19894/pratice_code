package companyOA.hackerearth.UIPath;

import java.util.HashSet;
import java.util.Scanner;

public class SearchForThreeNumber {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        int sum = s.nextInt();

        findNumer(n, a, sum);
    }

    private static boolean findNumer(int n, int[] a, int sum) {
        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> s = new HashSet<>();
            int currSum = sum - a[i];

            for (int j = i + 1; j < n; j++) {
                if (s.contains(currSum - a[j])) {
                    System.out.printf("%d %d %d", a[i], currSum - a[j], a[j]);
                    return true;
                }
                s.add(a[j]);
            }
        }
        return false;
    }
}
