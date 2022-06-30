class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for (String w: wordList) {
            wordSet.add(w);
        }
        
        HashSet<String> visited = new HashSet<>();
        
        // BFS
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int moves=1;
        visited.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                String curr = q.poll();
                
                if (curr.equals(endWord))
                    return moves;
                
                for (int j=0;j<curr.length();j++) {
                    char[] chars = curr.toCharArray();
                    for (char ch='a';ch<='z';ch++) {
                        chars[j] = ch;
                        String temp = new String(chars);
                        if (wordSet.contains(temp) && !visited.contains(temp)) {
                            q.add(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
            
            moves++;
        }
        
        return 0;
    }
}