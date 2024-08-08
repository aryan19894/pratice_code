package companyOA.Interview.microsoft.round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stack {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackImpl.push('a');
        StackImpl.push('b');
        StackImpl.push('a');
        StackImpl.push('b');
        StackImpl.push('c');
        StackImpl.push('a');

        System.out.println(StackImpl.pop());
        System.out.println(StackImpl.pop());
        System.out.println(StackImpl.pop());
        System.out.println(StackImpl.pop());
        System.out.println(StackImpl.pop());
        System.out.println(StackImpl.pop());

    }

}

class StackImpl {
    static HashMap<Character, Integer> map = new HashMap<>();
    static Map<Integer, List<Character>> map1 = new HashMap<>();
    static int maxFreq = Integer.MIN_VALUE;

    public static void push(char val) {
        map.putIfAbsent(val, 0);

        int newFreq = map.get(val) + 1;

        maxFreq = Math.max(maxFreq, newFreq);

        map.put(val, map.get(val) + 1);

        map1.putIfAbsent(newFreq, new ArrayList<Character>());
        ArrayList<Character> ref = (ArrayList<Character>) map1.get(newFreq);
        ref.add(ref.size() - 1, val);
        map1.put(newFreq, ref);

    }

    public static char pop() {

        char remove = map1.get(maxFreq).get(0);

        maxFreq--;

        return remove;
    }
}