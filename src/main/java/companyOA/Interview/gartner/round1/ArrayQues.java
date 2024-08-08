package companyOA.Interview.gartner.round1;

public class ArrayQues {

    public static void main(String[] args) {
        int[] a = {2, 8, 10, 5, 5};

        System.out.println(findEle(a, a.length));
    }

    private static int findEle(int[] a, int n) {
        int[] pre = new int[n]; //{2, 10, 20, 25, 30}

        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + a[i];
        }

        int[] suf = new int[n]; // {30,28,20,10,5}

        suf[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + a[i];
        }

        for (int i = 1; i < n - 1; i++) {
            if (pre[i] == suf[i])
                return a[i];
        }
        return -1;
    }
}



