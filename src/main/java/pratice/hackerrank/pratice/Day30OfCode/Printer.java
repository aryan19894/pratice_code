package pratice.hackerrank.pratice.Day30OfCode;

public class Printer<T> {
    public void printArray(T[] arr) {
        Object[] var2 = arr;
        int var3 = arr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            T obj = (T)var2[var4];
            System.out.println(obj);
        }

    }
}
