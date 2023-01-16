package other.mithun;

public class Notification {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int k = 20;
        String input = "How are you";
        System.out.println(trimNotification(input, k));
    }

    public static String trimNotification(String input, int k) {
        if (input.length() <= k)
            return input;

        // subtracting -4 to k for " ..."
        k -= 4;
        String[] words = input.split(" ");
        StringBuffer result = new StringBuffer();

        for (String word : words) {
            if (k >= word.length()) {
                result.append(word + " ");
                k -= word.length()+1;
            } else break;
        }

        result = new StringBuffer(result.toString().trim());
        result.append(" ...");
        return new String(result).trim();
    }
}
