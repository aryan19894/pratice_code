package companyOA.hackerrank.Alcatraz.SmarshIndia.ques3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {
    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0) < b.get(0)) {
                c.add(a.get(0));
                a.remove(0);
            } else if (a.get(0) == b.get(0)) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(b.get(0));
                b.remove(0);
            }
        }
        if (!a.isEmpty())
            c.addAll(a);
        if (!b.isEmpty())
            c.addAll(b);

        return c;
    }
}

public class MergeTwoArrays {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(scan.nextInt());
        }
        int m = scan.nextInt();
        List<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            b.add(scan.nextInt());
        }
        List<Integer> c = Result.mergeArrays(a, b);
        System.out.println(c);
    }

}
