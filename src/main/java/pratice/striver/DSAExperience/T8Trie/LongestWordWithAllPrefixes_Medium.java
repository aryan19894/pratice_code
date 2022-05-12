package pratice.striver.DSAExperience.T8Trie;

import pratice.striver.DSAExperience.T8Trie.common.Node;

public class LongestWordWithAllPrefixes_Medium {
    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        // [Optimal] TC: O(n)*O(len) - n array elements and its length
        // SC: quick tricky - generally we cant predict the perfect space because
        // there could be root storing all 26 characters and then its children is also storing 26 characters
        // Roughly we can say: O(26pow(N))
        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch))
                    node.put(ch, new Node());
                node = node.get(ch);
            }
            node.setEnd();
        }

        // [Optimal] TC: O(n*len) - check if that word all prefix is available or not
        boolean checkIfAllPrefixExists(String word) {
            Node node = root;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch))
                    return false;
                node = node.get(ch);
                flag = flag & node.isEnd();
            }
            return flag;
        }
    }

    // [Optimal] TC: O(n)*O(len) + O(n*len) - insert and check its prefix
    public static String completeString(int n, String[] words) {
        Trie t = new Trie();
        for (String word : words)
            t.insert(word);

        String longest = "";
        for (String word : words) {
            if (word.length() >= longest.length() &&
                    t.checkIfAllPrefixExists(word)) {
                if (longest.length() < word.length())
                    longest = word;
                else if (longest.length() == word.length() &&
                        word.compareTo(longest) < 0)
                    longest = word;
            }
        }
        return longest == "" ? "None" : longest;
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"n", "ni", "nin", "ninj", "ninja", "ninga"};
        System.out.println(completeString(4, dict));
    }
}
