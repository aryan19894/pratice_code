package com.common;

import com.common.converter.ListUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigInput {
    private static final String workspace = "E:\\code\\DSA\\Platform\\src\\main\\java\\";
    private static final String testCaseFolder = "E:\\code\\DSA\\Platform\\testcase\\";

    public static int[][] inputArray(String fileName) {
        String str = null;
        try {
            str = readLineByLine(testCaseFolder + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return to2D(str);
    }

    private static int[][] to2D(String input) {
        List<List<Integer>> res = new ArrayList();
        String[] tokens = input.split("@");
        for(String t: tokens) {
            List<Integer> out = new ArrayList<>();
            formatInput(out, t);
            res.add(out);
        }
        return ListUtil.toArray(res);
    }

    public static String input(String notepadPath) throws IOException {
        return read(workspace + "\\" + notepadPath);
    }

    private static String read(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        return st;
    }

    public static String inputLineByLine(String notepadPath) throws FileNotFoundException {
        return readLineByLine(workspace + "\\" + notepadPath);
    }

    private static String readLineByLine(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        String res = "";
        while (scanner.hasNextLine())
            res += scanner.nextLine() + "@";

        return res;
    }

    public static void formatInput(List<Integer> out, String input) {
        String[] tokens = input.split(" ");

        for (String t : tokens)
            out.add(Integer.parseInt(t.trim()));
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
