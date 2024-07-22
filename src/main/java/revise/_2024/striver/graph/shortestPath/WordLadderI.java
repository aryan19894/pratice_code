package revise._2024.striver.graph.shortestPath;

import java.util.*;

public class WordLadderI {
    static class Pair {
        String word;
        int steps;

        public Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    //0.41
    static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        boolean targetWordExist = Arrays.stream(wordList).anyMatch(n -> n.equals(targetWord));
        if (!targetWordExist || startWord == targetWord) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> dict = new HashSet<>(List.of(wordList));
        dict.remove(startWord);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.word.equals(targetWord)) return curr.steps;
            for (String child : calcDiffCount(dict, curr.word)) {
                dict.remove(child);
                q.offer(new Pair(child, curr.steps + 1));
            }
        }
        return 0;
    }

    private static List<String> calcDiffCount(Set<String> dict, String word) {
        Map<String, Integer> map = new HashMap<>();
        for (String ele : dict) {
            map.put(ele, 0);
            if (ele.equals(word)) continue;

            String str1 = word;
            String str2 = ele;
            int minLength = Integer.min(str1.length(), str1.length());
            for (int j = 0; j < minLength; j++) {
                if (str1.charAt(j) != str2.charAt(j)) map.put(ele, map.get(ele) + 1);
            }
        }

        List<String> count1 = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1)
                count1.add(e.getKey());
        }

        return count1;
    }

    public static void main(String[] args) {
        String[] wordList = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
        String startWord = "toon";
        String targetWord = "plea";

        System.out.println(wordLadderLengthBruteForce(startWord, targetWord, wordList));
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }

    //0.38
    private static int wordLadderLengthBruteForce(String startWord, String targetWord, String[] wordList) {
        boolean targetWordExist = Arrays.stream(wordList).anyMatch(n -> n.equals(targetWord));
        if (!targetWordExist || startWord == targetWord) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> dict = new HashSet<>(List.of(wordList));
        dict.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();
            if (word.equals(targetWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (dict.contains(replacedWord)) {
                        dict.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
