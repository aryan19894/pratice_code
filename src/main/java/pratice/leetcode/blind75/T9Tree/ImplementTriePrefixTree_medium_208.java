package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;

class Trie {
    static class TrieNode {
        TrieNode[] links;
        boolean isWord;

        public TrieNode() {
            links = new TrieNode[26];
            isWord = false;
        }

        public boolean contain(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode newNode) {
            links[ch - 'a'] = newNode;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            this.isWord = true;
        }

        public boolean isWord() {
            return this.isWord;
        }
    }

    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contain(ch))
                curr.put(ch, new TrieNode());
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        return search(word, false);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }

    private boolean search(String word, boolean isPrefixSearch) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contain(ch)) return false;
            curr = curr.get(ch);
        }
        return isPrefixSearch ? true : curr.isWord();
    }

}

public class ImplementTriePrefixTree_medium_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        Out.print(trie.search("apple"));   // return True
        Out.print(trie.search("app"));     // return False
        Out.print(trie.startsWith("app")); // return True
        trie.insert("app");
        Out.print(trie.search("app"));     // return True
    }
}
