package com.common;

public class Str {
    public static Integer[] toArray(String str) {
        if (str == null || str.length() == 0) return null;

        String[] ip = str.split(" ");
        if (ip.length == 0)
            ip = str.split(",");

        return Array.toInteger(ip);
    }
}
