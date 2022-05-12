package companyOA.hackerrank.swiggy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaximizingRevenue {
	public static long maximiseRevenue(List<Long> p, List<Long> d, List<Integer> t) {
	    // Write your code here
	        Long[] pickup = t.stream().toArray(Long[]::new);
	        Long[] drop = t.stream().toArray(Long[]::new);
	        Integer[] tip = t.stream().toArray(Integer[]::new);
	        
	        int len = pickup.length;
	        long[][] schedule = new long[len][3];
	        for (int i = 0; i < len; i++) 
	            schedule[i] = new long[] { pickup[i], drop[i], tip[i] };
	        Arrays.sort(schedule, (j1, j2) -> Long.compare(j1[0], j2[0]));
	        
	        TreeMap<Long, Long> cache = new TreeMap<>();
	        cache.put(schedule[0][1], (long) schedule[0][1] -  schedule[0][0] +  schedule[0][2]);
	        long prev = schedule[0][1] -  schedule[0][0] +  schedule[0][2];

	        for (int i = 1; i < schedule.length; i++) {
	            long curEarn = schedule[i][1] -  schedule[i][0] +  schedule[i][2];
	            Map.Entry<Long, Long> lower = cache.floorEntry(schedule[i][0]);
	            if (lower != null)
	                curEarn += lower.getValue();
	            curEarn = Math.max(curEarn, prev);
	            cache.put(schedule[i][1], curEarn);
	            prev = curEarn;
	        }
	        return prev;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
