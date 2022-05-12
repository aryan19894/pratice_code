package pratice.tutorial.naveensir.Lec1Introduction;

import other.common.Common;

public class InsertionSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,4,6,8,9,7,2,5,1};
		//int a[] = {2,4,9,6,3,5};
		System.out.println("Before Sorting: \n");
		Common.printArray(a);
		//a = insertionSortMyself(a);
		a = insertionSortTutorial(a);
		System.out.println("After Sorting: \n");
		Common.printArray(a);
	}

	private static int[] insertionSortTutorial(int[] a) {
		for(int i=1;i<a.length;i++) {
			System.out.println("i="+i);
			System.out.println("a["+(i-1)+"]="+a[i-1]);
			System.out.println("a["+i+"]="+a[i]);
			if(a[i-1]>a[i]) {
				System.out.println("Change");
				int ref = a[i];
				System.out.println("ref="+ref);
				int j = i-1;
				while(j>=0 && a[j] > ref) {
					a[j+1] = a[j];
					j--;
				}
				a[j+1] = ref;
			} else {
				System.out.println("No Change");
			}
			Common.printArray(a);
		}
		return a;
	}

	private static int[] insertionSortMyself(int[] a) {
		for(int i=1;i<a.length;i++) {
			System.out.println("i="+i);
			System.out.println("a["+(i-1)+"]="+a[i-1]);
			System.out.println("a["+i+"]="+a[i]);
			if(a[i-1]>a[i]) {
				System.out.println("Change");
				int ref = a[i];
				System.out.println("ref="+ref);
				int j = i-1;
				while(j>=0) {
					if(a[j] < ref) {
						a[j+1] = ref;
						break;
					} else {
						a[j+1] = a[j];
					}
					j--;
				}
				if(j<0)
					a[0] = ref;
			} else {
				System.out.println("No Change");
			}
			Common.printArray(a);
		}
		return a;
	}



}
