package pratice.common.converter;

import java.util.ArrayList;

public class Str {
    public static ArrayList<ArrayList<Integer>> toAdjList(int V, String args) {
        ArrayList<ArrayList<Integer>> ref = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++) {
            ref.add(i, new ArrayList<>());
        }

        String[] arg = args.split("\\|");
        for (String a : arg) {
            String[] index = a.split(":");
            int idx = Integer.parseInt(index[0].trim());
            String[] nums = index[1].trim().split(",");
            for (String n : nums){
                int num = Integer.parseInt(n.trim());
                ref.get(idx).add(num);
            }
        }

        return ref;
    }

    public static Integer[] toArray(String str) {
        if (str == null || str.length() == 0) return null;

        String[] ip = str.split(" ");
        if (ip.length == 0)
            ip = str.split(",");

        return Array.toInteger(ip);
    }
}
