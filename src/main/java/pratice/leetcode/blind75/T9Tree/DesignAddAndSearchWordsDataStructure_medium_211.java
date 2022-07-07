package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;

import java.util.Collection;
import java.util.HashMap;

//class WordDictionary {
//    private final Map<Integer, List<String>> cache;
//
//    public WordDictionary() {
//        cache = new HashMap<>();
//    }
//
//    public void addWord(String word) {
//        cache.computeIfAbsent(word.length(), l -> new ArrayList<>()).add(word);
//    }
//
//    public boolean search(String word) {
//        List<String> dict = cache.getOrDefault(word.length(), new ArrayList<>());
//        if (dict == null || dict.size() == 0) return false;
//        for (String s : dict)
//            if (isMatch(word, s)) return true;
//
//        return false;
//    }
//
//    private boolean isMatch(String pattern, String word) {
//        if (pattern.equals(word)) return true;
//        for (int i = 0; i < pattern.length(); i++) {
//            char a = pattern.charAt(i);
//            if (a == '.') continue;
//
//            if (a != word.charAt(i)) return false;
//        }
//        return true;
//    }
//}

//class WordDictionary {
//    static class Node {
//        Node[] links;
//        boolean isWord;
//
//        public Node() {
//            this.links = new Node[26];
//            this.isWord = false;
//        }
//
//        public Node[] getLinks() {
//            return links;
//        }
//
//        public boolean contain(char ch) {
//            return links[ch - 'a'] != null;
//        }
//
//        public void put(char ch, Node newNode) {
//            links[ch - 'a'] = newNode;
//        }
//
//        public Node get(char ch) {
//            return links[ch - 'a'];
//        }
//
//        public boolean isWord() {
//            return this.isWord;
//        }
//
//        public void setWord() {
//            this.isWord = true;
//        }
//
//    }
//
//    private final Node root;
//
//    public WordDictionary() {
//        root = new Node();
//    }
//
//    public void addWord(String word) {
//        Node curr = root;
//        for (char ch : word.toCharArray()) {
//            if (!curr.contain(ch))
//                curr.put(ch, new Node());
//            curr = curr.get(ch);
//        }
//        curr.setWord();
//    }
//
//    public boolean search(String word) {
//        Node curr = root;
//        return search(curr, word, 0);
//    }
//
//    private boolean search(Node root, String word, int i) {
//        if (i == word.length()) return root.isWord();
//
//        char ch = word.charAt(i);
//        if (ch == '.') {
//            for (Node child : root.getLinks()) {
//                if (child != null && search(child, word, i + 1))
//                    return true;
//            }
//            return false;
//        } else {
//            if (root.contain(ch)) return search(root.get(ch), word, i + 1);
//            else return false;
//        }
//    }
//}

class WordDictionary {
    static class Node {
        HashMap<Character, Node> links;
        boolean isWord;

        public Node() {
            this.links = new HashMap<>();
            this.isWord = false;
        }

        public Collection<Node> getLinks() {
            return links.values();
        }

        public boolean contain(char ch) {
            return links.containsKey(ch);
        }

        public void put(char ch, Node newNode) {
            links.put(ch, newNode);
        }

        public Node get(char ch) {
            return links.get(ch);
        }

        public boolean isWord() {
            return this.isWord;
        }

        public void setWord() {
            this.isWord = true;
        }

    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contain(ch))
                curr.put(ch, new Node());
            curr = curr.get(ch);
        }
        curr.setWord();
    }

    public boolean search(String word) {
        Node curr = root;
        return search(curr, word, 0);
    }

    private boolean search(Node root, String word, int i) {
        if (i == word.length()) return root.isWord();

        char ch = word.charAt(i);
        if (ch == '.') {
            for (Node child : root.getLinks()) {
                if (child != null && search(child, word, i + 1))
                    return true;
            }
            return false;
        } else {
            if (root.contain(ch)) return search(root.get(ch), word, i + 1);
            else return false;
        }
    }
}

public class DesignAddAndSearchWordsDataStructure_medium_211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Out.print(wordDictionary.search("pad")); // return False
        Out.print(wordDictionary.search("bad")); // return True
        Out.print(wordDictionary.search(".ad")); // return True
        Out.print(wordDictionary.search("b..")); // return True
    }
}
