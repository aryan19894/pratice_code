package com.common;

import jdk.nashorn.internal.objects.Global;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigInput {
    private static final String workspace = "E:\\code\\DSA\\Platform\\src\\main\\java\\";

    public BigInput() {
    }

    public static String input(String notepadPath) throws IOException {
        File file = new File(workspace + "\\" + notepadPath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        return st;
    }

    public static String inputLineByLine(String notepadPath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(workspace + "\\" + notepadPath));

        String res;
        for (res = ""; scanner.hasNextLine(); res = res + scanner.nextLine() + "@") {
        }

        return res;
    }

    public static void formatInput(List<Integer> out, String input) {
        String[] tokens = input.split(" ");
        String[] var3 = tokens;
        int var4 = tokens.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String r = var3[var5];
            out.add(Integer.parseInt(r.trim()));
        }
    }

    public static void formatInput(String out, List<List<Integer>> outList, String input) {
        String[] tokens = input.split("@");
        out = tokens[1];
        List<Integer> ref = null;

        for (int i = 3; i < tokens.length; ++i) {
            String[] data = tokens[i].split(" ");
            ref = new ArrayList();
            ref.add(Integer.parseInt(data[0]));
            ref.add(Integer.parseInt(data[1]));
            outList.add(ref);
        }
    }
}
