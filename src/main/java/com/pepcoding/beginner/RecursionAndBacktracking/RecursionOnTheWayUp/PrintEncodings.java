// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintEncodings.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintEncodings {

    public PrintEncodings() {
    }

    public static void main(String args[])
            throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
        } else {
            char ch;
            if (str.length() == 1) {
                ch = str.charAt(0);
                if (ch == '0') {
                    return;
                }

                int chv = ch - 48;
                char code = (char) (97 + chv - 1);
                System.out.println(ans + code);
            } else {
                ch = str.charAt(0);
                String ros = str.substring(1);
                if (ch == '0') {
                    return;
                }

                int ch12v = ch - 48;
                char code = (char) (97 + ch12v - 1);
                printEncodings(ros, ans + code);
                ch12v = Integer.parseInt(str.substring(0, 2));
                ros = str.substring(2);
                if (ch12v <= 26) {
                    int chv = ch - 48;
                    code = (char) (97 + ch12v - 1);
                    printEncodings(ros, ans + code);
                }
            }
        }
    }
}
