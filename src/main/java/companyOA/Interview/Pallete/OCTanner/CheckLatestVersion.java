package companyOA.Interview.Pallete.OCTanner;

import java.util.Scanner;

public class CheckLatestVersion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Find out the latest version of the product
        // �2.3.5� �4.5.6� � Ans: - 4.5.6
        // �1.2.2.0� �1.2.1.0.5� � Ans: 1.2.2.0

        Scanner sc = new Scanner(System.in);
        String v1 = sc.nextLine();
        String v2 = sc.nextLine();

        char[] chv1 = v1.replace(".", "").toCharArray();
        char[] chv2 = v2.replace(".", "").toCharArray();

        int n = chv1.length < chv2.length ? chv1.length : chv2.length;
        int i = 0;
        for (i = 0; i < n; i++) {
            if (chv1[i] > chv2[i]) {
                System.out.println(v1);
                break;
            } else if (chv1[i] < chv2[i]) {
                System.out.println(v2);
                break;
            }
        }

        if (i == n) {
            System.out.println(chv1.length > chv2.length ? v1 : v2);
        }
    }

}
