package pratice.gfg.companywise.google;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        int key, value;
        Node prev, next;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> hash = new HashMap<>();
    int capacity;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    //Function to return value corresponding to the key.
    public int get(int key) {
        if (hash.containsKey(key)) {
            Node curr = hash.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        } else return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value) {
        if (hash.containsKey(key))
            remove(hash.get(key));
        if (capacity == hash.size())
            remove(tail.prev);
        insert(new Node(key, value));
    }

    private void insert(Node newNode) {
        hash.put(newNode.key, newNode);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
    }

    private void remove(Node node) {
        hash.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        String test = "GET 100 GET 26 GET 91 SET 55 40 GET 70 GET 43 GET 98 SET 5 56 GET 12 GET 29 SET 47 44 GET 41 GET" +
                " 12 GET 6 SET 31 62 GET 6 GET 37 GET 27 GET 66 GET 17 GET 59 GET 38 GET 25 GET 37 GET 100 SET 69 51 " +
                "SET 32 74 SET 34 31 GET 61 SET 82 100 SET 60 97 SET 69 14 GET 96 GET 67 GET 41 GET 85 GET 43 GET 8 " +
                "SET 80 57 GET 88 GET 49 GET 60 SET 11 37 GET 88 GET 2 SET 22 73 SET 100 20 SET 40 5 SET 68 41 SET 28 " +
                "29 GET 85 GET 21 GET 23 SET 82 97 GET 85 GET 73 GET 51 SET 23 86 SET 43 41 GET 14 GET 91 GET 91 SET 20" +
                " 82 GET 33 SET 5 95 SET 74 70 GET 51 SET 43 61 SET 94 85 SET 68 22 GET 14 SET 27 55 SET 3 45 GET 7 GET " +
                "22 GET 69 GET 90 GET 9 GET 99 GET 9 SET 4 49 SET 49 34 GET 55 SET 69 47";

        String[] token = test.split(" ");
        int i = 0;
        while (i < token.length) {
            if (token[i].equals("GET"))
                System.out.println(cache.get(Integer.parseInt(token[++i])));
            else if (token[i].equals("SET"))
                cache.set(Integer.parseInt(token[++i]), Integer.parseInt(token[++i]));
            i++;
        }

//        cache.set(1,1);
//        cache.set(2,2);
//        System.out.println(cache.get(1));
//        cache.set(3,3);
//        System.out.println(cache.get(2));
//        cache.set(4,4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
