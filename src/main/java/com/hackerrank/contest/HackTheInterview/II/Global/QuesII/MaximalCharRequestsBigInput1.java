package com.hackerrank.contest.HackTheInterview.II.Global.QuesII;

import com.common.BigInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximalCharRequestsBigInput1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int q = in.nextInt();
        List<List<Integer>> l = new ArrayList();
        List<Integer> r = null;
        boolean bigInput = true;
        if (bigInput) {
            String pkgName = "com\\hackerrank\\contest\\HackTheInterview\\II\\Global\\QuesII\\";
            String filePath = pkgName + "MaximalCharRequests1.txt";
            BigInput.formatInput(s, l, BigInput.inputLineByLine(filePath));
        } else {
            for(int i = 0; i < q; ++i) {
                r = new ArrayList();
                r.add(in.nextInt());
                r.add(in.nextInt());
                l.add(r);
            }
        }

        System.out.println(Result.getMaxCharCount1(s, l).toString());
        System.out.println(Result.getMaxCharCount2(s, l).toString());
        System.out.println(Result.getMaxCharCount3(s, l).toString());
        System.out.println(Result.getMaxCharCount4(s, l).toString());
        System.out.println(Result.getMaxCharCount5(s, l).toString());
        System.out.println(ResultJustLargerSmaller.getMaxCharCount1(s, l).toString());
        System.out.println(ResultJustLargerSmaller.getMaxCharCount2(s, l).toString());
    }
}
