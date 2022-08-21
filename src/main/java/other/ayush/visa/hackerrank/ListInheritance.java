package other.ayush.visa.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class InvalidStringException extends Exception {
    public InvalidStringException(String message) {
        super(message);
    }
}

interface MyList {
    void convert(String[] a);

    void replace(int idx);

    ArrayList<String> compact();
}

class ArrayToList implements MyList {
    ArrayList<String> arrayToList;

    ArrayToList() {
        arrayToList = new ArrayList<>();
    }

    @Override
    public void convert(String[] a) {
        int i = 0;
        for (String d : a) {
            System.out.println("I have added the string: " + d + " at the index: " + i);
            this.arrayToList.add(i++, d);
        }
    }

    @Override
    public void replace(int idx) {
        String data = this.arrayToList.get(idx);
        this.arrayToList.set(idx, "");
        System.out.println("I have replaced the string: " + data + "with a null string");
    }


    @Override
    public ArrayList<String> compact() {
        ArrayList<String> ref = new ArrayList<>(this.arrayToList);
        ref.removeAll(Arrays.asList("", null));
        return ref;
    }
}

public class ListInheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random(0);

        int n = Integer.parseInt(sc.nextLine());
        String[] a = new String[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextLine();

        MyList obj = new ArrayToList();

        obj.convert(a);
        int x = rand.nextInt(n);
        for (int i = 0; i < x; i++)
            obj.replace(rand.nextInt(n));


        ArrayList<String> s = obj.compact();


        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122) {
                try {
                    throw new InvalidStringException("This is an invalid string");
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


    }
}
