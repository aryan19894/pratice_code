package com.striver.DSAExperience.T9StackQueue;/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node ref = map.get(key);
            remove(ref);
            insert(ref);
            return ref.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }


}
// @lc code=start
class Node {
    int key, value;
    Node prev, next;

    Node(int _key, int _value) {
        key = _key;
        value = _value;
    }
}
public class LRUCache_medium_146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

