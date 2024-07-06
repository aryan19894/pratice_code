package pratice.book.karumanchi.chapter2.striver.basic;

public class PrintName {
    public static void print(String str) {
        print(str, 5);
    }

    private static void print(String str, int i) {
        if (i == 0) return;
        System.out.println(str);
        print(str, i - 1);
    }

    public static void main(String[] args) {
        print("Aryan");
    }
}
