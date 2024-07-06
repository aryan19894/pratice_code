package pratice.book.karumanchi.chapter2.striver.basic;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    private static int factorial(int i) {
        if (i == 1) return i;

        return i * factorial(i - 1);
    }
}
