package companyOA.qualified;

class Challenge {
    static final int NO_CHARS = 256;
    static char[] count = new char[NO_CHARS];

    static void getCharCount(String str) {
        for (int i = 0; i < str.length(); i++)
            count[Character.toLowerCase(str.charAt(i))]++;
    }

    public static String firstNonRepeatingLetter(String str) {
        count = new char[NO_CHARS];
        getCharCount(str);
        int idx = -1, i;
        for (i = 0; i < str.length(); i++) {
            if (count[Character.toLowerCase(str.charAt(i))] == 1) {
                idx = i;
                break;
            }
        }
        return idx == -1 ? "" : str.charAt(idx) + "";
    }
}

public class FirstNonRepeatingLetter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Challenge.firstNonRepeatingLetter("stress"));
    }

}
