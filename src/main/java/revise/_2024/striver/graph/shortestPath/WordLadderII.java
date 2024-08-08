package revise._2024.striver.graph.shortestPath;

import java.util.*;

public class WordLadderII {
    //0.87
    static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        boolean targetWordExist = Arrays.stream(wordList).anyMatch(n -> n.equals(targetWord));
        if (!targetWordExist || startWord == targetWord) return new ArrayList<>();

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(List.of(wordList));
        dict.remove(startWord);

        Queue<ArrayList<String>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(startWord)));

        ArrayList<String> levelWise = new ArrayList<>();
        levelWise.add(startWord);
        int level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> curr = q.poll();

            if (curr.size() > level) {
                level++;
                for (String ele : levelWise)
                    dict.remove(ele);
                levelWise = new ArrayList<>();
            }

            String word = curr.get(curr.size() - 1);
            if (word.equals(targetWord)) {
                if (result.isEmpty() || result.get(0).size() == curr.size())
                    result.add(new ArrayList<>(curr));
            }

            List<String> neighbour = calcDiffCount(dict, word);

            for (String neigh : neighbour) {
                curr.add(neigh);
                levelWise.add(neigh);
                q.add(new ArrayList<>(curr));
                curr.remove(neigh);
            }
        }

        return result;
    }

    //0.87
    static ArrayList<ArrayList<String>> findSequencesOptimized(String startWord, String targetWord, String[] wordList) {
        boolean targetWordExist = Arrays.stream(wordList).anyMatch(n -> n.equals(targetWord));
        if (!targetWordExist || startWord == targetWord) return new ArrayList<>();

        Set<String> dict = new HashSet<>(List.of(wordList));
        dict.remove(startWord);

        Map<String, Integer> map = new HashMap<>();
        map.put(startWord, 0);

        Queue<String> q = new LinkedList<>();
        q.add(startWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            for (String neigh : calcDiffCount(dict, word)) {
                dict.remove(neigh);
                q.add(neigh);
                map.putIfAbsent(neigh, map.get(word) + 1);
            }
        }

        //Reversing Map
        Map<Integer, List<String>> revMap = new HashMap<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            revMap.putIfAbsent(e.getValue(), new ArrayList<>());
            revMap.get(e.getValue()).add(e.getKey());
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if (map.containsKey(targetWord)) {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(targetWord);
            dfs(targetWord, startWord, subList, result, map, revMap);
        }

        return result;
    }

    private static void dfs(String word, String targetWord,
                            ArrayList<String> subList,
                            ArrayList<ArrayList<String>> result,
                            Map<String, Integer> map,
                            Map<Integer, List<String>> revMap) {
        if (word.equals(targetWord)) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (String neigh : revMap.get(map.get(word) - 1)) {
            subList.add(neigh);
            dfs(neigh, targetWord, subList, result, map, revMap);
            subList.remove(neigh);
        }
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
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der";
        String targetWord = "dfs";

        System.out.println(findSequences(startWord, targetWord, wordList));
        System.out.println(findSequencesOptimized(startWord, targetWord, wordList));
    }
}
