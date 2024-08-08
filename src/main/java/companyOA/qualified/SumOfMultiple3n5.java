package companyOA.qualified;

class Solution {

    static int sumAP(int n, int d) {
        n /= d;
        return n * (1 + n) * d / 2;
    }

    public static int solution(int n) {
        n--;
        return sumAP(n, 3) + sumAP(n, 5) - sumAP(n, 15);
    }
}

public class SumOfMultiple3n5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Solution.solution(49));
    }

}
