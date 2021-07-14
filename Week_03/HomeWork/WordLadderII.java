// class Solution {
//     private Map<String, Set<String>> graph;
//     private List<List<String>> result;
//     private Map<String, Integer> distance;
    
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         distance = new HashMap<>();
//         graph = buildGraph(beginWord, wordList);
//         result = new ArrayList<>();
//         dfs(beginWord, endWord,  new ArrayList<>());
//         return result;
//     }
    
//     private void dfs(String word, String target, List<String> solution) {
//         solution.add(word);
//         if (target.equals(word)) {
//             result.add(solution);
//         } else {
//             for (String child : graph.get(word)) {
//                 if (distance.get(word) + 1 == distance.getOrDefault(child, Integer.MAX_VALUE)) { 
//                     dfs(child, target, new ArrayList<>(solution));
//                 }
//             }
//         }
//     }
    
//     private Map<String, Set<String>> buildGraph(String beginWord, List<String> wordList) {
//         Map<String, Set<String>> map = new HashMap<>();
//         Queue<String> queue = new LinkedList<>();
//         queue.add(beginWord);
//         distance.put(beginWord, 0);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 String word = queue.poll();
//                 Set<String> set = map.getOrDefault(word, new HashSet<>());
//                 map.put(word, set);
//                 for (String s : wordList) {
//                     int cnt = 0;
//                     for (int j = 0; j < word.length(); j++) {
//                         if (s.charAt(j) != word.charAt(j)) {
//                             cnt++;
//                         }
//                     }
//                     if (cnt == 1) {
//                         if (!distance.containsKey(s)) {
//                             queue.add(s);
//                             distance.put(s, distance.get(word) + 1);
//                         }
//                         set.add(s);
//                     }
//                 }
//             }
//         }
//         return map;
//     }
    
// }



class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, dict);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, map, res, path);
        return res;
        
    }
    
    public void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String next : map.get(beginWord)) {
            path.add(next);
            findLadders(next, endWord, map, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    public Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        end.add(endWord);
        boolean found = false;
        boolean isBackward = false;
        while (!start.isEmpty() && !found) {
            if (start.size() > end.size()) {
                Set<String> tem = start;
                start = end;
                end = tem;
                isBackward = !isBackward;
            }
            Set<String> set = new HashSet<>();
            for (String cur : start) {
                visited.add(cur);
                for (String next : getNext(cur, dict)) {
                    if (visited.contains(next) || start.contains(next)) {
                        continue;
                    }
                    if (end.contains(next)) {
                        found = true;
                    }
                    set.add(next);
                    String parent = isBackward ? next : cur;
                    String child = isBackward ? cur : next;
                    if (!map.containsKey(parent)) {
                        map.put(parent, new ArrayList<>());
                    }
                    map.get(parent).add(child);
                    
                }
            }
            start = set;
        }
        return map;
        
    }
    private List<String> getNext(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
            chars[i] = old;
        }
        return res;
    }
}