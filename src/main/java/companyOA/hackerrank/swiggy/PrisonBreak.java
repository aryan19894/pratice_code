package companyOA.hackerrank.swiggy;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class ResultPrisonBreak {

    /*
     * Complete the 'prison' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER_ARRAY h
     *  4. INTEGER_ARRAY v
     */

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 1; i <= n + 1; i++)
            s1.add(i);

        for (int i = 1; i <= m + 1; i++)
            s2.add(i);

        for (int i = 0; i < h.size(); i++)
            s1.remove(h.get(i));

        for (int i = 0; i < v.size(); i++)
            s2.remove(v.get(i));

        int[] list1 = new int[s1.size()];
        int[] list2 = new int[s2.size()];

        int i = 0;
        Iterator it1 = s1.iterator();
        while (it1.hasNext()) {
            list1[i++] = (int) it1.next();
        }

        i = 0;
        Iterator it2 = s2.iterator();
        while (it2.hasNext()) {
            list2[i++] = (int) it2.next();
        }

        Arrays.sort(list1);
        Arrays.sort(list2);

        int maxH = 0, p1 = 0, maxV = 0, p2 = 0;

        for (int j = 0; j < list1.length; j++) {
            maxH = Math.max(maxH, list1[j] - p1);
            p1 = list1[j];
        }

        for (int j = 0; j < list2.length; j++) {
            maxV = Math.max(maxV, list2[j] - p2);
            p2 = list2[j];
        }

        return (long) maxV * maxH;
    }

}

public class PrisonBreak {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int hCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = IntStream.range(0, hCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int vCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> v = IntStream.range(0, vCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = ResultPrisonBreak.prison(n, m, h, v);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
