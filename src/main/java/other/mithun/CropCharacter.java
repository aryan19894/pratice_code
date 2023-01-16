package other.mithun;

public class CropCharacter {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int k = 19;
        String input = "Why Not Why Not Why Not Why Not";
        System.out.println(trimMessage(input, k));
    }

    public static String trimMessage(String input, int k) {
        if (input.length() <= k)
            return input;

        String[] words = input.split(" ");
        StringBuffer result = new StringBuffer();

        for (String word : words) {
            if (k >= word.length()) {
                result.append(word + " ");
                k -= word.length();
            }
        }

        return new String(result).trim();
    }


}
