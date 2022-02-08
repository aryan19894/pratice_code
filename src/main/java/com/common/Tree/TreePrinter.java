package com.common.Tree;

import java.util.LinkedList;
import java.util.Queue;

public interface TreePrinter<T> {
    public void printRoot(T node);
    public void print(T node);
//    private T obj;
//    private T ref;
//    //public TreePrinter(){}
//
//    public TreePrinter(T ref) {
//        this.ref = ref;
//    }
//
//    public T get() {
//        return (T)this.obj;
//    }
//
//    public void set(T t) {
//        this.obj = t;
//    }
//
//    public void printRoot(T node) {
//        System.out.println(node);
//    }
//
//
//    void print() throws InstantiationException, IllegalAccessException {
//        Queue<T> q = new LinkedList<>();
//        q.offer(this.get().get);
//        while (!q.isEmpty()) {
//            int levelNum = q.size();
//            for (int i = 0; i < levelNum; i++) {
//                T ref = q.poll();
//                ref.newInstance();
//                T data = (T) this.ref.getClass().newInstance();
//                data.get
//                if (ref != null) {
//                    ref.
//                            q.offer(ref.left);
//                    q.offer(ref.right);
//                    System.out.print(ref.val + " ");
//                } else
//                    System.out.print("null ");
//            }
//            System.out.println();
//        }
//    }

    ; //Print full tree level order
//    void printGUI(T node); // Print tree structure
}
