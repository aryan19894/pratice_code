package companyOA.Interview.intraLink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// custom DS -> perform below operation in O(1) time.

// 1. add 7 -> add onto DS
// 2. remove -> remove added number
// 3. search added number 
// 4. get any random number from DS - each time will return differnent number

class CustomDSOperation {
    List<Integer> n = new ArrayList<>(); // will store element 
    // keep track of index of element 
    // which is stored in list
    Map<Integer, Integer> map = new HashMap<>(); 
    //keep tracking of visitor
    //boolean[] generated = new boolean[n.length];

    public static void main(String[] args) {

    }

    private void insert(int x) {
        n.add(x);
        map.put(x, n.indexOf(x));
    }

    private boolean remove(int x) {
        if(map.get(x) == null) 
            return false;
        else {
            
            map.remove(x);
            n.remove(x);

            return true;
        }
    }

    private int search(int x) {
        if(map.get(x) == null) 
            return -1;
        else {
            return n.get(map.get(x));
        }
    }

//    private int getRandom(int x) {
//        if(!map.get(x)) 
//            return false;
//        else {
//            return n.get(map.get(x));
//        }
//    }
}