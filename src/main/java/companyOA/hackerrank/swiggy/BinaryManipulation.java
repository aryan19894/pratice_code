package companyOA.hackerrank.swiggy;

import java.io.*;

import static java.util.stream.Collectors.joining;


class ResultBinaryManipulation {

    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long minOperations(long n) {
    // Write your code here
        int bit = n < 0 ? 1 : 0;
        long res = (long)bit;
        for(int i=0;i<63;i++) {
            n = n << 1;
            int sign = n < 0 ? 1 : 0;
            bit = (bit+sign)%2;
            res = (res << 1) + bit;
        }
        return res;
    }

}
public class BinaryManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = ResultBinaryManipulation.minOperations(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
