package pratice.striver.DSAExperience.T8Trie;

import pratice.striver.DSAExperience.T8Trie.common.Node;

public class NumberOfDistinctSubstring_Medium {
    // [Basic] TC: O(n2*logM) - N2 for 2loops and logM is for no of elements in set
    // SC: in worst case, O(n3)
    // check each and every substring and count

    // [Better: Trie] TC: O(n2) - because we have to go through the entire string for all possible different
    // starting points in order to generate all the substrings.
    // SC: O(n2) - In the worst case, all the substrings can be distinct and there will be a node for every  substring.
    // Number of substrings of a string of length n is (n * (n + 1) / 2).
    public static int distinctSubstring(String word) {
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Node node = root;
            for (int j = i; j < word.length(); j++) {
                if (!node.containsKey(word.charAt(j))) {
                    count++;
                    node.put(word.charAt(j), new Node());
                }
                node = node.get(word.charAt(j));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(distinctSubstring("abab"));
    }
}
