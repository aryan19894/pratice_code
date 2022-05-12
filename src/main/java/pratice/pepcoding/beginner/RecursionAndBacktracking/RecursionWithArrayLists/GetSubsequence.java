// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetSubsequence.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.RecursionWithArrayLists;

import java.io.PrintStream;
import java.util.*;

public class GetSubsequence {

    public GetSubsequence() {
    }

    public static void main(String args[])
            throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList();
            bres.add("");
            return bres;
        } else {
            char ch = str.charAt(0);
            String ros = str.substring(1);
            ArrayList<String> rres = gss(ros);
            ArrayList<String> mres = new ArrayList();
            Iterator var5 = rres.iterator();

            String s;
            while (var5.hasNext()) {
                s = (String) var5.next();
                mres.add("" + s);
            }

            var5 = rres.iterator();

            while (var5.hasNext()) {
                s = (String) var5.next();
                mres.add(ch + s);
            }

            return mres;
        }
    }
}
