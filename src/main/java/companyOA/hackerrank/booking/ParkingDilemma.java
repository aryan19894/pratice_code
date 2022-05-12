package companyOA.hackerrank.booking;

import java.util.Collections;
import java.util.List;

public class ParkingDilemma {
    public static long carParkingRoof(List<Long> cars, int k) {
        // Write your code here
        if(cars.size() == 0 || k < 0) return 0;

        Collections.sort(cars);
        int start = 0;
        long minSlot = Long.MAX_VALUE;
        for(int i=0;i<cars.size();i++){
            if(i < k-1) continue;
            long currLen = cars.get(i) - cars.get(start++) + 1;
            minSlot=Math.min(minSlot, currLen);
        }

        return minSlot;
    }
}
