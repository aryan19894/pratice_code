package pratice.tutorial.naveensir.Lec1Introduction;

public class PrefixAverage2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[] = {3,4,6,8,9,7,2,5,1};
		int a[] = {2,4,9,6,3,5};
		System.out.println("Before: \n");
		printArray(a);
		//a = insertionSortMyself(a);
		a = prefixAverage(a);
		System.out.println("After: \n");
		printArray(a);
	}

	private static int[] prefixAverage(int[] a) {
		int x[] = new int[a.length];
		int avg = 0;
		for(int i=0;i<a.length;i++) {
			avg += a[i];
			x[i] = avg/(i+1);
		}
		return x;
	}


	private static void printArray(int[] a) {
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

}
