package pratice.tutorial.durgasir.collection.navigable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TreeSet t = new TreeSet();
		// t.add(2);
		// t.add(3);
		// t.add(4);
		// t.add(14);
		//
		// System.out.println(t.tailSet(3).first());
		// List l = new ArrayList();
		// l.add("z");
		// l.add("a");
		// l.add("k");
		// l.add("n");
		// // l.add(new Integer(10));
		//
		// System.out.println(l);
		// Collections.sort(l);
		// System.out.println(l);
		// Collections.sort(l, new Comp());
		// System.out.println(l);

		// Object o = new ArrayList<>();
		// Collections.toa
		// (new ArrayList(o)).toArray();

		Map<String, Object> map = new HashMap<>();
		String str = "EXP,PS,PSFC,PSP,PSPF,UNKNOWN";
		String[] t = str.split(",");
		// String[] ns = (String[])map.get("1");

		map.put("1", str.split(","));
		Object data = map.get("1");
		
		Class objType = data.getClass().getComponentType();
		
		if (objType.isArray()) {
			System.out.println(Arrays.toString((Object[]) data));
		} else if (objType.isPrimitive()) {

		} else {
			System.out.println(objType.getName());
		}
		// System.out.println(Arrays.toString(ns));
		// System.out.println(Arrays.toString((Object[])map.get("1")));
	}

}

class Comp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return o2.toString().compareTo(o1.toString());
	}

}
