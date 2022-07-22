class Pair implements Comparable<Pair> {
    int left;
    int right;
    
    Pair(int left,int right) {
        this.left=left;
        this.right=right;
    }
    
    // Ascending order of right
    public int compareTo(Pair p) {
        return p.right==this.right ? this.left-p.left : this.right-p.right;
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int[] p: pairs) {
            pq.add(new Pair(p[0],p[1]));
        }
        
        int len = 0;
        Pair prev = new Pair(-1001,-1001);
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.left>prev.right) {
                len++;
                prev=p;
            }
        }
        
        return len;
    }
}