package com.bot;

import java.util.Scanner;

public class ConvertToClassName {
    public ConvertToClassName() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = in.nextLine().trim();
        String[] token = str.split(" ");
        String camelCase = "";
        String[] var8 = token;
        int var7 = token.length;

        for(int i = 0; i < var7; ++i) {
            String t = var8[i];
            if (t != null && !isNumeric(t)) {
                camelCase = camelCase + Character.toUpperCase(t.charAt(0)) + t.substring(1);
            }
        }
        camelCase = camelCase.replaceAll("[^A-Za-z0-9]", "");
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
