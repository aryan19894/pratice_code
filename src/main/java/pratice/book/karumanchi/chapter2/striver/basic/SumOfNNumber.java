package pratice.book.karumanchi.chapter2.striver.basic;

public class SumOfNNumber {
    public static void main(String[] args) {
        sum(3, 0);
        System.out.println(sum(3));
    }

    private static void sum(int i, int sum) {
        if (i == 0) {
            System.out.println(sum);
            return;
        }

        sum(i - 1, sum + i);
    }

    private static int sum(int i) {
        if (i == 1) return i;

        return i + sum(i - 1);
    }
}
