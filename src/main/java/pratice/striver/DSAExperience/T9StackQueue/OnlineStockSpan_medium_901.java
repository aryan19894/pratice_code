package pratice.striver.DSAExperience.T9StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OnlineStockSpan_medium_901 {
    static class StockSpanner {
        Map<Integer, Integer> map;
        Stack<Integer> stock; // store the index
        int index = -1;

        public StockSpanner() {
            map = new HashMap<>();
            stock = new Stack<>();
            index = -1;
            stock.push(-1);
        }

        public int next(int price) {
            if (index != -1) stock.push(index);

            map.put(++index, price);

            if (stock.size() == 1) return index - stock.peek();
            while (stock.size() > 1 && map.get(stock.peek()) <= price)
                stock.pop();

            return index - stock.peek();
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
