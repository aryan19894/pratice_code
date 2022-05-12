package pratice.tutorial.ravindraravula.l8;

import pratice.common.Obj;
import pratice.common.Out;

public class MergeSort {

	public static void main(String[] args) {
		//int a[] = { 3, 4, 6, 8, 9, 7, 2, 5, 1 };
		 int a[] = {9,6,3,5};
		System.out.println("Before Sorting: ");
		Out.print(a);
		// a = insertionSortMyself(a);
		mergeSortMyself(a, 0, a.length-1);
		System.out.println("After Sorting: ");
        Out.print(a);
	}

	private static void mergeSortMyself(int[] a, int l, int r) {
		if(l<r) {
			int m = (l+r)/2; 
			mergeSortMyself(a, l, m);
			mergeSortMyself(a, m+1, r);
			
			merge(a, l, m, r); 
		}
	}

	//conquer
	private static void merge(int[] arr, int l, int m, int r) {
 		int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j];
        
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        }
        
	}
}
