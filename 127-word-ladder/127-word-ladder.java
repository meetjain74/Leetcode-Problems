class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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
                
                for (String w: wordList) {
                    if (areAdjacent(curr,w) && !visited.contains(w)) {
                        q.add(w);
                        visited.add(w);
                    }
                }
            }
            
            moves++;
        }
        
        return 0;
    }
    
    private boolean areAdjacent(String s1,String s2) {
        int n = s1.length();
        int count = 0;
        for (int i=0;i<n;i++) {
            count += ( s1.charAt(i)!=s2.charAt(i) ? 1 : 0 );
            if (count>1)
                return false;
        }
        
        return count==1;
    }
}