package companyOA.Interview.Ness;

public class CurrencyWIthdrawal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int withdraw = 5900;
        int[] availCurrency = {2000, 500, 100};
        int[] noOfNotes = new int[availCurrency.length];

        int i = 0;
        while (withdraw > 0) {
            noOfNotes[i] = withdraw / availCurrency[i];
            withdraw %= availCurrency[i++];
        }

        for (i = 0; i < 3; i++) {
            System.out.println(noOfNotes[i]);
        }
    }

}
