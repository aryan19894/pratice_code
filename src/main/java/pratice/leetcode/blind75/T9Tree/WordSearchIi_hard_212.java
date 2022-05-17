package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;

import java.util.*;


public class WordSearchIi_hard_212 {
    static class TrieNode {
        HashMap<Character, TrieNode> links;
        boolean isWord;
        String word;

        public TrieNode() {
            this.links = new HashMap<>();
            this.isWord = false;
            this.word = null;
        }

        public boolean contain(char ch) {
            return links.containsKey(ch);
        }

        public void put(char ch, TrieNode newNode) {
            links.put(ch, newNode);
        }

        public TrieNode get(char ch) {
            return links.get(ch);
        }

        public void wordEnd(String word) {
            this.word = word;
            this.isWord = true;
        }

        public String getWord() {
            return word;
        }
    }

    TrieNode root = new TrieNode();
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private Set<String> availableWords;
    private int n, m;
    private int maxWordSize = 0;

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contain(ch))
                curr.put(ch, new TrieNode());
            curr = curr.get(ch);
        }
        curr.wordEnd(word);
    }

    public List<String> findWords(char[][] board, String[] words) {
        availableWords = new HashSet<>();
        for (String word : words) {
            addWord(word);
            maxWordSize = Math.max(maxWordSize, word.length());
        }

        this.n = board.length;
        this.m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i][j];
                if (root.contain(ch)) find(board, i, j, root.get(ch), 1);
            }
        }
        return new ArrayList<>(availableWords);
    }

    private void find(char[][] board, int i, int j, TrieNode parent, int currentSteps) {
        if (currentSteps > maxWordSize) return;
        if (parent.isWord) {
            availableWords.add(parent.word);
            parent.isWord = false;
        }

        char ch = board[i][j];
        board[i][j] = '#';

        for (int[] dir : directions) {
            int r = i + dir[0], c = j + dir[1];

            if (r < 0 || r >= n) continue;
            if (c < 0 || c >= m) continue;

            char nextCh = board[r][c];
            if (nextCh == '#') continue;
            if (!parent.contain(nextCh)) continue;

            find(board, r, c, parent.get(nextCh), currentSteps + 1);
        }

        board[i][j] = ch;
    }


    public static void main(String[] args) {
        WordSearchIi_hard_212 sol = new WordSearchIi_hard_212();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        Out.print(sol.findWords(board, words));
    }
}
