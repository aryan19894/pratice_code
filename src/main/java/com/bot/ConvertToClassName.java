package com.bot;

import java.util.Scanner;

public class ConvertToClassName {
    public ConvertToClassName() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine();
        String[] token = str.split(" ");
        String camelCase = "";
        String[] var8 = token;
        int var7 = token.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            String t = var8[var6];
            if (t != null && !isNumeric(t)) {
                camelCase = camelCase + Character.toUpperCase(t.charAt(0)) + t.substring(1);
            }
        }

        System.out.println(camelCase);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }
}
