package companyOA.hackerearth.UIPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySorting {

	public static void main(String[] args) {

		int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> outputArray = new ArrayList<>();

		for (int current : array) {
			map.putIfAbsent(current, 0);
			map.put(current, map.get(current) + 1);
			outputArray.add(current);
		}

		SortComparator comp = new SortComparator(map);

		Collections.sort(outputArray, comp);

		for (Integer i : outputArray) {
			System.out.print(i + " ");
		}
	}

}

class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;

	public SortComparator(Map<Integer, Integer> freqMap) {
		this.freqMap = freqMap;
	}

	@Override
	public int compare(Integer k1, Integer k2) {
		int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));
		int valueCompare = k1.compareTo(k2);

		if (freqCompare == 0)
			return valueCompare;
		else
			return freqCompare;

	}

}