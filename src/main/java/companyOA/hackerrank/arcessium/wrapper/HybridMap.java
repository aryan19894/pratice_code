package companyOA.hackerrank.arcessium.wrapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HybridMap extends LinkedHashMap<String, Map<String, Integer>> {
    public void put(String key, Object subKey, int val) {
        this.putIfAbsent(key, new HashMap());
        if (subKey != null) {
            ((Map) this.get(key)).put(subKey.toString(), val);
        }

    }
}
