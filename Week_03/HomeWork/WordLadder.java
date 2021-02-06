class Solution {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        //先把wordList 的单词放到哈希表里
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        // 第2步，图的广度优先遍历，必须使用队列表示是否访问过的visited哈希表

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        //第3步，开始广度优先遍历，包含起点
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for(int i = 0; i < currentSize;i++) {
                String currentWord = queue.poll();
                // 如果currentWord能够修改一个字符与endWord相同，则返回step+1
                if(changeWordEveryOneLetter(currentWord,endWord,queue,visited,wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }
        /**
    尝试currentWord修改每一个字符，看看是不是能与endWord匹配
    
    *
    */
    private boolean changeWordEveryOneLetter(String currentWord,String endWord,Queue<String>queue,Set<String>visited,Set<String>wordSet) {
        char[] charArray = currentWord.toCharArray();
        for(int i = 0; i < endWord.length();i++) {
            char originChar = charArray[i];
            for(char k = 'a';k <='z';k++) {
                if(k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)) {
                    if(nextWord.equals(endWord)) {
                        return true;
                    }
                    if(!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        //添加到队列以后，得标记已访问过
                        visited.add(nextWord);
                    }
                }

            }
            charArray[i] = originChar;
        }
        return false;
    }
}