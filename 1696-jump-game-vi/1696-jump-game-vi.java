class Pair implements Comparable<Pair>{
    int score;
    int index;
    
    Pair(int score,int index) {
        this.score=score;
        this.index=index;
    }
    
    // Descending order of score
    public int compareTo(Pair p) {
        return p.score-this.score;
    }
}

class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(nums[0],0));
        int maxScore = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            while (i-pq.peek().index>k) {
                // Max score index is not k far from current index
                pq.poll();
            }
            Pair curr = pq.peek();
            maxScore = curr.score+nums[i];
            pq.add(new Pair(maxScore,i));
        }
        
        return maxScore;
    }
}