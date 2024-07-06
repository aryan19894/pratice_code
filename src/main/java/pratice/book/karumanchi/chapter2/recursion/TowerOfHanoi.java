package pratice.book.karumanchi.chapter2.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        toh(3, 'A', 'C', 'B');
    }

    private static void toh(int i, char from, char to, char aux) {
        if (i == 0) return;

        toh(i - 1, from, aux, to);
        System.out.println("Move disk " + i + " rod [" + from + " - " + to + "]");
        toh(i - 1, aux, to, from);
    }
}
