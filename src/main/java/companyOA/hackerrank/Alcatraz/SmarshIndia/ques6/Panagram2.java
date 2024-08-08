package companyOA.hackerrank.Alcatraz.SmarshIndia.ques6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result1 {

    /*
     * Complete the 'isPangram' function below.
     *
     * The function is expected to return a STRING. The function accepts
     * STRING_ARRAY pangram as parameter.
     */

    public static String isPangram(List<String> pangram) {
        // Write your code here
        String res = "";
        int flag = 0;

        for (String str : pangram) {
            for (char c : str.toLowerCase().toCharArray()) {
                if (c >= 'a' && c <= 'z')
                    flag |= 0x01 << (c - 'a');
            }
            if (flag >= 0x3ffffff)
                res += "1";
            else
                res += "0";
        }
        return res;
    }

}

public class Panagram2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<String> track = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            track.add(s);
        }
        System.out.println(Result1.isPangram(track));
    }

}
