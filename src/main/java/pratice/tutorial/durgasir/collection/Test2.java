package pratice.tutorial.durgasir.collection;

import java.util.*;
class Test2 {
	public static void main(String a[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("k1", 5);
		map.put("k2", 8);
		map.put("k1", 6);
		map.put(null, null);
		map.put(null, null);
		map.put(null, null);
		
		System.out.println(map);
	}
}