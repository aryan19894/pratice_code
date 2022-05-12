package companyOA.hackerrank.booking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaximumOccuringCharacter {
    public static char maximumOccurringCharacter(String text) {
        // Write your code here
        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxCount = -1;
        for(char ch: text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxCount = Math.max(maxCount, map.get(ch));
        }

        Map<Integer, List<Character>> mapFreq = new LinkedHashMap<>();
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            mapFreq.putIfAbsent(e.getValue(), new ArrayList<>());
            mapFreq.get(e.getValue()).add(e.getKey());
        }

        return mapFreq.get(maxCount).get(0);

        // int[] count = new int[256];
        // char result = ' ';
        // int maxCount = -1;
        // for(char ch: text.toCharArray()) {
        //     count[ch]++;

        //     if(maxCount < count[ch]) {
        //         result = ch;
        //         maxCount = count[ch];
        //     }
        // }
        // return result;
    }
}
