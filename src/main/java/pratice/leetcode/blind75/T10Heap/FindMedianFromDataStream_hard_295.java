package pratice.leetcode.blind75.T10Heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> lowers; // stores all larger nums // minHeap
    PriorityQueue<Integer> highers; // stores all smaller nums //maxHeap

    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lowers.offer(num);
        highers.offer(lowers.poll());
        if (lowers.size() < highers.size()) lowers.add(highers.poll());
    }

    public double findMedian() {
        return lowers.size() > highers.size() ? lowers.peek() : (lowers.peek() + highers.peek()) / 2.0;
    }
}

public class FindMedianFromDataStream_hard_295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
    }
}
