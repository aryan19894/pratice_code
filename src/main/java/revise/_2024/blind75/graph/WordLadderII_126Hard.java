package revise._2024.blind75.graph;

import java.util.*;

public class WordLadderII_126Hard {
    static List<List<String>> result;
    static Map<String, Integer> map;

    static public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord == endWord) return new ArrayList<>();

        result = new ArrayList<>();
        map = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        map.put(beginWord, 1);

        while (!q.isEmpty()) {
            String word = q.poll();
            if (word.equals(endWord)) break;

            for(String next: dict){
                if(isLadder(word, next)){

                }
            }
            for (String neigh : getPossibleLadder(dict, word)) {
                dict.remove(neigh);
                q.offer(neigh);
                map.put(neigh, map.get(word) + 1);
            }
        }

        if (map.containsKey(endWord)) {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(endWord);
            dfs(endWord, beginWord, subList);
        }

        return result;
    }

    private static void dfs(String word, String endWord, ArrayList<String> subList) {
        if (word.equals(endWord)) {
            List<String> dup = new ArrayList<>(subList);
            Collections.reverse(dup);
            result.add(dup);
            return;
        }

        for (String neigh : map.keySet()) {
            if (map.get(neigh) + 1 == map.get(word)) {
                if (!isLadder(word, neigh)) continue;
                subList.add(neigh);
                dfs(neigh, endWord, subList);
                subList.remove(neigh);
            }
        }
    }

    private static List<String> getPossibleLadder(Set<String> dict, String word) {
        List<String> count1 = new ArrayList<>();
        for (String ele : dict) {
            if (ele.equals(word)) continue;

            if (isLadder(word, ele))
                count1.add(ele);
        }

        return count1;
    }

    private static boolean isLadder(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int diff = 0;
        int minLength = Integer.min(str1.length(), str1.length());

        for (int j = 0; j < minLength; j++) {
            if (str1.charAt(j) != str2.charAt(j)) diff++;
            if (diff > 1) return false;
        }

        return diff == 1;
    }


    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit", endWord = "cog";

        System.out.println(findLadders(beginWord, endWord, List.of(wordList)));
    }
}
