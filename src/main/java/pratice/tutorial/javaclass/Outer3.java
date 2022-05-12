package pratice.tutorial.javaclass;

import java.util.ArrayList;
import java.util.List;

public class Outer3 {
	public static long getMaximumScore(List<Integer> integerArray) {
	    // Write your code here
	        long score = 0;
	        int sum = integerArray.stream().mapToInt(Integer::intValue).sum();
	        int op = 1;
	        while(!integerArray.isEmpty()) {
	        	if(op%2 != 0) { //consider odd 1-indexed array 
	                score += sum;
	            } else {
	                score -= sum;
	             }
	            sum -= integerArray.get(integerArray.size()-1);
	            integerArray.remove(integerArray.size()-1);
	            op++;
	        }
	        
	        return score;
	    }

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
//		list.add(4);
//		list.add(2);
//		list.add(6);
		System.out.println(getMaximumScore(list));
	}

}
