package pratice.hackerrank.contest.HackTheInterview.II.Global.QuesI;

import pratice.common.BigInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDistributionBigInput {
    public ProductDistributionBigInput() {
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> a = new ArrayList();
        boolean bigInput = true;
        if (bigInput) {
            String input = BigInput.input("com\\hackerrank\\contest\\HackTheInterview\\II\\Global\\QuesI\\" +
                    "ProductDistribution.txt");
            BigInput.formatInput(a, input);
        } else {
            for (int i = 0; i < n; ++i) {
                int aItem = in.nextInt();
                a.add(aItem);
            }
        }
        System.out.println(Result.maxScore1(a, m));
        System.out.println(Result.maxScore2(a, m));
        System.out.println(Result.maxScore3(a, m));
    }
}
