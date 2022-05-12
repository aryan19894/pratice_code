package other.common;

import java.util.Map;

public class Common {
	@SuppressWarnings("unused")
	public static void updateMap(Map<Object, Object> number, Object key, Object in) {
		// TODO Auto-generated method stub
		number.putIfAbsent(key, 0);
		number.put(key, toInteger(number.get(key))+toInteger(in));
	}
	static int toInteger(Object o) {
		return Integer.valueOf((String) o);
	}
	public static void printArray(int[] a, int intialIndex) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------");
		for(int i=intialIndex;i<a.length;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i=intialIndex;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(int[] a) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------");
		for(int i=0;i<a.length;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int aa: a) {
			System.out.print(aa + " ");
		}
		System.out.println();
	}
	
	public static void printArray(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				System.out.print("("+i+","+j+")="+a[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
