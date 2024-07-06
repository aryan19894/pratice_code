package pratice.book.crackingCodingInterview;

import pratice.tutorial.durgasir.class2.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathApp {
    private static final int N = 100;

    public static long algo1() {
        long start = System.currentTimeMillis();
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                for (int c = 1; c <= N; c++) {
                    for (int d = 1; d <= N; d++) {
                        if (cube(a) + cube(b) == cube(c) + cube(d))
                            System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
//        System.out.println("----ALGO1--------------------");
//        System.out.println("Start: " + start);
//        System.out.println("End: " + end);
//        System.out.println("Duration: " + (end - start + 1));
        return (end - start + 1);
    }

    public static long algo2() {
        long start = System.currentTimeMillis();
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                for (int c = 1; c <= N; c++) {
                    int d = (int) Math.pow(cube(a) + cube(b) - cube(c), 1 / 3);
                    if (cube(a) + cube(b) == cube(c) + cube(d))
                        System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
                }
            }
        }

        long end = System.currentTimeMillis();
//        System.out.println("-------ALGO2-----------------");
//        System.out.println("Start: " + start);
//        System.out.println("End: " + end);
//        System.out.println("Duration: " + (end - start + 1));
        return (end - start + 1);
    }

    class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public long algo3() {
        long start = System.currentTimeMillis();
        HashMap<Double, List<Pair>> hash = new HashMap<>();
        for (int c = 1; c <= N; c++) {
            for (int d = 1; d <= N; d++) {
                double res = cube(c) + cube(d);
                hash.putIfAbsent(res, new ArrayList<>());
                hash.get(res).add(new Pair(c, d));
            }
        }

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                double res = cube(a) + cube(b);
                List<Pair> pairs = hash.getOrDefault(res, new ArrayList<>());
                for (Pair p : pairs) {
                    System.out.println("a=" + a + ", b=" + b + ", c=" + p.a + ", d=" + p.b);
                }

            }
        }

        long end = System.currentTimeMillis();
//        System.out.println("-------ALGO2-----------------");
//        System.out.println("Start: " + start);
//        System.out.println("End: " + end);
//        System.out.println("Duration: " + (end - start + 1));
        return (end - start + 1);
    }

    public long algo4() {
        long start = System.currentTimeMillis();
        HashMap<Double, List<Pair>> hash = new HashMap<>();
        for (int c = 1; c <= N; c++) {
            for (int d = 1; d <= N; d++) {
                double res = cube(c) + cube(d);
                hash.putIfAbsent(res, new ArrayList<>());
                hash.get(res).add(new Pair(c, d));
            }
        }

        for (Map.Entry<Double, List<Pair>> e : hash.entrySet()) {
            for (Pair p1 : e.getValue()) {
                for (Pair p2 : e.getValue()) {
                    System.out.println("a=" + p1.a + ", b=" + p1.b + ", c=" + p2.a + ", d=" + p2.b);
                }
            }
        }

        long end = System.currentTimeMillis();
//        System.out.println("-------ALGO2-----------------");
//        System.out.println("Start: " + start);
//        System.out.println("End: " + end);
//        System.out.println("Duration: " + (end - start + 1));
        return (end - start + 1);
    }

    public static void main(String[] args) {
        MathApp app = new MathApp();
        long duration1 = algo1();
        long duration2 = algo2();
        long duration3 = app.algo3();
        long duration4 = app.algo4();
        System.out.println("Duration Algo1: " + duration1);
        System.out.println("Duration Algo2: " + duration2);
        System.out.println("Duration Algo3: " + duration3);
        System.out.println("Duration Algo4: " + duration4);
    }

    private static double cube(int n) {
        return Math.pow(n, 3);
    }
}

// 50 - 1670
// 100 - 27609 | 25516 | 28368