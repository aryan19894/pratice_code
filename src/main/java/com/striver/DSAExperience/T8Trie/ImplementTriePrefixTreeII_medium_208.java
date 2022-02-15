package com.striver.DSAExperience.T8Trie;

public class ImplementTriePrefixTreeII_medium_208 {
    static class Trie {
        static class Node {
            Node[] links = new Node[26];
            public int endsWith = 0;
            public int countPrefix =0;

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public Node get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, Node node) {
                links[ch - 'a'] = node;
            }

            void increaseEnd() {
                endsWith++;
            }
            void increasePrefix() {
                countPrefix++;
            }
            void deleteEnd() {
                endsWith--;
            }
            void reducePrefix() {
                countPrefix--;
            }
            int getEnd() {
                return endsWith;
            }
            int getPrefix() {
                return countPrefix;
            }
        }

        private static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(!node.containsKey(ch))
                    node.put(ch, new Node());
                node = node.get(ch);
                node.increasePrefix();
            }
            node.increaseEnd();
        }

        public int countWordsEqualTo(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch))
                    return 0;
                node = node.get(ch);
            }
            return node.getEnd();
        }

        public int countWordsStartingWith(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch))
                    return 0;
                node = node.get(ch);
            }
            return node.getPrefix();
        }

        public void erase(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    node.reducePrefix();
                } else return;
            }
            node.deleteEnd();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("coding");
        trie.insert("ninja");
        System.out.println(trie.countWordsEqualTo("coding"));   // return True
        System.out.println(trie.countWordsStartingWith("nin"));   // return False
        trie.erase("coding");
        System.out.println(trie.countWordsEqualTo("coding"));   // return True
    }
}
