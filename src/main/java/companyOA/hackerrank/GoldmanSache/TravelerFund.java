package companyOA.hackerrank.GoldmanSache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelerFund {

    public static int requiredAmountAtStart(List<Integer> netSaving) {
        int startSavings = 0;
        int totalSavings = 0;
        for (int i = 0; i < netSaving.size(); i++) {
            if (netSaving.get(i) + totalSavings <= 0) {
                startSavings += Math.abs(netSaving.get(i) + totalSavings) + 1;
                totalSavings = 1;
            } else {
                totalSavings += netSaving.get(i);
            }
        }
        return startSavings;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> netSaving = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            netSaving.add(in.nextInt());
        }
        System.out.println(requiredAmountAtStart(netSaving));
    }

}
