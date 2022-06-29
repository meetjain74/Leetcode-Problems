class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for (String s: deadends) {
            set.add(s);
        }
        HashSet<String> visited = new HashSet<>();
        
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        int moves=0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                String curr = q.poll();
                
                if (set.contains(curr))
                    continue;
                
                if (target.equals(curr))
                    return moves;
                
                StringBuilder temp = new StringBuilder(curr);
                for (int j=0;j<4;j++) {
                    char ch = temp.charAt(j);
                    String s1 = temp.substring(0,j) + (ch=='9'?0:ch-'0'+1) +
                                temp.substring(j+1);
                    String s2 = temp.substring(0,j) + (ch=='0'?9:ch-'0'-1) +
                                temp.substring(j+1);
                    
                    if (!visited.contains(s1) && !set.contains(s1)) {
                        q.add(s1);
                        visited.add(s1);
                    }
                    
                    if (!visited.contains(s2) && !set.contains(s2)) {
                        q.add(s2);
                        visited.add(s2);
                    }
                }
            }
            
            moves++;
        }
        
        return -1;
    }
}