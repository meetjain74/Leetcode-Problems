class Solution {
    class Interval implements Comparable<Interval> {
        int start;
        int end;
        
        public Interval(int start,int end) {
            this.start=start;
            this.end=end;
        }
        
        public int compareTo(Interval x) {
            int diffStart = this.start-x.start;
            int diffEnd = this.end-x.end;
            
            return diffStart!=0 ? diffStart : diffEnd;
        }
        
        public String toString() {
            return this.start+" "+this.end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        List<Interval> ans = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        for (int[] i: intervals) {
            pq.add( new Interval(i[0],i[1]) );
        }
        
        Interval curr = pq.poll();
        while (pq.size()!=0) {
            Interval i = pq.poll();
            if (i.start==curr.start)
                curr.end=i.end;
            else if (i.start<=curr.end)
                curr.end=Math.max(i.end,curr.end);
            else {
                ans.add(curr);
                curr=i;
            }
        }
        ans.add(curr);
        
        int[][] res = new int[ans.size()][2];
        int j=0;
        for (Interval i: ans) {
            res[j][0]=i.start;
            res[j][1]=i.end;
            j++;
        }
        
        return res;
    }
}